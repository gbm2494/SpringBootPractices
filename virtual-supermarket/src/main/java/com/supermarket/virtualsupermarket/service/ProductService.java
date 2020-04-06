package com.supermarket.virtualsupermarket.service;

import com.supermarket.virtualsupermarket.entity.Product;

import java.util.List;

public interface ProductService {
    Iterable<Product> listProducts();
    List<Product> listProducts2();
    public Product findProduct(long id);
}
