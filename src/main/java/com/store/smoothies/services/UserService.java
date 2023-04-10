//package com.store.smoothies.services;
//
//import com.store.smoothies.models.Product;
//import com.store.smoothies.models.User;
//import com.store.smoothies.repositories.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//    private final UserRepository repo;
//
//    public UserService(UserRepository u) {
//        this.repo = u;
//    }
//
//    public User findById(Long id) {
//        return repo.findById(id).orElse(null);
//    }
//
//    public List<User> findAll() {
//        return repo.findAll();
//    }
//
//    public User findByName(String name) {
//        return this.repo.findByName(name);
//    }
//}
