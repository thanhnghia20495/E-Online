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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name = "category_2")
public class Category2 extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category2_id")
	private int category2Id;

	@Column(name = "path_url")
	private String pathUrl;

	@Column(name = "description")
	private String description;

	@Column(name = "order_id")
	private int order;
	
	@Column(name = "option_best_selling", length = 1)
	private String optionBestSelling;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category1_id")
	private Category1 category1;
	
	@OneToMany(mappedBy = "category2", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Products> listProducts = new ArrayList<Products>();
	
	public Category2() {
		// TODO Auto-generated constructor stub
	}

	public Category2(String pathUrl, String description, int order, String optionBestSelling, Category1 category1) {
		super();
		this.pathUrl = pathUrl;
		this.description = description;
		this.order = order;
		this.optionBestSelling = optionBestSelling;
		this.category1 = category1;
	}


}
