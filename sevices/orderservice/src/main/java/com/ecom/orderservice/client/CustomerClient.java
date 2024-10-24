package com.ecom.orderservice.client;

import com.ecom.orderservice.model.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customerservice",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {
    @GetMapping("/getCustomer/{customerId}")
    Optional<CustomerResponse> getCustomerById(@PathVariable String customerId);
}
