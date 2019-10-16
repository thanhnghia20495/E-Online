package com.web.EOnline.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.web.EOnline.entities.Products;

public interface ProductService {
	Products findProductById(String productCode);

	Products createProduct(Products products);

	Products updateProduct(Products products);

	public List<Products> findByProductNameContainingIgnoreCase(String keyword);
	
	public Page<Products> findAllProductPagination(Pageable pageable);

}
