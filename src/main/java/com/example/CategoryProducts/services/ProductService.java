package com.example.CategoryProducts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CategoryProducts.entitys.Product;
import com.example.CategoryProducts.repos.ProdutRepo;

@Service
public class ProductService {

	@Autowired ProdutRepo repo;
	
	// Get All Product API
	public List<Product> getAllProduct()
	{
		List<Product> li=(List<Product>)this.repo.findAll();
		return li;
	}
	
	// Get Product By Id API
	public Product getProductById(long id)
	{
		Product res=this.repo.getById(id);
		return res;
	}
	
	// Add Product API
	public Product addProduct(Product p)
	{
		Product pr=this.repo.save(p);
		return pr;
	}
	
	// Update Product By Id API
	public void updateProduct(Product p,long id)
	{
		p.setId(id);
		this.repo.save(p);
	}
	
	// Delete Product By Id API
	public void deleteProduct(long id)
	{
		this.repo.deleteById(id);
	}
}
