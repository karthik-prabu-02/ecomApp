package com.ecom.orderservice.model;

import com.ecom.orderservice.entity.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse(
        Integer orderId,
        String reference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String customerId

) {
}
