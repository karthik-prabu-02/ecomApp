package com.ecom.customer.service;

import com.ctc.wstx.util.StringUtil;
import com.ecom.customer.entity.Customer;
import com.ecom.customer.model.CustomerRequest;
import com.ecom.customer.model.CustomerResponse;
import jakarta.validation.Valid;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer createCustomer(@Valid CustomerRequest request) {
        if (request==null) return null;
        return Customer.builder()
                .customerId(request.customerId())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .emailId(request.emailId())
                .address(request.address())
                .build();
    }

    public void mergeCustomer(Customer customer, @Valid CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) customer.setFirstName(request.firstName());
        if (StringUtils.isNotBlank(request.lastName())) customer.setLastName(request.lastName());
        if (StringUtils.isNotBlank(request.emailId())) customer.setEmailId(request.emailId());
        if (request.address() != null) customer.setAddress(request.address());
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
            customer.getCustomerId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmailId(),
            customer.getAddress()
        );
    }
}
