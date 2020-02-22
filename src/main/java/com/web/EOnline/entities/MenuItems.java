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
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name = "menu_item")
public class MenuItems extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private int menuId;

	@Column(name = "path_url")
	private String pathUrl;

	@Column(name = "description")
	private String description;

	@Column(name = "order_id")
	private int order;

	@OneToMany(mappedBy = "menuItems", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Category1> listCategory1 = new ArrayList<Category1>();

	public MenuItems() {
		// TODO Auto-generated constructor stub
	}

	public MenuItems(String pathUrl, String description, int order) {
		super();
		this.pathUrl = pathUrl;
		this.description = description;
		this.order = order;
	}
}
