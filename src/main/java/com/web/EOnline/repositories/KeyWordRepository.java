package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Keywords;

@Repository
public interface KeyWordRepository extends JpaRepository<Keywords, Integer> {
	public List<Keywords> findByActive(String active);
}
