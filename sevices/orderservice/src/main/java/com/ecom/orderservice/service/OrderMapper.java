package com.ecom.orderservice.service;

import com.ecom.orderservice.entity.Order;
import com.ecom.orderservice.model.OrderRequest;
import com.ecom.orderservice.model.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request){
        return Order.builder()
                .orderId(request.orderId())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.totalAmount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getOrderId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
