package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Category2;
import com.web.EOnline.repositories.Category2Repository;

@Service
public class Category2ServiceImpl implements Category2Service {

	@Autowired
	Category2Repository category2Repository;

	@Override
	public Category2 findCategoryById(int categoryId) {
		try {
			return category2Repository.findByCategory2Id(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category2 createCategory2(Category2 category2) {
		try {
			return category2Repository.save(category2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category2 updateCategory2(Category2 category2) {
		try {
			return category2Repository.save(category2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category2> findAllCategory2() {
		try {
			return category2Repository.findAllByOrderByOrderAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category2> findByOptionBestSellingAndOrderByOrderAsc(String optionBestSelling) {
		try {
			return category2Repository.findByOptionBestSellingAndOrderByOrderAsc(optionBestSelling);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
