package com.supermarket.virtualsupermarket.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.supermarket.virtualsupermarket.entity.Product;
import com.supermarket.virtualsupermarket.exception.ProductNotFoundException;
import com.supermarket.virtualsupermarket.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private ProductRepository productRepository;

    public Mutation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product newProduct(String name, String type,
                                      Float price, String description) {

        Product product = new Product(name, type, price, description);
        productRepository.save(product);
        return product;
    }

    public boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    public Product updateProductDescription(String description, Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setDescription(description);
            productRepository.save(product);
            return product;
        } else {
            throw new ProductNotFoundException("Product Not Found", id);
        }
    }
}
