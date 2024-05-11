package com.example.CategoryProducts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CategoryProducts.entitys.Product;

public interface ProdutRepo extends JpaRepository<Product, Long>{
	public Product getById(long id);
}
