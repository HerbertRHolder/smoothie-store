package com.store.smoothies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.smoothies.models.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}