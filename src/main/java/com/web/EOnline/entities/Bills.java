package com.web.EOnline.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class Bills extends Auditable<String> {
	@Id
	@Column(name = "bill_id")
	private long billId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "email")
	private String email;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "address")
	private String address;

	@Column(name = "note")
	private String note;

	@Column(name = "total")
	private long total;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "billing_method_id")
	private BillingMethods billingMethods;
	
	@OneToMany(mappedBy = "bills", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<BillDetails> listBillDetails = new ArrayList<BillDetails>();
	
	public Bills(long billId, String customerName, String email, String telephone, String address, String note,
			long total, BillingMethods billingMethods) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.note = note;
		this.total = total;
		this.billingMethods = billingMethods;
	}

	public Bills() {
		super();
	}

}
