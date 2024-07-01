package com.example.projectspringrupp.feature.brand;

import com.example.projectspringrupp.feature.brand.dto.BrandCreateRequest;
import com.example.projectspringrupp.feature.brand.dto.BrandResponse;
import com.example.projectspringrupp.feature.product.ProductService;
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
@RequestMapping("/api/v1/brand")
public class BrandController {
    private final BrandService brandService;
    //create product
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    BrandResponse createNewBrand(@Valid @RequestBody BrandCreateRequest brandCreateRequest) {
        return brandService.createBrand(brandCreateRequest);
    }
    //find single brand
    @GetMapping("/{name}")
    BrandResponse findBrandName(@Valid @PathVariable String name) {
        return brandService.findBrandByName(name);
    }

    //find all brand
    @GetMapping
    List<BrandResponse> findAllBrand(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        return brandService.findAllBrand(page, size);
    }

    //update brand
    @PatchMapping("/{name}")
    BrandResponse updateByName(@Valid @PathVariable String name, @RequestBody BrandCreateRequest brandCreateRequest) {
        return brandService.UpdateBrand(name, brandCreateRequest);
    }

    //delete product
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    void deleteByName(@Valid @PathVariable String name) {
        brandService.deleteBrand(name);
    }
}
