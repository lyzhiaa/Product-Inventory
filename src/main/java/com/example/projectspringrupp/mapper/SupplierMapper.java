package com.example.projectspringrupp.mapper;

import com.example.projectspringrupp.domain.Product;
import com.example.projectspringrupp.domain.Supplier;
import com.example.projectspringrupp.feature.product.dto.ProductCreateRequest;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import com.example.projectspringrupp.feature.product.dto.ProductUpdateRequest;
import com.example.projectspringrupp.feature.supplier.dto.SupplierCreateRequest;
import com.example.projectspringrupp.feature.supplier.dto.SupplierResponse;
import com.example.projectspringrupp.feature.supplier.dto.SupplierUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface SupplierMapper{
    SupplierResponse toSupplierResponse(Supplier supplier);
    Supplier fromSupplierCreateRequest(SupplierCreateRequest supplierCreateRequest);
    List<SupplierResponse> toSupplierResponseList(List<Supplier> suppliers);
    void fromSupplierUpdateRequest(SupplierUpdateRequest supplierUpdateRequest, @MappingTarget Supplier supplier);
}
