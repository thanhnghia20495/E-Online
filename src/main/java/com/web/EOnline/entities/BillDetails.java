package com.web.EOnline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class BillDetails extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_detail_id")
	private int billDetailId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id")
	private Bills bills;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_code")
	private Products products;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private long productPrice;

	@Column(name = "qty")
	private int qty;

	public BillDetails() {
		super();
	}

	public BillDetails(Bills bills, Products products, String productName, long productPrice, int qty) {
		super();
		this.bills = bills;
		this.products = products;
		this.productName = productName;
		this.productPrice = productPrice;
		this.qty = qty;
	}



}
