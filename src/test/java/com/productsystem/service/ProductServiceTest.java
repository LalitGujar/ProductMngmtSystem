package com.productsystem.service;

import com.demo.productsystem.dto.ProductRequestDto;
import com.demo.productsystem.dto.ProductResponseDto;
import com.demo.productsystem.model.Product;
import com.demo.productsystem.repository.ProductRepository;
import com.demo.productsystem.service.ProductService;
import com.demo.productsystem.service.ProductServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void createProduct_success() {

        ProductRequestDto request = new ProductRequestDto();
        request.setName("Item1");
        request.setPrice(200);
        request.setQuantity(2);
        request.setCategory("Category1");

        Product savedProduct = new Product();
        savedProduct.setId(1L);
        savedProduct.setName("Item1");
        savedProduct.setPrice(200);
        savedProduct.setQuantity(2);
        savedProduct.setCategory("Category1");

        when(productRepository.save(any(Product.class)))
                .thenReturn(savedProduct);

        ProductResponseDto response = productService.createProduct(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Item1", response.getName());
        assertEquals(200, response.getPrice());
        assertEquals(2, response.getQuantity());
        assertEquals("Category1", response.getCategory());

        verify(productRepository, times(1)).save(any(Product.class));
    }
}
