package com.ecom.productservice.model;

import com.ecom.productservice.entity.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

public record ProductRequest (
        Integer productId,
        @NotNull(message = "Product name is required")
        String productName,
        @NotNull(message = "Product description is required")
        String description,
        @Positive(message = "Available quantity must be positive")
        double availableQuantity,
        @Positive(message = "Available price must be positive")
        BigDecimal prices,
        @NotNull(message = "Product category is required")
        Integer categoryId

) {
}
