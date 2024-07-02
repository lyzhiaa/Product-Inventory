package com.example.projectspringrupp.feature.product;

import com.example.projectspringrupp.domain.*;
import com.example.projectspringrupp.feature.brand.BrandRepository;
import com.example.projectspringrupp.feature.category.CategoryRepository;
import com.example.projectspringrupp.feature.product.dto.ProductCreateRequest;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import com.example.projectspringrupp.feature.product.dto.ProductUpdateRequest;
import com.example.projectspringrupp.feature.supplier.SupplierRepository;
import com.example.projectspringrupp.feature.user.UserRepository;
import com.example.projectspringrupp.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;

    // Create product
    @Override
    public ProductResponse createNewProduct(ProductCreateRequest productCreateRequest) {

        Product product = productMapper.fromProductCreateRequest(productCreateRequest);

        // validate product name
        if (productRepository.existsByProductName(productCreateRequest.productName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This product is already exist!");
        }

        Supplier supplier = supplierRepository.findByFirstname(productCreateRequest.supplierName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "This Supplier is not found!"));


        Category category = categoryRepository.findByCategoryName(productCreateRequest.categoryName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "This category is not found!"));

        Brand brand = brandRepository.findByBrandName(productCreateRequest.brandName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "This brand is not found!"));



        // transfer DTO domain model


        // system generate date
        product.setCategory(category);
        product.setBrand(brand);
        product.setSupplier(supplier);


        // save product to database
        product = productRepository.save(product);

        return productMapper.toProductResponse(product);
    }

    // Find all product
    @Override
    public List<ProductResponse> findAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);
        return productMapper.toProductResponseList(products.getContent());
    }

    // Find product by name
    @Override
    public ProductResponse findProductByName(String productName) {
        Product product = productRepository.findByProductName(productName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "This product is not found!"));
        return productMapper.toProductResponse(product);
    }

    // Update product by name
    @Override
    public ProductResponse UpdateProduct(String productName, ProductUpdateRequest productUpdateRequest) {
        Product product = productRepository.findByProductName(productName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "We can not find this product."));
        productMapper.fromProductUpdateRequest(productUpdateRequest, product);
        product = productRepository.save(product);

        return productMapper.toProductResponse(product);
    }

    // delete product
    @Override
    public void deleteProduct(String productName) {
        Product product = productRepository.findByProductName(productName).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Can't delete this product because it is not found."));
        productRepository.delete(product);
    }
}
