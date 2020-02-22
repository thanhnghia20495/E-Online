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
@Table(name = "category_1")
public class Category1 extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category1_id")
	private int category1Id;

	@Column(name = "path_url")
	private String pathUrl;

	@Column(name = "description")
	private String description;

	@Column(name = "order_id")
	private int order;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "menu_id")
	private MenuItems menuItems;

	@OneToMany(mappedBy = "category1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Category2> listCategory2 = new ArrayList<Category2>();

	public Category1() {
		// TODO Auto-generated constructor stub
	}

	public Category1(String pathUrl, String description, int order, MenuItems menuItems) {
		super();
		this.pathUrl = pathUrl;
		this.description = description;
		this.order = order;
		this.menuItems = menuItems;
	}

}
