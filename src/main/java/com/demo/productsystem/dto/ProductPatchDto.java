package com.demo.productsystem.dto;

public class ProductPatchDto {

	private String name;
	private Double price;
	private Integer quantity;
	private String category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ProductPatchDto [name=" + name + ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + "]";
	}
	public ProductPatchDto(String name, Double price, Integer quantity, String category) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	public ProductPatchDto() {
		super();
	}
	
	
	
	
}
