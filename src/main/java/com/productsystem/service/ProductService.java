package com.productsystem.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.productsystem.dto.ProductPatchDto;
import com.productsystem.dto.ProductRequestDto;
import com.productsystem.dto.ProductResponseDto;

public interface ProductService {
	
	ProductResponseDto createProduct(ProductRequestDto dto);

    ProductResponseDto getProductById(Long id);

    Page<ProductResponseDto> getAllProducts(Pageable pageable);

    ProductResponseDto updateProduct(Long id, ProductRequestDto dto);

    ProductResponseDto patchProduct(Long id, ProductPatchDto dto);

    void deleteProduct(Long id);

}
