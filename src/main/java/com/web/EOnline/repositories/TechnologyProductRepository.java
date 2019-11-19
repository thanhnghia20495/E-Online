package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Technologies;

@Repository
public interface TechnologyProductRepository extends JpaRepository<Technologies, Integer> {
	Technologies findByTechnologyId(int technologyId);
}
