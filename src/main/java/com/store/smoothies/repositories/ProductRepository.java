package com.store.smoothies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.smoothies.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
