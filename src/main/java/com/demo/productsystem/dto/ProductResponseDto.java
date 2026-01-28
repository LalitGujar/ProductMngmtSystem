package com.demo.productsystem.dto;

public class ProductResponseDto {

	private Long id;
    private String name;
    private double price;
    private int quantity;
    private String category;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public ProductResponseDto(Long id, String name, double price, int quantity, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "ProductResponseDto [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}
    
    
}
