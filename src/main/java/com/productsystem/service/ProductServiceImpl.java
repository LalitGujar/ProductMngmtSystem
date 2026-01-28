package com.productsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.productsystem.dto.ProductPatchDto;
import com.productsystem.dto.ProductRequestDto;
import com.productsystem.dto.ProductResponseDto;
import com.productsystem.exception.DuplicateProductException;
import com.productsystem.model.Product;
import com.productsystem.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public ProductResponseDto createProduct(ProductRequestDto dto) {
		if (repository.existsByName(dto.getName()))
			throw new DuplicateProductException(dto.getName());

		Product product = new Product(null, dto.getName(), dto.getPrice(), dto.getQuantity(), dto.getCategory(), false);

		return mapToDto(repository.save(product));
	}
	
	@Override
	public ProductResponseDto getProductById(Long id) {
		return mapToDto(findProduct(id));
	}
	
	@Override
	public Page<ProductResponseDto> getAllProducts(Pageable pageable){
		return repository.findAll(pageable).map(this::mapToDto);
				//.map(this::mapToDTO);
	}
	
	@Override
	public ProductResponseDto updateProduct(Long id, ProductRequestDto dto) {
		Product product = findProduct(id);

		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setQuantity(dto.getQuantity());
		product.setCategory(dto.getCategory());

		return mapToDto(repository.save(product));
	}

	@Override
	public ProductResponseDto patchProduct(Long id, ProductPatchDto dto) {
		Product product = findProduct(id);

		if (dto.getName() != null)
			product.setName(dto.getName());
		if (dto.getPrice() != null)
			product.setPrice(dto.getPrice());
		if (dto.getQuantity() != null)
			product.setQuantity(dto.getQuantity());
		if (dto.getCategory() != null)
			product.setCategory(dto.getCategory());

		return mapToDto(repository.save(product));
	}

	@Override
	public void deleteProduct(Long id) {
		Product product = findProduct(id);
		product.setDeleted(true);
		repository.save(product);
	}

	
	private Product findProduct(Long id) {
		return repository.findById(id).orElseThrow();
	}

	private ProductResponseDto mapToDto(Product product) {
		return new ProductResponseDto(product.getId(), product.getName(), product.getPrice(), product.getQuantity(),
				product.getCategory());
	}

}
