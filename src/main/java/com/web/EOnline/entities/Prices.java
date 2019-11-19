package com.web.EOnline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class Prices extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_id")
	private int priceId;

	@Column(name = "pricer_code", unique = true)
	private int priceCode;

	@Column(name = "from_price")
	private Long fromPrice;

	@Column(name = "to_price")
	private Long toPrice;

	@Column(name = "description")
	private String description;

	public Prices() {
		super();
	}

	public Prices(int priceCode, Long fromPrice, Long toPrice, String description) {
		super();
		this.priceCode = priceCode;
		this.fromPrice = fromPrice;
		this.toPrice = toPrice;
		this.description = description;
	}
}
