package com.demo.productsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequestDto {
	
	@NotBlank
    private String name;

    @Positive
    private double price;

    @PositiveOrZero
    private int quantity;

    @NotBlank
    private String category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ProductRequestDto(@NotBlank String name, @Positive double price, @PositiveOrZero int quantity,
			@NotBlank String category) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductRequestDto [name=" + name + ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + "]";
	}

	public ProductRequestDto() {
		super();
	}

}
