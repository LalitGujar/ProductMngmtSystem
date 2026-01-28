package com.demo.productsystem.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.productsystem.dto.ProductPatchDto;
import com.demo.productsystem.dto.ProductRequestDto;
import com.demo.productsystem.dto.ProductResponseDto;

public interface ProductService {
	
	ProductResponseDto createProduct(ProductRequestDto dto);

    ProductResponseDto getProductById(Long id);

    Page<ProductResponseDto> getAllProducts(Pageable pageable);

    ProductResponseDto updateProduct(Long id, ProductRequestDto dto);

    ProductResponseDto patchProduct(Long id, ProductPatchDto dto);

    void deleteProduct(Long id);

}
