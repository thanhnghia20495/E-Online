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
public class Heights extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "height_id")
	private int heightId;

	@Column(name = "height_code", unique = true)
	private int heightCode;

	@Column(name = "height")
	private Float height;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "height", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Products> listHeightProduct = new ArrayList<Products>();

	public Heights() {
		super();
	}

	public Heights(int heightCode, Float height, String description) {
		super();
		this.heightCode = heightCode;
		this.height = height;
		this.description = description;
	}

}