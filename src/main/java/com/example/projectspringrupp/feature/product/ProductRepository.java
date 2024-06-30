package com.example.projectspringrupp.feature.product;

import com.example.projectspringrupp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductName(String productName);
    boolean existsByProductName(String productName);
}
