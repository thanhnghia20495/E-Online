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
public class BillingMethods extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "billing_method_id")
	private int billingMethodId;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "billingMethods", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Bills> listBillingMethods = new ArrayList<Bills>();

	public BillingMethods(String description) {
		super();
		this.description = description;
	}

	public BillingMethods() {
		// TODO Auto-generated constructor stub
	}
}
