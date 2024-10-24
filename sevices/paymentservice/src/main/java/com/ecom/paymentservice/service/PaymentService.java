package com.ecom.paymentservice.service;

import com.ecom.paymentservice.model.PaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    public Integer createPayment(@Valid PaymentRequest paymentRequest) {
        return null;
    }
}
