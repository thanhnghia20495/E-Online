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
public class Statuses extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int statusId;
	
	
	@Column(name = "status_code", unique = true)
	private int statusCode;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Products> listStatusProduct = new ArrayList<Products>();
	
	public Statuses() {
	}

	public Statuses(int statusCode, String description) {
		super();
		this.statusCode = statusCode;
		this.description = description;
	}

}