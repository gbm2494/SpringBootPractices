package com.supermarket.virtualsupermarket.service;

import com.supermarket.virtualsupermarket.entity.Supplier;
import com.supermarket.virtualsupermarket.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Iterable<Supplier> listSuppliers() {
        return supplierRepository.findAll();
    }
}
