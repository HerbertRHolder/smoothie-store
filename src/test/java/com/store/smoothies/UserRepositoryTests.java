package com.store.smoothies;
import com.store.smoothies.repositories.UserRepository;
import com.store.smoothies.models.User;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    // test methods go below
    @Test
    @Order(1)
    public void testCreateUsers() {
        User savedUser = new User();
        User user = new User();
            user.setUsername("ravikumar@gmail.com");
            user.setPassword("ravi2020");
            user.setFirstName("Ravi");
            user.setLastName("Kumar");
            savedUser = repo.save(user);



        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
        repo.delete(user);
    }
    @Test
    @Order(2)
    public void testGetUser(){

    }
}