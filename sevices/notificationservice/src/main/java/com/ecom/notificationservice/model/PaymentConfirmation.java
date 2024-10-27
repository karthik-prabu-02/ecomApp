package com.ecom.notificationservice.model;

import org.apache.kafka.common.protocol.types.Field;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String OrderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
