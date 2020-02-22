package com.web.EOnline.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category2_id")
	private Category2 category2;

	@Column(name = "views")
	private int views;

	@Column(name = "option_best_selling", length = 1)
	private String optionBestSelling;

	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "y_id")
	private Youtube youtube;
	
	@Column(name = "option_youtube", length = 1)
	private String optionYoutube;
	
	@JsonIgnore
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<BillDetails> listBillDetails = new ArrayList<BillDetails>();

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(String productCode, String productName, TradeMarks tradeMark, Technologies technology, long price,
			int percentageDiscount, long priceDiscount, Weights weight, Heights height, int guarantee, Statuses status,
			VAT vat, Category2 category2, int views, String optionBestSelling, String description,
			List<BillDetails> listBillDetails) {
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
		this.category2 = category2;
		this.views = views;
		this.optionBestSelling = optionBestSelling;
		this.description = description;
		this.listBillDetails = listBillDetails;
	}

}
