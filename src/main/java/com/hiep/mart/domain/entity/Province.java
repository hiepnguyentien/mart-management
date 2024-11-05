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
@Table(name = "provinces")
public class Province {

    @Id
    @Column(name = "code", length = 20)
    String code;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "name_en")
    String nameEn;

    @Column(name = "full_name", nullable = false)
    String fullName;

    @Column(name = "full_name_en")
    String fullNameEn;

    @Column(name = "code_name")
    String codeName;

    @ManyToOne
    @JoinColumn(name = "administrative_unit_id")
    AdministrativeUnit administrativeUnit;

    @ManyToOne
    @JoinColumn(name = "administrative_region_id")
    AdministrativeRegion administrativeRegion;
}
