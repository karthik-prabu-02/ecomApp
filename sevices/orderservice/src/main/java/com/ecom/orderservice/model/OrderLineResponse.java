package com.ecom.orderservice.model;

public record OrderLineResponse(
        Integer orderLineId,
        double productQuantity
) {
}
