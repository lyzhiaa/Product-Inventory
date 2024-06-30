package com.example.projectspringrupp.feature.product;

import com.example.projectspringrupp.feature.product.dto.ProductCreateRequest;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import com.example.projectspringrupp.feature.product.dto.ProductUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    //create product
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ProductResponse createNewProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
        return productService.createNewProduct(productCreateRequest);
    }
    //find single product
    @GetMapping("/{name}")
    ProductResponse findProductName(@Valid @PathVariable String name) {
        return productService.findProductByName(name);
    }

    //find all product
    @GetMapping
    List<ProductResponse> findAllProduct() {
        return productService.findAllProduct();
    }

    //update product
    @PatchMapping("/{name}")
    ProductResponse updateByName(@Valid @PathVariable String name, @RequestBody ProductUpdateRequest productUpdateRequest) {
        return productService.UpdateProduct(name, productUpdateRequest);
    }

    //delete product
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    void deleteByName(@Valid @PathVariable String name) {
        productService.deleteProduct(name);
    }
}
