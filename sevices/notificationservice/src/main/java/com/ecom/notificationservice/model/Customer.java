package com.ecom.notificationservice.model;

public record Customer(
        String customerId,
        String firstName,
        String lastName,
        String email
) {
}
