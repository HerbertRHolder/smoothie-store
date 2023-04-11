package com.store.smoothies.repositories;

import com.store.smoothies.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProduct extends JpaRepository<UserProduct, Long> {
    @Query("SELECT u FROM User u JOIN u.id as up WHERE up.product.id IN :productIds")
    List<User> findByProductIds(@Param("productIds") List<Long> productIds);
}
