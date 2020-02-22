package com.web.EOnline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class Keywords extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "keyword_id")
	private int keywordId;

	@Column(name = "keyword")
	private String keyWord;
	
	@Column(name = "active", nullable = true, length = 1)
	private String active;
	
	public Keywords() {
		// TODO Auto-generated constructor stub
	}

	public Keywords(String keyWord, String active) {
		super();
		this.keyWord = keyWord;
		this.active = active;
	}

	
}
