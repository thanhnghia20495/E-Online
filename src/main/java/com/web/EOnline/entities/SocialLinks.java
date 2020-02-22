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
public class SocialLinks extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "link_id")
	private int linkId;

	@Column(name = "description")
	private String description;

	@Lob
	@Column(name = "link")
	private String link;

	public SocialLinks() {
		// TODO Auto-generated constructor stub
	}

	public SocialLinks(String description, String link) {
		super();
		this.description = description;
		this.link = link;
	}
}
