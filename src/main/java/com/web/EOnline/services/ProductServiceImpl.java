package com.web.EOnline.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Heights;
import com.web.EOnline.entities.Prices;
import com.web.EOnline.entities.Products;
import com.web.EOnline.entities.Weights;
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
	public Page<Products> findFilterProductPagination(Pageable pageable, int priceCode, int heightCode,
			int weightCode) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> listProduct = null;
		List<Products> list;
		Long fromPrice = null;
		Long toPrice = null;
		Integer heightProduct = null;
		Integer weightProduct = null;
		Prices price = priceProductRepository.findByPriceCode(priceCode);
		Heights heights = heightProductRepository.findByHeightCode(heightCode);
		Weights weights = weightProductRepository.findByWeightCode(weightCode);
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
		listProduct = productRepository.findFilterProduct(fromPrice, toPrice, heightProduct, weightProduct);

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
	public Page<Products> findFilterPriceProductPagination(Pageable pageable, int priceCode) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> listProduct = null;
		List<Products> list;
		Long fromPrice = null;
		Long toPrice = null;
		Prices price = priceProductRepository.findByPriceCode(priceCode);
		if (price != null) {
			if (price.getToPrice() == 0) {
				price.setToPrice(null);
			}
			fromPrice = price.getFromPrice();
			toPrice = price.getToPrice();
		}
		listProduct = productRepository.findFilterProduct(fromPrice, toPrice, null, null);

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
	public Page<Products> findFilterHeightProductPagination(Pageable pageable, int heightCode) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> listProduct = null;
		List<Products> list;
		Integer heightProduct = null;
		Heights heights = heightProductRepository.findByHeightCode(heightCode);
		if (heights != null) {
			heightProduct = heights.getHeightId();
		}
		listProduct = productRepository.findFilterProduct(null, null, heightProduct, null);

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
	public Page<Products> findFilterWeightProductPagination(Pageable pageable, int weightCode) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> listProduct = null;
		List<Products> list;
		Integer weightProduct = null;
		Weights weights = weightProductRepository.findByWeightCode(weightCode);
		if (weights != null) {
			weightProduct = weights.getWeightId();
		}
		listProduct = productRepository.findFilterProduct(null, null, null, weightProduct);

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
	public Page<Products> findFilterPriceHeightProductPagination(Pageable pageable, int priceCode, int heightCode) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> listProduct = null;
		List<Products> list;
		Long fromPrice = null;
		Long toPrice = null;
		Integer heightProduct = null;
		Prices price = priceProductRepository.findByPriceCode(priceCode);
		Heights heights = heightProductRepository.findByHeightCode(heightCode);
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
		listProduct = productRepository.findFilterProduct(fromPrice, toPrice, heightProduct, null);

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
	public Page<Products> findFilterPriceWeightProductPagination(Pageable pageable, int priceCode, int weightCode) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> listProduct = null;
		List<Products> list;
		Long fromPrice = null;
		Long toPrice = null;
		Integer weightProduct = null;
		Prices price = priceProductRepository.findByPriceCode(priceCode);
		Weights weights = weightProductRepository.findByWeightCode(weightCode);
		if (price != null) {
			if (price.getToPrice() == 0) {
				price.setToPrice(null);
			}
			fromPrice = price.getFromPrice();
			toPrice = price.getToPrice();
		}
		if (weights != null) {
			weightProduct = weights.getWeightId();
		}
		listProduct = productRepository.findFilterProduct(fromPrice, toPrice, null, weightProduct);

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
	public Page<Products> findFilterHeightWeightProductPagination(Pageable pageable, int heightCode, int weightCode) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> listProduct = null;
		List<Products> list;
		Integer heightProduct = null;
		Integer weightProduct = null;
		Heights heights = heightProductRepository.findByHeightCode(heightCode);
		Weights weights = weightProductRepository.findByWeightCode(weightCode);
		if (heights != null) {
			heightProduct = heights.getHeightId();
		}
		if (weights != null) {
			weightProduct = weights.getWeightId();
		}
		listProduct = productRepository.findFilterProduct(null, null, heightProduct, weightProduct);

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
}
