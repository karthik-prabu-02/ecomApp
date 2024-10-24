package com.ecom.customer.model;

import com.ecom.customer.entity.Address;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse (
        String customerId,
        String firstName,
        String lastName,
        String emailId,
        Address address
){
}
