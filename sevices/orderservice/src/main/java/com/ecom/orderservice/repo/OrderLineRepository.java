package com.ecom.orderservice.repo;

import com.ecom.orderservice.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {

    List<OrderLine> findAllByOrderOrderId(Integer orderId);
}
