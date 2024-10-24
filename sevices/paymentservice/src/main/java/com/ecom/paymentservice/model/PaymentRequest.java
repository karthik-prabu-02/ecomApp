package com.ecom.paymentservice.model;

import com.ecom.paymentservice.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest (
        Integer paymentId,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
){
}
