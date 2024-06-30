package com.example.projectspringrupp.feature.supplier;

import com.example.projectspringrupp.domain.Supplier;
import com.example.projectspringrupp.feature.supplier.dto.SupplierCreateRequest;
import com.example.projectspringrupp.feature.supplier.dto.SupplierResponse;
import com.example.projectspringrupp.feature.supplier.dto.SupplierUpdateRequest;
import com.example.projectspringrupp.mapper.SupplierMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    // Create supplier
    @Override
    public SupplierResponse createSupplier(SupplierCreateRequest supplierCreateRequest) {
        // validate supplier phone number
        if (supplierRepository.existsBySupplierPhone(supplierCreateRequest.supplierPhone())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This supplier is already exist!");
        }
        // transfer DTO domain model
        Supplier supplier = supplierMapper.fromSupplierCreateRequest(supplierCreateRequest);
        supplier = supplierRepository.save(supplier);

        // system generate date
        supplier.setFirstname(supplier.getFirstname());
        supplier.setLastname(supplier.getLastname());
        supplier.setSupplierPhone(supplier.getSupplierPhone());
        supplier.setAddress(supplier.getAddress());

        // save supplier to database
        supplier = supplierRepository.save(supplier);

        return supplierMapper.toSupplierResponse(supplier);
    }

    // find all supplier
    @Override
    public List<SupplierResponse> findAllSupplier() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return supplierMapper.toSupplierResponseList(suppliers);
    }

    // find supplier by phone number
    @Override
    public SupplierResponse findSupplierByPhone(String phone) {
        Supplier supplier = supplierRepository.findBySupplierPhone(phone)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "This supplier is not found!"));
        return supplierMapper.toSupplierResponse(supplier);
    }

    // update supplier
    @Override
    public SupplierResponse updateSupplier(String phone, SupplierUpdateRequest supplierUpdateRequest) {
        Supplier supplier = supplierRepository.findBySupplierPhone(phone)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "We can not find this supplier."));
        supplierMapper.fromSupplierUpdateRequest(supplierUpdateRequest, supplier);
        supplier = supplierRepository.save(supplier);
        return supplierMapper.toSupplierResponse(supplier);
    }

    @Override
    public void deleteSupplier(String phone) {
        Supplier supplier = supplierRepository.findBySupplierPhone(phone)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Can't delete this supplier because it is not found."));
        supplierRepository.delete(supplier);
    }
}
