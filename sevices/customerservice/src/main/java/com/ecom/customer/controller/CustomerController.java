package com.ecom.customer.controller;

import com.ecom.customer.model.CustomerRequest;
import com.ecom.customer.model.CustomerResponse;
import com.ecom.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(service.createCustomer(request));
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest request) {
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/getCustomer")
    public ResponseEntity<List<CustomerResponse>> findAllCustomer() {
        return ResponseEntity.ok(service.findAllCustomer());
    }
    @GetMapping("/exits/{customerId}")
    public ResponseEntity<Boolean> existsById(@PathVariable String customerId) {
        return ResponseEntity.ok(service.existsById(customerId));
    }
    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String customerId) {
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }
    @DeleteMapping("/removeCustomer/{customerId}")
    public ResponseEntity<Void> removeCustomer(@PathVariable String customerId) {
        service.removeCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}
