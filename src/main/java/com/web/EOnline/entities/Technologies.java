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
public class Technologies extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "technology_id")
	private int technologyId;

	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "technology", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Products> listTechnologyProduct = new ArrayList<Products>();
	
	public Technologies(String description) {
		super();
		this.description = description;
	}

	public Technologies() {
		// TODO Auto-generated constructor stub
	}
}
