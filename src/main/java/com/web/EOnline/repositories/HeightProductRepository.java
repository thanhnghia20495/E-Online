package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Heights;

@Repository
public interface HeightProductRepository extends JpaRepository<Heights, Integer> {
	Heights findByHeightCode(int heightCode);
	public List<Heights> findAllByOrderByHeightCodeAsc();
}
