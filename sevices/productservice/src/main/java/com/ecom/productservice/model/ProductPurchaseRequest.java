package com.ecom.productservice.model;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product is mandatory")
        Integer productId,
        @NotNull(message = "Product quantity is mandatory")
        double productQuantity
) {

}
