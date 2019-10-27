package com.web.EOnline.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ProductDTO {

	private String productCode;

	private String productName;

	private String trademark;

	private long price;

	private int percentageDiscount;

	private long priceDiscount;

	private String weight;

	private String height;

	private int guarantee;

	private int status;

	private int views;

	private int option_best_selling;

	private String description;

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String productCode, String productName, String trademark, long price, int percentageDiscount,
			long priceDiscount, String weight, String height, int guarantee, int status, int views,
			int option_best_selling, String description) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.trademark = trademark;
		this.price = price;
		this.percentageDiscount = percentageDiscount;
		this.priceDiscount = priceDiscount;
		this.weight = weight;
		this.height = height;
		this.guarantee = guarantee;
		this.status = status;
		this.views = views;
		this.option_best_selling = option_best_selling;
		this.description = description;
	}
}
