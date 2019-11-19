package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.Weights;

public interface WeightService {
	Weights findWeightById(int weightCode);

	Weights createWeight(Weights weights);

	Weights updateWeight(Weights weights);

	List<Weights> findAllByOrderByWeightCodeAsc();
}
