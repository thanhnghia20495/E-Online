package com.web.EOnline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class Products extends Auditable<String>{

	@Id
	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "trade_mark")
	private String trademark;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "percentage_discount")
	private int percentageDiscount;
	
	@Column(name = "price_discount")
	private long priceDiscount;
	
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "height")
	private String height;

	@Column(name = "guarantee")
	private int guarantee;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "option_best_selling")
	private int option_best_selling;
	
	@Column(name = "description")
	private String description;

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(String productCode, String productName, String trademark, long price, int percentageDiscount,
			long priceDiscount, String weight, String height, int guarantee, int status, int option_best_selling,
			String description) {
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
		this.option_best_selling = option_best_selling;
		this.description = description;
	}
	
	
	
}
