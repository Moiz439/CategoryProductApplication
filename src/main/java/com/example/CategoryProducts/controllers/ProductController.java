package com.example.CategoryProducts.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CategoryProducts.entitys.Product;
import com.example.CategoryProducts.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired ProductService service;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAll()
	{
		List<Product> li=this.service.getAllProduct();
		return ResponseEntity.of(Optional.of(li));
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") long id)
	{
		Product p=this.service.getProductById(id);
		return ResponseEntity.of(Optional.of(p));
	}
	

	@PostMapping("/products")
	public ResponseEntity<Product> add(@RequestBody Product p)
	{
		Product result=this.service.addProduct(p);
		return ResponseEntity.of(Optional.of(result));
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id)
	{
		this.service.deleteProduct(id);
		return ResponseEntity.of(Optional.of("Deleted"));
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String> update(@RequestBody Product p,@PathVariable("id") long id)
	{
		this.service.updateProduct(p, id);
		return ResponseEntity.of(Optional.of("Updated"));
	}
}
