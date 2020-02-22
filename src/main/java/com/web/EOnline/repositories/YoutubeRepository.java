package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Scripts;
import com.web.EOnline.entities.Youtube;

@Repository
public interface YoutubeRepository extends JpaRepository<Youtube, Integer> {
	public Scripts  findByDescription(String description);
}
