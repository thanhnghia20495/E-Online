package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Products;

@Service
public interface ProductRepository extends JpaRepository<Products, String>{
	Products findByProductCode(String productCode);
	public List<Products> findByProductNameContainingIgnoreCase(String keyword);
}
