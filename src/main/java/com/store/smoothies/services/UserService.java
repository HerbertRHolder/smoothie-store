package com.store.smoothies.services;

import com.store.smoothies.models.User;
import com.store.smoothies.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterface {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository ur,PasswordEncoder pe) {
        this.repo = ur;
        this.passwordEncoder = pe;
    }

    public Optional<User> findById(Long id){
        return this.repo.findById(id);
    }
    public List<User> findAll(){
        return repo.findAll();
    }

    @Override
    public User findByName(String name) {
        return this.repo.findByUsername(name);
    }


}
