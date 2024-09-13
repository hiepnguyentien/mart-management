package com.hiep.mart.domain.entity;

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
@Table(name = "customers")
public class Customers extends Person {
    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @Column(name = "customer_id")
    Long customerId;
    @Column(name = "customer_status")
    String customerStatus;
    @Column(name = "accumulated_points")
    Double accumulatedPoints;

    @OneToMany(mappedBy = "customers")
    Set<Orders> orders;
}
