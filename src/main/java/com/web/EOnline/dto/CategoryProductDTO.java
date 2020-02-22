package com.web.EOnline.dto;

import java.util.List;

import com.web.EOnline.entities.Category2;
import com.web.EOnline.entities.Products;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class CategoryProductDTO {

	private Category2 category2;

	private List<Products> products;

	public CategoryProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryProductDTO(Category2 category2, List<Products> products) {
		super();
		this.category2 = category2;
		this.products = products;
	}

}
