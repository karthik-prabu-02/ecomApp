package com.ecom.customer.model;

import com.ecom.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String customerId,
        @NotNull(message = "Customer first name is required")
        String firstName,
        @NotNull(message = "Customer Last name is required")
        String lastName,
        @NotNull(message = "Customer Email is required")
        @Email(message = "Customer Email is not valid !")
        String emailId,
        Address address

) {
}
