package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Weights;

@Repository
public interface WeightProductRepository extends JpaRepository<Weights, Integer> {
	Weights findByWeightCode(int weightCode);
	public List<Weights> findAllByOrderByWeightCodeAsc();
}
