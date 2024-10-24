package com.ecom.orderservice.model;

public record CustomerResponse(
        String customerId,
        String firstName,
        String lastName,
        String email

) {
}
