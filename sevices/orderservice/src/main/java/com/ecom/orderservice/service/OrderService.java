package com.ecom.orderservice.service;

import com.ecom.orderservice.client.CustomerClient;
import com.ecom.orderservice.client.PaymentClient;
import com.ecom.orderservice.client.ProductClient;
import com.ecom.orderservice.entity.Order;
import com.ecom.orderservice.exception.BusinessException;
import com.ecom.orderservice.kafka.OrderProducer;
import com.ecom.orderservice.model.*;
import com.ecom.orderservice.repo.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(@Valid OrderRequest request) {
        // Check customer - open frign
        CustomerResponse customer = this.customerClient.getCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("Cannot create order:: No customer exists with provided Id :: "+customerClient));
        // purchase product -> product microservice -> RestTemplate
        List<PurchaseResponse> purchasedProducts = this.productClient.purchaseProducts(request.products());
        // persist order
        Order order = this.orderRepository.save(orderMapper.toOrder(request));
        //persist order line
        for (PurchaseRequet purchaseRequet:request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getOrderId(),
                            purchaseRequet.productId(),
                            purchaseRequet.productQuantity()

                    )
            );
        }
        // start payment process
        var paymentrequest = new PaymentRequest(
                request.totalAmount(),
                request.paymentMethod(),
                order.getOrderId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentrequest);

        // send order confirmation -> notification microservice(Kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.totalAmount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        return order.getOrderId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());

    }

    public OrderResponse findOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(()-> new EntityNotFoundException(("No Order found with provided id:: "+orderId)));
    }
}
