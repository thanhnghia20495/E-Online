package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Category2;

@Repository
public interface Category2Repository extends JpaRepository<Category2, Integer> {
	Category2 findByCategory2Id(int caregoryId);
	public List<Category2> findAllByOrderByOrderAsc();
	@Query(value = "SELECT c2.* FROM ecom_owner.category_2 c2 where c2.option_best_selling = :optionBestSelling order by c2.order_id asc", nativeQuery = true)
	public List<Category2> findByOptionBestSellingAndOrderByOrderAsc(@Param ("optionBestSelling") String optionBestSelling);
}
