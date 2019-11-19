package com.web.EOnline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class Products extends Auditable<String> {

	@Id
	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_name")
	private String productName;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trade_mark_id")
	private TradeMarks tradeMark;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "technology_id")
	private Technologies technology;

	@Column(name = "price")
	private long price;

	@Column(name = "percentage_discount")
	private int percentageDiscount;

	@Column(name = "price_discount")
	private long priceDiscount;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weight_code")
	private Weights weight;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "height_code")
	private Heights height;

	@Column(name = "guarantee")
	private int guarantee;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "status_code")
	private Statuses status;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "vat_id")
	private VAT vat;
	
	@Column(name = "views")
	private int views;

	@Column(name = "option_best_selling", length = 1)
	private String option_best_selling;

	@Column(name = "description")
	private String description;

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(String productCode, String productName, TradeMarks tradeMark, Technologies technology, long price,
			int percentageDiscount, long priceDiscount, Weights weight, Heights height, int guarantee, Statuses status,
			VAT vat, int views, String option_best_selling, String description) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.tradeMark = tradeMark;
		this.technology = technology;
		this.price = price;
		this.percentageDiscount = percentageDiscount;
		this.priceDiscount = priceDiscount;
		this.weight = weight;
		this.height = height;
		this.guarantee = guarantee;
		this.status = status;
		this.vat = vat;
		this.views = views;
		this.option_best_selling = option_best_selling;
		this.description = description;
	}


}
