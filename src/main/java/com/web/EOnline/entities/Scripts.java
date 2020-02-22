package com.web.EOnline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class Scripts extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "script_id")
	private int scriptId;

	@Column(name = "description")
	private String description;
	
	@Lob
	@Column(name = "what")
	private String what;
	
	public Scripts() {
		// TODO Auto-generated constructor stub
	}

	public Scripts(String description, String what) {
		super();
		this.description = description;
		this.what = what;
	}
}
