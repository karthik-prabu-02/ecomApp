package com.ecom.orderservice.controller;

import com.ecom.orderservice.model.OrderLineResponse;
import com.ecom.orderservice.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orderLines")
public class OrderLineServiceController {
    private final OrderLineService orderLineService;
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<List<OrderLineResponse>> findAllByOrderOrderId(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderLineService.findAllByOrderOrderId(orderId));
    }
}
