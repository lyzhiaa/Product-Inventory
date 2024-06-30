package com.example.projectspringrupp.mapper;

import com.example.projectspringrupp.domain.Product;
import com.example.projectspringrupp.feature.product.dto.ProductCreateRequest;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import com.example.projectspringrupp.feature.product.dto.ProductUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);
    Product fromProductCreateRequest(ProductCreateRequest productCreateRequest);
    List<ProductResponse> toProductResponseList(List<Product> products);
    void fromProductUpdateRequest(ProductUpdateRequest productUpdateRequest, @MappingTarget Product product);
}
