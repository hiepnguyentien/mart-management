package com.hiep.mart.repository;

import com.hiep.mart.domain.dto.UserDTO;
import com.hiep.mart.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    @Query("SELECT u.customers.customerId FROM Users u WHERE u.userId = :userId")
    Long findCustomerIdByUserId(@Param("userId") Long userId);
}
