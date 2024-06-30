package com.example.projectspringrupp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    @Column(columnDefinition = "TEXT DEFAULT 'Invalid name'")
    private String description;
    private Integer quantity;
    private BigDecimal basePrice;
    private BigDecimal salePrice;

    @ManyToOne
    private Brand brand;
}
