package com.ecom.orderservice.model;

import com.ecom.orderservice.entity.OrderLine;
import com.ecom.orderservice.entity.PaymentMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(
         Integer orderId,
         String reference,
         @Positive(message = "Order amount should be positive")
         BigDecimal totalAmount,
         @NotNull(message = "Payment method should be precised")
         PaymentMethod paymentMethod,
         @NotNull(message = "Customer should be present")
         @NotEmpty(message = "Customer should be present")
         @NotBlank(message = "Customer should be present")
         String customerId,
         @NotEmpty(message = "You should atleast purchase one product")
         List<PurchaseRequet> products
) {
}
