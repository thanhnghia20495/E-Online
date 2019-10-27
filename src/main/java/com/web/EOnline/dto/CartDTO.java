package com.web.EOnline.dto;

import com.web.EOnline.entities.Products;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class CartDTO {
	private Products products;
	private int quantities;

	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(Products products, int quantities) {
		super();
		this.products = products;
		this.quantities = quantities;
	}

}
