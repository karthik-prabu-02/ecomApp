package com.ecom.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Integer orderLineId;
    @ManyToOne
    @JoinColumn(name = "order_orderId")
    private Order order;
    private Integer productId;
    private double productQuantity;

}
