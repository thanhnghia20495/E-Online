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
public class Weights extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "weight_id")
	private int weightId;
	
	@Column(name = "weight_code", unique = true)
	private int weightCode;

	@Column(name = "weight")
	private Integer weight;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "weight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Products> listWeightProduct = new ArrayList<Products>();
	
	public Weights() {
		super();
	}

	public Weights(int weightCode, Integer weight, String description) {
		super();
		this.weightCode = weightCode;
		this.weight = weight;
		this.description = description;
	}

}