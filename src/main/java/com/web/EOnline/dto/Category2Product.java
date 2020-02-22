package com.web.EOnline.dto;

import com.web.EOnline.entities.Category2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Category2Product {
	private Category2 category2;
	private int sizeProduct;
	public Category2Product() {
		// TODO Auto-generated constructor stub
	}

	public Category2Product(Category2 category2, int sizeProduct) {
		super();
		this.category2 = category2;
		this.sizeProduct = sizeProduct;
	}
	
}
