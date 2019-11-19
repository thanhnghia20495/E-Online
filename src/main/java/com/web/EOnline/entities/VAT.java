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
public class VAT extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VAT_id")
	private int vatId;

	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "vat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Products> listVATProduct = new ArrayList<Products>();
	
	public VAT(String description) {
		super();
		this.description = description;
	}

	public VAT() {
		// TODO Auto-generated constructor stub
	}
}
