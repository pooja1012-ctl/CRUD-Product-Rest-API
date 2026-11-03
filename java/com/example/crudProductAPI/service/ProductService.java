package com.example.crudProductAPI.service;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Service;

import com.example.crudProductAPI.dto.ProductRequest;
import com.example.crudProductAPI.entity.Product;
import com.example.crudProductAPI.exception.ResourceNotFoundException;
import com.example.crudProductAPI.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	//create product
		public Product createProduct(ProductRequest request) {
			
			Product product = new Product();
			
			product.setName(request.getName());
			product.setPrice(request.getPrice());
			product.setDescription(request.getDescription());
			product.setQuantity(request.getQuantity());
			
			return productRepository.save(product);		
		
	}
		
	//get all products
		public List<Product> getAllProducts() {
			return productRepository.findAll();
			
		}
	
	//get product by id
	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(()->
				new ResourceNotFoundException("product not found with id:"+id));	
	}

	public Product updateProduct(Long id,ProductRequest request) {
		Product product = getProductById(id);
		
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setDescription(request.getDescription());
		product.setQuantity(request.getQuantity());
		
		return productRepository.save(product);
	}
	
	public void deleteProduct(Long id) {
		Product product = getProductById(id);
		productRepository.delete(product);
	}
}
