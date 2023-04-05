package com.store.smoothies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.smoothies.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);



}