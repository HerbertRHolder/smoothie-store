package com.store.smoothies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.smoothies.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Component
public interface ProductRepository  extends JpaRepository<Product, Long> {

    Product findByName(String name);
}
