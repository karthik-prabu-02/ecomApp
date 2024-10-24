package com.ecom.orderservice.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequet(
        @NotNull(message = "Product is Mandatory")
        Integer productId,
        @Positive(message = "Quantity is Mandatory")
        double productQuantity
) {
}
