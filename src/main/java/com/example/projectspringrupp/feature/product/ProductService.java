package com.example.projectspringrupp.feature.product;

import com.example.projectspringrupp.feature.product.dto.ProductCreateRequest;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import com.example.projectspringrupp.feature.product.dto.ProductUpdateRequest;

import java.util.List;

public interface ProductService {
    // create product
    ProductResponse createNewProduct(ProductCreateRequest productCreateRequest);

    // find all product
    List<ProductResponse> findAllProduct();

    //Find product by name
    ProductResponse findProductByName(String productName);

    //Update product by name
    ProductResponse UpdateProduct(String productName, ProductUpdateRequest productUpdateRequest);
    //Delete product
    void deleteProduct(String productName);
}
