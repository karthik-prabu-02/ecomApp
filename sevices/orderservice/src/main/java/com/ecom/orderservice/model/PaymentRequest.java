package com.ecom.orderservice.model;

import com.ecom.orderservice.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
