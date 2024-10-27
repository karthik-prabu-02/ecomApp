package com.ecom.orderservice.service;

import com.ecom.orderservice.model.OrderLineRequest;
import com.ecom.orderservice.model.OrderLineResponse;
import com.ecom.orderservice.repo.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = orderLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getOrderLineId();
    }

    public List<OrderLineResponse> findAllByOrderOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
