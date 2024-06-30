package com.example.projectspringrupp.mapper;

import com.example.projectspringrupp.domain.Brand;
import com.example.projectspringrupp.feature.brand.dto.BrandCreateRequest;
import com.example.projectspringrupp.feature.brand.dto.BrandResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface BrandMapper {
    BrandResponse toBrandResponse(Brand brand);
    Brand fromBrandCreateRequest(BrandCreateRequest brandCreateRequest);
    List<BrandResponse> toBrandResponseList(List<Brand> brands);
    void fromBrandUpdateRequest(BrandCreateRequest brandCreateRequest, @MappingTarget Brand brand);
}
