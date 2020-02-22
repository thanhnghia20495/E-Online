package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Category1;
import com.web.EOnline.repositories.Category1Repository;

@Service
public class Category1ServiceImpl implements Category1Service {

	@Autowired
	Category1Repository category1Repository;

	@Override
	public Category1 findCategoryById(int categoryId) {
		try {
			return category1Repository.findByCategory1Id(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category1 createCategory1(Category1 category1) {
		try {
			return category1Repository.save(category1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category1 updateCategory1(Category1 category1) {
		try {
			return category1Repository.save(category1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category1> findAllCategory1() {
		try {
			return category1Repository.findAllByOrderByOrderAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
