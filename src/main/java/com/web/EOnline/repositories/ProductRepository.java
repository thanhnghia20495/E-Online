package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Category2;
import com.web.EOnline.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, String> {
	public Products findByProductCode(String productCode);

	public List<Products> findByProductNameContainingIgnoreCase(String keyword);
	
	public List<Products> findByCategory2(Category2 category2);
	
	@Query(value = "SELECT p.* FROM ecom_owner.products p where p.option_best_selling = :optionBestSelling and p.category2_id = :category2Id order by p.created_date desc", nativeQuery = true)
	public List<Products> findByCategory2AndOptionBestSelling(@Param("optionBestSelling") String optionBestSelling,@Param("category2Id") int category2Id);

	@Query(value = "SELECT p.* FROM ecom_owner.products p, ecom_owner.category_1 c1, ecom_owner.category_2 c2 "
			+ "where 1=1 "
			+ "and p.category2_id = c2.category2_id "
			+ "and c2.category1_id = c1.category1_id "
			+ "and (:from_price is null or p.price_discount >= :from_price) "
			+ "and (:to_price is null or p.price_discount <= :to_price) "
			+ "and (:height is null or p.height_code = :height) "
			+ "and (:weight is null or p.weight_code = :weight) "
			+ "and (:category1_id is null or c1.category1_id = :category1_id) "
			+ "and (:category2_id is null or p.category2_id = :category2_id) "
			+ "and (:keyword is null or p.product_name like %:keyword%) "
			+ "order by p.created_date desc", nativeQuery = true)
	public List<Products> findFilterProduct(@Param("keyword") String keyword, @Param("from_price") Long fromPrice, @Param("to_price") Long toPrice, @Param("height") Integer height, @Param("weight") Integer weight, @Param("category1_id") Integer category1_id, @Param("category2_id") Integer category2_id);
}
