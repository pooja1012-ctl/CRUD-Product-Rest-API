package com.example.crudProductAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudProductAPI.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

}
