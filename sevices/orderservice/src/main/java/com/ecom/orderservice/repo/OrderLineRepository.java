package com.ecom.orderservice.repo;

import com.ecom.orderservice.entity.OrderLine;
import com.ecom.orderservice.model.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
