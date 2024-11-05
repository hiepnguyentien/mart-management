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
@Table(name = "administrative_regions")
public class AdministrativeRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "name_en", nullable = false)
    String nameEn;

    @Column(name = "code_name")
    String codeName;

    @Column(name = "code_name_en")
    String codeNameEn;
}
