package com.supermarket.virtualsupermarket.repository;

import com.supermarket.virtualsupermarket.entity.Supplier;
import org.springframework.data.repository.CrudRepository;

//springBoot makes the rest, we just have to define a repository for each entity
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
