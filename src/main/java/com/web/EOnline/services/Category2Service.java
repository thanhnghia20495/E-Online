package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.Category2;

public interface Category2Service {

	Category2 findCategoryById(int categoryId);

	Category2 createCategory2(Category2 category2);

	Category2 updateCategory2(Category2 category2);
	
	List<Category2> findAllCategory2();
	
	public List<Category2> findByOptionBestSellingAndOrderByOrderAsc(String optionBestSelling);
}
