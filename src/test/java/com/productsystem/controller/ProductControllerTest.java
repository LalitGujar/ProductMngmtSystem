package com.productsystem.controller;


import com.demo.productsystem.controller.ProductController;
import com.demo.productsystem.dto.ProductRequestDto;
import com.demo.productsystem.dto.ProductResponseDto;
import com.demo.productsystem.service.ProductService;
import com.demo.productsystem.service.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServiceImpl productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createProduct_success() throws Exception {

        ProductRequestDto request = new ProductRequestDto();
        request.setName("Item1");
        request.setPrice(200);
        request.setQuantity(2);
        request.setCategory("Category1");

        ProductResponseDto response = new ProductResponseDto();
        response.setId(1L);
        response.setName("Item1");
        response.setPrice(200);
        response.setQuantity(2);
        response.setCategory("Category1");

        Mockito.when(productService.createProduct(Mockito.any()))
                .thenReturn(response);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Item1"))
                .andExpect(jsonPath("$.price").value(200))
                .andExpect(jsonPath("$.quantity").value(2))
                .andExpect(jsonPath("$.category").value("Category1"));
    }
    
}