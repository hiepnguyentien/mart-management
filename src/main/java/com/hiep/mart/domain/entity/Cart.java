package com.hiep.mart.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_sequence", sequenceName = "cart_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")
    @Column(name = "cart_id")
    Long cartId;
    @Column(name = "quantity")
    Long quantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customers customers;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products products;
}
