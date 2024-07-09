package com.example.projectspringrupp.mapper;

import com.example.projectspringrupp.domain.Product;
import com.example.projectspringrupp.feature.product.dto.ProductCreateRequest;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import com.example.projectspringrupp.feature.product.dto.ProductUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryName", source = "category.categoryName")
    @Mapping(target = "brandName", source = "brand.brandName")
    @Mapping(target = "supplierName", source = "supplier.firstname")
    ProductResponse toProductResponse(Product product);

    Product fromProductCreateRequest(ProductCreateRequest productCreateRequest);

    List<ProductResponse> toProductResponseList(List<Product> products);

    void fromProductUpdateRequest(ProductUpdateRequest productUpdateRequest, @MappingTarget Product product);
}

