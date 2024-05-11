package com.example.CategoryProducts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CategoryProducts.entitys.Category;
import com.example.CategoryProducts.repos.CategoryRepo;

@Service
public class CategoryService {

	@Autowired CategoryRepo repo;
	
	// Get All Category API
	public List<Category> getAllCategory(){
		List<Category> li=(List<Category>)this.repo.findAll();
		return li;
	}
	
	// Get Category By Id API
	public Category getCategoryById(long id)
	{
		Category cat=this.repo.getById(id);
		return cat;
	}
	
	// Add Category API
	public Category addCategory(Category c)
	{
		Category res=this.repo.save(c);
		return res;
	}
	
	// Update Category By Id API
	public void updateCategory(Category c,long id)
	{
		c.setId(id);
		this.repo.save(c);
		
	}
	
	// Delete Category By Id API
	public void deleteCategory(long id)
	{
		this.repo.deleteById(id);
	}
}
