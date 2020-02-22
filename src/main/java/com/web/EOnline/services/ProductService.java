package com.web.EOnline.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.web.EOnline.entities.Category2;
import com.web.EOnline.entities.Products;

public interface ProductService {
	Products findProductById(String productCode);

	Products createProduct(Products products);

	boolean updateProduct(Products products);

	public List<Products> findByProductNameContainingIgnoreCase(String keyword);

	public Page<Products> findAllProductPagination(Pageable pageable);

	public Page<Products> findFilterProductPagination(Pageable pageable, String keyword, int priceCode, int heightCode, int weightCode,
			int category1_id, int category2_id);

	public List<Products> findByCategory2(Category2 category2);

	public List<Products> findByCategory2AndOptionBestSelling(String optionBestSelling, int category2Id);

}
