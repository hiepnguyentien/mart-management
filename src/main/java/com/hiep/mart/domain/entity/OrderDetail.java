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
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @SequenceGenerator(name = "order_detail_sequence", sequenceName = "order_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_detail_sequence")
    @Column(name = "order_detail_id")
    Long orderDetailId;
    @Column(name = "order_detail_quantity")
    Long orderDetailQuantity;
    @Column(name = "order_detail_price")
    Double orderDetailPrice;
    @Column(name = "order_detail_status")
    String orderDetailStatus;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products products;
}
