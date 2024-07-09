package com.example.projectspringrupp.domain;

import com.example.projectspringrupp.domain.Brand;
import com.example.projectspringrupp.domain.Category;
import com.example.projectspringrupp.domain.Supplier;
import com.example.projectspringrupp.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

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

    @Column(columnDefinition = "TEXT")
    private String description;
    private Integer quantity;
    private BigDecimal basePrice;
    private BigDecimal salePrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplier;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
}
