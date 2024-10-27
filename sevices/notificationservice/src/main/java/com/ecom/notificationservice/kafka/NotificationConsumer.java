package com.ecom.notificationservice.kafka;

import com.ecom.notificationservice.service.EmailService;
import com.ecom.notificationservice.entity.Notification;
import com.ecom.notificationservice.entity.NotificationType;
import com.ecom.notificationservice.model.OrderConfirmation;
import com.ecom.notificationservice.model.PaymentConfirmation;
import com.ecom.notificationservice.repo.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    public final NotificationRepository notificationRepository;
    private final EmailService emailService;
    // paymentNotification object and producer object must have same fild and name
    @KafkaListener(topics = "payment-topic" , groupId = "paymentGroup")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Consuming message from payment-topic :: {}", paymentConfirmation);
        notificationRepository.save(
                Notification.builder()
                        .notificationType(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        // send Email
        var customerName = paymentConfirmation.customerFirstName()+ " " + paymentConfirmation.customerLastName();
        emailService.sendPaymentSucessEmail(
                customerName,
                paymentConfirmation.customerEmail(),
                paymentConfirmation.totalAmount(),
                paymentConfirmation.OrderReference()
        );
    }
             // paymentNotification object and producer object must have same fild and name
    @KafkaListener(topics = "order-topic" , groupId = "orderGroup")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Consuming message from order-topic :: {}", orderConfirmation);
        notificationRepository.save(
                Notification.builder()
                        .notificationType(NotificationType.ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        // send Email
        var customerName = orderConfirmation.customer().firstName()+ " " + orderConfirmation.customer().lastName();
        emailService.sendOrderConfirmationEmail(
                customerName,
                orderConfirmation.customer().email(),
                orderConfirmation.totalAmount(),
                orderConfirmation.OrderReference(),
                orderConfirmation.products()
        );

    }
}
