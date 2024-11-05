package com.hiep.mart.repository;

import com.hiep.mart.domain.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, String> {

    @Query(nativeQuery = true, value = Queries.FIND_DISTRICT_BY_PROVINCE_CODE)
    List<District> findDistrictByProvinceCode(String provinceCode);
}
