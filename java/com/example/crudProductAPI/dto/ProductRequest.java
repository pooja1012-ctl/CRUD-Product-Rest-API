package com.example.crudProductAPI.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProductRequest {
	
	@NotBlank(message = "product name is required")
    @Size(max = 100,message = "Product name cannot exceed 100 character")
	private String name;
	
	   @NotBlank(message = "Product description is required")
	    @Size(max = 500, message = "Description cannot exceed 500 characters")
	    private String description;

	    @Min(value = 0, message = "Price cannot be negative")
	    private double price;

	    @PositiveOrZero(message = "Quantity cannot be negative")
	    private int quantity;

	    public ProductRequest() {
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
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

}
