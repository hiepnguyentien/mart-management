package com.hiep.mart.repository;

import com.hiep.mart.domain.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Long> {
}
