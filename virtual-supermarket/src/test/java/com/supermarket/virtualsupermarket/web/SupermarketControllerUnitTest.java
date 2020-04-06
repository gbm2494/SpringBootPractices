package com.supermarket.virtualsupermarket.web;

import com.supermarket.virtualsupermarket.service.ProductService;
import com.supermarket.virtualsupermarket.service.SupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SupermarketController.class)
public class SupermarketControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @MockBean
    SupplierService supplierService;

    @Test
    public void getAllProducts() throws Exception {
        mockMvc.perform(get("/supermarket/products/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(content().json("[]"));

        verify(productService, times(1)).listProducts();
    }

    @Test
    public void getAllSuppliers() throws Exception {
        mockMvc.perform(get("/supermarket/suppliers/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(supplierService, times(1)).listSuppliers();
    }
}
