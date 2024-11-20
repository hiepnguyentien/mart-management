package com.hiep.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hiep.mart.domain.entity.Products;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>, ProductRepositoryCustom{

    @Query(nativeQuery = true, value = Queries.SEARCH_PRODUCT_BY_CATEGORY)
    List<Products> findByCategory(Long categoryId);

}
