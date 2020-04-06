package com.supermarket.virtualsupermarket.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.supermarket.virtualsupermarket.entity.Product;
import com.supermarket.virtualsupermarket.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private ProductRepository productRepository;

    public Query(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public int countProducts() {
        return (int) productRepository.count();
    }
}
