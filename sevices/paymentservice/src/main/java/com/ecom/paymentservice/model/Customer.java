package com.ecom.paymentservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String customerId,
        @NotNull(message = "firstName is required")
        String firstName,
        @NotNull(message = "lastName is required")
        String lastName,

        @NotNull(message = "firstName is required")
        @Email(message = "email is not in correct format")
        String emailId

) {
}
