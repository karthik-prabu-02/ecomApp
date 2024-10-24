package com.ecom.customer.service;

import com.ecom.customer.entity.Customer;
import com.ecom.customer.exception.CustomerNotFoundException;
import com.ecom.customer.model.CustomerRequest;
import com.ecom.customer.model.CustomerResponse;
import com.ecom.customer.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(@Valid CustomerRequest request) {
        Customer customer =repository.save(mapper.createCustomer(request));
        return customer.getCustomerId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        Customer customer = repository.findById(request.customerId())
                .orElseThrow(
                        () -> new CustomerNotFoundException(
                                "Cannot update customer. No customer found with this customer id : " +request.customerId()
                        )
                );
        mapper.mergeCustomer(customer , request);
        repository.save(customer);

    }

    public List<CustomerResponse> findAllCustomer() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String customerId) {
        return repository.findById(customerId)
                .isPresent();
    }

    public CustomerResponse getCustomerById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(
                        ()->new CustomerNotFoundException(String.format("No Customer Found with the provided ID :: %s",customerId))
                );
    }

    public void removeCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
