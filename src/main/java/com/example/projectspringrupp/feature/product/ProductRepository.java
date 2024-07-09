package com.example.projectspringrupp.feature.product;

import com.example.projectspringrupp.domain.Product;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductName(String productName);
    boolean existsByProductName(String productName);

}
