package com.example.crudProductAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudProductAPI.dto.ProductRequest;
import com.example.crudProductAPI.entity.Product;
import com.example.crudProductAPI.service.ProductService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
		
	}
	//create product
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequest request){
	
	Product product = productService.createProduct(request);
	
	return ResponseEntity.status(HttpStatus.CREATED).body(product);

}

	//Read all products
	@GetMapping()
	public ResponseEntity<List<Product>>getAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
		
	}
	
	//Read products by id
	@GetMapping("/{id}")
	public ResponseEntity<Product>getProductById(@PathVariable Long id){
		
		return ResponseEntity.ok(productService .getProductById(id));
		
	}
	
	//update a product
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(
			@PathVariable Long id,
			@Valid @RequestBody ProductRequest request){
		Product updateProduct = productService.updateProduct(id, request);
		
		return ResponseEntity.ok(updateProduct);
		
	}
	
	//delete product
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(
	            @PathVariable Long id) {

	        productService.deleteProduct(id);

	        return ResponseEntity.noContent().build();
	    }
	
	
	
	

}
