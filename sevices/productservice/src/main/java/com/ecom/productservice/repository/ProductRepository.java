package com.ecom.productservice.repository;

import com.ecom.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByProductIdInOrderByProductId(List<Integer> productId);
}
