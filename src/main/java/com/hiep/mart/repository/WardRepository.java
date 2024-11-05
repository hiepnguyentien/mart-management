package com.hiep.mart.repository;

import com.hiep.mart.domain.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, String> {
    @Query(nativeQuery = true, value = Queries.FIND_WARD_BY_DISTRICT_CODE)
    List<Ward> findWardByDistrictCode(String districtCode);
}
