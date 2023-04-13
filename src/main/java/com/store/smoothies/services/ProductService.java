package com.store.smoothies.services;


import com.store.smoothies.models.Product;
import com.store.smoothies.repositories.ProductRepository;
import com.store.smoothies.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Component
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository r) {
        this.repo = r;
    }

    public Product findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public String findByName(String name) {
        return repo.findByName(name).getName();
    }
}
