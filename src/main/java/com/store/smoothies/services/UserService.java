package com.store.smoothies.services;

import com.store.smoothies.models.Product;
import com.store.smoothies.models.User;
import com.store.smoothies.repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterface {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final ProductService pRepo;
    public UserService(UserRepository ur, PasswordEncoder pe, ProductService pr) {
        this.repo = ur;
        this.passwordEncoder = pe;
        this.pRepo = pr;
    }
    public Optional<User> findById(@NotNull Long id)throws Exception{
        return this.repo.findById(id);
    }
    public List<User> findAll() throws NullPointerException {
        return this.repo.findAll();
    }
    @Override
    public User findByName(@NotNull String name) throws Exception {
        return this.repo.findByUsername(name);
    }
    public void registerUser(@NotNull User user)throws Exception{
        this.passwordEncoder.encode(user.getPassword());
        this.repo.save(user);
    }




}
