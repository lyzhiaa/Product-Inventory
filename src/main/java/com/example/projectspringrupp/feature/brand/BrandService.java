package com.example.projectspringrupp.feature.brand;

import com.example.projectspringrupp.feature.brand.dto.BrandCreateRequest;
import com.example.projectspringrupp.feature.brand.dto.BrandResponse;

import java.util.List;

public interface BrandService {
    // Create brand
    BrandResponse createBrand(BrandCreateRequest brandCreateRequest);
    //find all brand
    List<BrandResponse> findAllBrand(int page, int size);
    // find brand by name
    BrandResponse findBrandByName(String brandName);
    // Update brand
    BrandResponse UpdateBrand(String brandName, BrandCreateRequest brandCreateRequest);
    // Delete supplier
    void deleteBrand(String brandName);
}
