package com.ecom.paymentservice.service;

import com.ecom.paymentservice.kafka.NotificationProducer;
import com.ecom.paymentservice.model.PaymentNotificationRequest;
import com.ecom.paymentservice.model.PaymentRequest;
import com.ecom.paymentservice.repo.PaymentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;
    public Integer createPayment(@Valid PaymentRequest paymentRequest) {
        var payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        // send notification to notification service
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        paymentRequest.orderReference(),
                        paymentRequest.totalAmount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstName(),
                        paymentRequest.customer().lastName(),
                        paymentRequest.customer().emailId()
                )
        );
        return payment.getPaymentId();
    }
}
