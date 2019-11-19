package com.web.EOnline.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.web.EOnline.entities.Products;

public interface ProductService {
	Products findProductById(String productCode);

	Products createProduct(Products products);

	 boolean updateProduct(Products products);

	public List<Products> findByProductNameContainingIgnoreCase(String keyword);
	
	public Page<Products> findAllProductPagination(Pageable pageable);
	
	public Page<Products> findFilterProductPagination(Pageable pageable, int priceCode, int heightCode, int weightCode);
	
	public Page<Products> findFilterPriceHeightProductPagination(Pageable pageable, int priceCode, int heightCode);
	
	public Page<Products> findFilterPriceWeightProductPagination(Pageable pageable, int priceCode, int weightCode);
	
	public Page<Products> findFilterHeightWeightProductPagination(Pageable pageable, int heightCode, int weightCode);
	
	public Page<Products> findFilterPriceProductPagination(Pageable pageable, int priceCode);
	
	public Page<Products> findFilterHeightProductPagination(Pageable pageable, int heightCode);
	
	public Page<Products> findFilterWeightProductPagination(Pageable pageable, int weightCode);

}
