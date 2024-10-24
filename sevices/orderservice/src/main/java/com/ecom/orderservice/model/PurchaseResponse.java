package com.ecom.orderservice.model;

import java.math.BigDecimal;

public record PurchaseResponse(
        Integer productId,
        String productName,
        String description,
        BigDecimal price,
        double quantity
) {
}
