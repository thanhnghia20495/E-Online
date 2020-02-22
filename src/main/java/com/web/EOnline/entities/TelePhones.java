package com.web.EOnline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name = "telephones")
public class TelePhones extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private int phoneId;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id")
	private Contacts contact;
	
	@Column(name = "hot_line", length = 1, nullable = true)
	private String hotLine;
	
	public TelePhones(String phone_number, Contacts contact, String hotLine) {
		super();
		this.phoneNumber = phone_number;
		this.contact = contact;
		this.hotLine = hotLine;
	}

	public TelePhones() {
		// TODO Auto-generated constructor stub
	}
}
