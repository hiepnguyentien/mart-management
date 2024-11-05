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
@Table(name = "districts")
public class District {

    @Id
    @Column(name = "code", length = 20)
    String code;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "name_en")
    String nameEn;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "full_name_en")
    String fullNameEn;

    @Column(name = "code_name")
    String codeName;

    @ManyToOne
    @JoinColumn(name = "province_code")
    Province province;

    @ManyToOne
    @JoinColumn(name = "administrative_unit_id")
    AdministrativeUnit administrativeUnit;
}
