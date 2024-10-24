package com.ecom.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_order")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue
    private Integer orderId;
    private String reference;
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private String customerId;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
}
