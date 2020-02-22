package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.Category1;

public interface Category1Service {

	Category1 findCategoryById(int categoryId);

	Category1 createCategory1(Category1 category1);

	Category1 updateCategory1(Category1 category1);
	
	List<Category1> findAllCategory1 ();
}
