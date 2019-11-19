package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, String> {
	public Products findByProductCode(String productCode);

	public List<Products> findByProductNameContainingIgnoreCase(String keyword);

	@Query(value = "SELECT * FROM ecom_owner.products p where (:from_price is null or p.price_discount >= :from_price) and (:to_price is null or p.price_discount <= :to_price) and (:height is null or p.height_code = :height) and (:weight is null or p.weight_code = :weight)", nativeQuery = true)
	public List<Products> findFilterProduct(@Param("from_price") Long fromPrice, @Param("to_price") Long toPrice, @Param("height") Integer height, @Param("weight") Integer weight);
}
