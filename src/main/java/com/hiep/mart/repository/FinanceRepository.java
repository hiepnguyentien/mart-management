package com.hiep.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiep.mart.domain.entity.Finance;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long>{
    
}
