package com.store.smoothies.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.store.smoothies.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}