package com.example.projectspringrupp.feature.supplier;

import com.example.projectspringrupp.domain.Product;
import com.example.projectspringrupp.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    Optional<Supplier> findBySupplierPhone(String supplierPhone);
    boolean existsBySupplierPhone(String SupplierPhone);
}
