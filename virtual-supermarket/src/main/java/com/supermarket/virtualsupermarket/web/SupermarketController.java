package com.supermarket.virtualsupermarket.web;

import com.supermarket.virtualsupermarket.entity.Product;
import com.supermarket.virtualsupermarket.exception.ProductNotFoundException;
import com.supermarket.virtualsupermarket.service.ProductService;
import com.supermarket.virtualsupermarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/supermarket")
public class SupermarketController {

    private ProductService productService;
    private SupplierService supplierService;

    @Autowired
    public void setApplicationService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /*@GetMapping("/products")
    public String retrieveProducts(Model model){
        model.addAttribute("products", productService.listProducts());
        return "products";
    }*/

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = productService.listProducts2();
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }

    /*@GetMapping("/suppliers")
    public String retrieveSuppliers(Model model){
        model.addAttribute("suppliers", supplierService.listSuppliers());
        return "suppliers";
    }*/

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<Product>(productService.findProduct(id), HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }
    }
}
