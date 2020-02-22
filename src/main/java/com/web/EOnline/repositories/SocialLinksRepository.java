package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Scripts;
import com.web.EOnline.entities.SocialLinks;

@Repository
public interface SocialLinksRepository extends JpaRepository<SocialLinks, Integer> {
	public SocialLinks  findByDescription(String description);
}
