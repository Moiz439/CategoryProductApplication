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

import com.example.CategoryProducts.entitys.Category;
import com.example.CategoryProducts.services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired CategoryService service;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAll()
	{
		List<Category> li=this.service.getAllCategory();
		return ResponseEntity.of(Optional.of(li));
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getById(@PathVariable("id") long id)
	{
		Category c=this.service.getCategoryById(id);
		return ResponseEntity.of(Optional.of(c));
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Category> add(@RequestBody Category c)
	{
		Category result=this.service.addCategory(c);
		return ResponseEntity.of(Optional.of(result));
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id)
	{
		this.service.deleteCategory(id);
		return ResponseEntity.of(Optional.of("Deleted"));
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<String> update(@RequestBody Category c,@PathVariable("id") long id)
	{
		this.service.updateCategory(c, id);
		return ResponseEntity.of(Optional.of("Updated"));
	}
	
}
