package com.ecom.orderservice.service;

import com.ecom.orderservice.entity.Order;
import com.ecom.orderservice.entity.OrderLine;
import com.ecom.orderservice.model.OrderLineRequest;
import com.ecom.orderservice.model.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .orderLineId(orderLineRequest.orderLineId())
                .productQuantity(orderLineRequest.productQuantity())
                .order(
                        Order.builder()
                                .orderId(orderLineRequest.orderId())
                                .build()
                )
                .productId(orderLineRequest.productId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getOrderLineId(),
                orderLine.getProductQuantity()
        );
    }
}
