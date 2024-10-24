package com.ecom.productservice.model;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer productId,
        String productName,
        String productDescription,
        BigDecimal price,
        double quantity
) {
}
