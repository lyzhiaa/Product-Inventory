package com.example.projectspringrupp.feature.supplier;

import com.example.projectspringrupp.feature.supplier.dto.SupplierCreateRequest;
import com.example.projectspringrupp.feature.supplier.dto.SupplierResponse;
import com.example.projectspringrupp.feature.supplier.dto.SupplierUpdateRequest;

import java.util.List;

public interface SupplierService {
    // Create supplier by phone number
    SupplierResponse createSupplier(SupplierCreateRequest supplierCreateRequest);
    // Find all supplier
    List<SupplierResponse> findAllSupplier();
    // Find supplier by phone number
    SupplierResponse findSupplierByPhone(String phone);
    // Update supplier
    SupplierResponse updateSupplier(String phone, SupplierUpdateRequest supplierUpdateRequest);
    // Delete supplier by phone number
    void deleteSupplier(String phone);
}
