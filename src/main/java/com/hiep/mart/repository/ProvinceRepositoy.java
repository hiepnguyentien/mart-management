package com.hiep.mart.repository;

import com.hiep.mart.domain.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepositoy extends JpaRepository<Province, String> {
}
