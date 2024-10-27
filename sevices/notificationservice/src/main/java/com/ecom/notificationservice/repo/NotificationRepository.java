package com.ecom.notificationservice.repo;

import com.ecom.notificationservice.entity.Notification;
import com.ecom.notificationservice.model.PaymentConfirmation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,String> {
}
