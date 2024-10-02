package com.hiep.mart.domain.entity;

import java.time.LocalDate;
import java.util.Set;

import com.hiep.mart.domain.enumeration.CustomerStatus;
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
public class Customers {
    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @Column(name = "customer_id")
    Long customerId;
    @Column(name = "customer_status")
    CustomerStatus customerStatus;
    @Column(name = "accumulated_points")
    Double accumulatedPoints;

    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(name = "address")
    String address;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    String email;
    @Column(name = "phone_number", nullable = false, unique = true)
    String phoneNumber;
    @Column(name = "gender")
    String gender;
    @Column(name = "date_of_birth", nullable = false)
    LocalDate dateOfBirth;

    @OneToMany(mappedBy = "customers")
    Set<Orders> orders;
}
