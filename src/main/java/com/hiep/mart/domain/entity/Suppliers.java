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
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @SequenceGenerator(name = "supplier_sequence", sequenceName = "supplier_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_sequence")
    @Column(name = "supplier_id")
    Long supplierId;
    @Column(name = "supplier_name")
    String supplierName;
    @Column(name = "supplier_address")
    String supplierAddress;
    @Column(name = "supplier_phone")
    String supplierPhone;
    @Column(name = "supplier_email")
    String supplierEmail;
    @Column(name = "supplier_status")
    String supplierStatus;

    @OneToMany(mappedBy = "suppliers")
    Set<Products> products;
}
