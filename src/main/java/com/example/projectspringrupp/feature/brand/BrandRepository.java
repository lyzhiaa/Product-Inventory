package com.example.projectspringrupp.feature.brand;

import com.example.projectspringrupp.domain.Brand;
import com.example.projectspringrupp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByBrandName(String brandName);
    boolean existsByBrandName(String brandName);
}
