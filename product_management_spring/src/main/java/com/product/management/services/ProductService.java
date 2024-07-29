package com.product.management.services;

import java.util.List;

import com.product.management.entities.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product findById(Integer id);

	public Product save(Product product);

	public void deleteById(Integer id);

}
