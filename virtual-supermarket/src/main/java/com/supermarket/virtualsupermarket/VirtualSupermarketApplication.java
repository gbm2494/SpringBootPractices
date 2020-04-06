package com.supermarket.virtualsupermarket;

import com.supermarket.virtualsupermarket.entity.Product;
import com.supermarket.virtualsupermarket.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VirtualSupermarketApplication {

    private static final Logger log = LoggerFactory.getLogger(VirtualSupermarketApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VirtualSupermarketApplication.class, args);
        System.out.println("Hello World");
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository){
        return (args) -> {
            repository.save(new Product("Abarrotes", "Arroz", 2500, "Arroz blanco 95%"));
            repository.save(new Product("Limpieza", "Cloro", 1250, "Cloro los conejos"));

            for (Product product : repository.findAll()){
                log.info("The product is: " + product.toString());
            }
        };
    }
}
