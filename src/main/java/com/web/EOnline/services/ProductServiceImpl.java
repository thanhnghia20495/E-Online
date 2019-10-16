package com.web.EOnline.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Products;
import com.web.EOnline.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Products createProduct(Products products) {
		productRepository.save(products);
		return null;
	}

	@Override
	public Products updateProduct(Products products) {
		productRepository.save(products);
		return null;
	}

	@Override
	public Products findProductById(String productCode) {

		return productRepository.findByProductCode(productCode);
	}

	@Override
	public List<Products> findByProductNameContainingIgnoreCase(String keyword) {
		return productRepository.findByProductNameContainingIgnoreCase(keyword);
	}

	@Override
	public Page<Products> findAllProductPagination(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Products> listProduct = productRepository.findAll();
        List<Products> list;
        
        if (listProduct.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, listProduct.size());
            list = listProduct.subList(startItem, toIndex);
        }

        Page<Products> productPage = new PageImpl<Products>(list, PageRequest.of(currentPage, pageSize), listProduct.size());

        return productPage;

    }
}
