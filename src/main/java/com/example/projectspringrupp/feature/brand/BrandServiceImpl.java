package com.example.projectspringrupp.feature.brand;

import com.example.projectspringrupp.domain.Brand;
import com.example.projectspringrupp.domain.Product;
import com.example.projectspringrupp.feature.brand.dto.BrandCreateRequest;
import com.example.projectspringrupp.feature.brand.dto.BrandResponse;
import com.example.projectspringrupp.mapper.BrandMapper;
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
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;
    //Create brand
    @Override
    public BrandResponse createBrand(BrandCreateRequest brandCreateRequest) {
// validate product name
        if (brandRepository.existsByBrandName(brandCreateRequest.brandName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This brand is already exist!");
        }
        // transfer DTO domain model
        Brand brand = brandMapper.fromBrandCreateRequest(brandCreateRequest);
        brand = brandRepository.save(brand);

        // system generate date
        brand.setBrandName(brand.getBrandName());

        // save product to database
        brand = brandRepository.save(brand);

        return brandMapper.toBrandResponse(brand);
    }

    //find all product
    @Override
    public List<BrandResponse> findAllBrand(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Brand> brands = brandRepository.findAll(pageable);
        return brandMapper.toBrandResponseList(brands.getContent());
    }

    // find single product
    @Override
    public BrandResponse findBrandByName(String brandName) {
        Brand brand = brandRepository.findByBrandName(brandName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "This brand is not found!"));
        return brandMapper.toBrandResponse(brand);
    }

    // update brand
    @Override
    public BrandResponse UpdateBrand(String brandName, BrandCreateRequest brandUpdateRequest) {
        Brand brand = brandRepository.findByBrandName(brandName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "We can not find this brand name."));
        brandMapper.fromBrandUpdateRequest(brandUpdateRequest, brand);
        brand = brandRepository.save(brand);
        return brandMapper.toBrandResponse(brand);
    }

    // delete brand
    @Override
    public void deleteBrand(String brandName) {
        Brand brand = brandRepository.findByBrandName(brandName)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Can't delete this brand because it is not found."));
        brandRepository.delete(brand);
    }
}
