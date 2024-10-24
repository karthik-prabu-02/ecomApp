package com.ecom.customer.repository;

import com.ecom.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
