package com.example.projectspringrupp.feature.supplier;

import com.example.projectspringrupp.feature.supplier.dto.SupplierCreateRequest;
import com.example.projectspringrupp.feature.supplier.dto.SupplierResponse;
import com.example.projectspringrupp.feature.supplier.dto.SupplierUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/supplier")
public class SupplierController {
    private final SupplierService supplierService;
    //create supplier
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    SupplierResponse createNewSupplier(@Valid @RequestBody SupplierCreateRequest supplierCreateRequest) {
        return supplierService.createSupplier(supplierCreateRequest);
    }
    //find single supplier
    @GetMapping("/{phone}")
    SupplierResponse findSupplierByPhone(@Valid @PathVariable String phone) {
        return supplierService.findSupplierByPhone(phone);
    }

    //find all supplier
    @GetMapping
    List<SupplierResponse> findAllSupplier() {
        return supplierService.findAllSupplier();
    }

    //update supplier
    @PatchMapping("/{phone}")
    SupplierResponse updateSupplier(@Valid @PathVariable String phone, @RequestBody SupplierUpdateRequest supplierUpdateRequest) {
        return supplierService.updateSupplier(phone, supplierUpdateRequest);
    }

    //delete supplier
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{phone}")
    void deleteSupplier(@Valid @PathVariable String phone) {
        supplierService.deleteSupplier(phone);
    }
}
