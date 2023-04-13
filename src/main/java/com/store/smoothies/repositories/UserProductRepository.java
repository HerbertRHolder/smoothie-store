package com.store.smoothies.repositories;

import com.store.smoothies.models.User;
import com.store.smoothies.models.UserProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProducts, Long> {
    @Query("SELECT up FROM UserProducts up JOIN up.user u WHERE u.id = :userId")
    List<UserProducts> getUserProductsById(@Param("userId") Long userId);
}
