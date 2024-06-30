package com.example.projectspringrupp.feature.product;

import com.example.projectspringrupp.domain.Product;
import com.example.projectspringrupp.feature.product.dto.ProductCreateRequest;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import com.example.projectspringrupp.feature.product.dto.ProductUpdateRequest;
import com.example.projectspringrupp.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    // Create product
    @Override
    public ProductResponse createNewProduct(ProductCreateRequest productCreateRequest) {
        // validate product name
        if (productRepository.existsByProductName(productCreateRequest.productName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This product is already exist!");
        }
        // transfer DTO domain model
        Product product = productMapper.fromProductCreateRequest(productCreateRequest);
        product = productRepository.save(product);

        // system generate date
        product.setProductName(product.getProductName());
        product.setDescription((product.getDescription()));
        product.setQuantity(product.getQuantity());
        product.setBasePrice(product.getBasePrice());
        product.setSalePrice(product.getSalePrice());

        // save product to database
        product = productRepository.save(product);

        return productMapper.toProductResponse(product);
    }

    // Find all product
    @Override
    public List<ProductResponse> findAllProduct() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductResponseList(products);
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
