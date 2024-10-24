package com.ecom.productservice.model;

import com.ecom.productservice.entity.Category;

import java.math.BigDecimal;

public record ProductResponse(
        Integer productId,
        String productName,
        String description,
        double availableQuantity,
        BigDecimal prices,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
