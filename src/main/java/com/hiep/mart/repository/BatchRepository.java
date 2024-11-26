package com.hiep.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiep.mart.domain.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>, BatchRepositoryCustom{
    
}
