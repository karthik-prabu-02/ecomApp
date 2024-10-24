package com.ecom.orderservice.controller;

import com.ecom.orderservice.model.OrderResponse;
import com.ecom.orderservice.model.OrderRequest;
import com.ecom.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderServiceController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequest request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }
    @GetMapping("/getOrders")
    public ResponseEntity<List<OrderResponse>> findAll() {
       return ResponseEntity.ok(orderService.findAll());
    }
    @GetMapping("/getOrders/{orderId}")
    public ResponseEntity<OrderResponse> findOrderById(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.findOrderById(orderId));
    }

}
