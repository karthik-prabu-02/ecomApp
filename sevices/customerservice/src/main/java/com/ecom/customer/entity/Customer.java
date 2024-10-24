package com.ecom.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String emailId;
    private Address address;
}
