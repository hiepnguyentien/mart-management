package com.hiep.mart.domain.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @Column(name = "order_id")
    Long orderId;
    @Column(name = "order_code")
    String orderCode;
    @Column(name = "order_date")
    LocalDate orderDate;
    @Column(name = "order_status")
    String orderStatus;
    @Column(name = "order_total")
    Double orderTotal;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customers customers;

    @OneToMany(mappedBy = "orders")
    Set<OrderDetail> orderDetail;
}
