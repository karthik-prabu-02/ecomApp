package com.ecom.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
