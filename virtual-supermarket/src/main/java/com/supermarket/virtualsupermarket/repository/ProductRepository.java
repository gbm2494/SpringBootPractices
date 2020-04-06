package com.supermarket.virtualsupermarket.repository;

import com.supermarket.virtualsupermarket.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
