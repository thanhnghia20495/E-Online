package com.web.EOnline.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class TradeMarks extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trade_mark")
	private int tradeMarkId;

	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "tradeMark", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Products> listTradeMarkProduct = new ArrayList<Products>();
	
	public TradeMarks(String description) {
		super();
		this.description = description;
	}

	public TradeMarks() {
		// TODO Auto-generated constructor stub
	}
}
