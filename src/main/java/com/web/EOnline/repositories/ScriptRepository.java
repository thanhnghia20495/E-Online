package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Scripts;

@Repository
public interface ScriptRepository extends JpaRepository<Scripts, Integer> {
	public Scripts  findByDescription(String description);
}
