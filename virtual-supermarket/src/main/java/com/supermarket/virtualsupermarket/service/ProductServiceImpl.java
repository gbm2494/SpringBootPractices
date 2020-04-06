package com.supermarket.virtualsupermarket.service;

import com.supermarket.virtualsupermarket.entity.Product;
import com.supermarket.virtualsupermarket.exception.ProductNotFoundException;
import com.supermarket.virtualsupermarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> listProducts2() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findProduct(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent())
            return optionalProduct.get();
        else
            throw new ProductNotFoundException("Product Not Found");
    }
}
