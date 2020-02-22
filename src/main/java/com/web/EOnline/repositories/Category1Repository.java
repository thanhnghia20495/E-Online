package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Category1;

@Repository
public interface Category1Repository extends JpaRepository<Category1, Integer> {
	Category1 findByCategory1Id(int categoryId);
	public List<Category1> findAllByOrderByOrderAsc();
}
