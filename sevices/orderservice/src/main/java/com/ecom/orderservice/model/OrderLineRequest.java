package com.ecom.orderservice.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderLineRequest(
        Integer orderLineId,
        Integer orderId,
        Integer productId,
        double productQuantity
) {
}
