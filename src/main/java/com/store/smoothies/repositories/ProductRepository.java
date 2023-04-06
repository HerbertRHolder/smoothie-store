package com.store.smoothies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.smoothies.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long>{
    @Override
    List<Product> findAll();
    @Override
    Optional<Product> findById(Long aLong);
}
