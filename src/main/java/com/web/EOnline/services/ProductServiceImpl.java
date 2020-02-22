package com.web.EOnline.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Category1;
import com.web.EOnline.entities.Category2;
import com.web.EOnline.entities.Heights;
import com.web.EOnline.entities.Prices;
import com.web.EOnline.entities.Products;
import com.web.EOnline.entities.Weights;
import com.web.EOnline.repositories.Category1Repository;
import com.web.EOnline.repositories.Category2Repository;
import com.web.EOnline.repositories.HeightProductRepository;
import com.web.EOnline.repositories.PriceProductRepository;
import com.web.EOnline.repositories.ProductRepository;
import com.web.EOnline.repositories.WeightProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	PriceProductRepository priceProductRepository;

	@Autowired
	HeightProductRepository heightProductRepository;

	@Autowired
	WeightProductRepository weightProductRepository;

	@Autowired
	Category1Repository category1Repository;

	@Autowired
	Category2Repository category2Repository;

	@Override
	public Products createProduct(Products products) {
		try {
			productRepository.save(products);
			Products product = productRepository.findByProductCode(products.getProductCode());
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean updateProduct(Products products) {
		try {
			productRepository.save(products);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

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

		Page<Products> productPage = new PageImpl<Products>(list, PageRequest.of(currentPage, pageSize),
				listProduct.size());

		return productPage;

	}

	@Override
	public Page<Products> findFilterProductPagination(Pageable pageable, String keyword,int priceCode, int heightCode, int weightCode,
			int category1_id, int category2_id) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> listProduct = null;
		List<Products> list;
		Long fromPrice = null;
		Long toPrice = null;
		Integer heightProduct = null;
		Integer weightProduct = null;
		Integer category1Product = null;
		Integer category2Product = null;
		Prices price = priceProductRepository.findByPriceCode(priceCode);
		Heights heights = heightProductRepository.findByHeightCode(heightCode);
		Weights weights = weightProductRepository.findByWeightCode(weightCode);
		Category2 category2 = category2Repository.findByCategory2Id(category2_id);
		Category1 category1 = category1Repository.findByCategory1Id(category1_id);
		
		if (price != null) {
			if (price.getToPrice() == 0) {
				price.setToPrice(null);
			}
			fromPrice = price.getFromPrice();
			toPrice = price.getToPrice();
		}
		if (heights != null) {
			heightProduct = heights.getHeightId();
		}
		if (weights != null) {
			weightProduct = weights.getWeightId();
		}
		if (category1 != null) {
			category1Product = category1.getCategory1Id();
		}
		if (category2 != null) {
			category2Product = category2.getCategory2Id();
		}
		listProduct = productRepository.findFilterProduct(keyword,fromPrice, toPrice, heightProduct, weightProduct,
				category1Product, category2Product);

		if (listProduct.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, listProduct.size());
			list = listProduct.subList(startItem, toIndex);
		}

		Page<Products> productPage = new PageImpl<Products>(list, PageRequest.of(currentPage, pageSize),
				listProduct.size());

		return productPage;
	}

	@Override
	public List<Products> findByCategory2(Category2 category2) {
		try {
			return productRepository.findByCategory2(category2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Products> findByCategory2AndOptionBestSelling(String optionBestSelling, int category2Id) {
		try {
			return productRepository.findByCategory2AndOptionBestSelling(optionBestSelling, category2Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
