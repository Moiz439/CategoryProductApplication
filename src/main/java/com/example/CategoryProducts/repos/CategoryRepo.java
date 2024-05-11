package com.example.CategoryProducts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CategoryProducts.entitys.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{
	public Category getById(long id);
}
