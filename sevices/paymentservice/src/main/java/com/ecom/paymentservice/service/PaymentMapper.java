package com.ecom.paymentservice.service;

import com.ecom.paymentservice.entity.Payment;
import com.ecom.paymentservice.model.PaymentRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(@Valid PaymentRequest paymentRequest) {
        return Payment.builder()
                .paymentId(paymentRequest.paymentId())
                .orderId(paymentRequest.orderId())
                .paymentMethod(paymentRequest.paymentMethod())
                .totalAmount(paymentRequest.totalAmount())
                .build();
    }
}
