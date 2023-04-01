package com.store.smoothies.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.store.smoothies.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // FindByEmail is being used to find user's email within the login controller. //
    User findByEmail(String email);
    User findByUsername(String username);
}