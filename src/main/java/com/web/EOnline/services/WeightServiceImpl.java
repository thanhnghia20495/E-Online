package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Weights;
import com.web.EOnline.repositories.WeightProductRepository;

@Service
public class WeightServiceImpl implements WeightService {

	@Autowired
	WeightProductRepository weightProductRepository;

	@Override
	public Weights findWeightById(int weightCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weights createWeight(Weights weights) {
		try {
			return weightProductRepository.save(weights);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Weights updateWeight(Weights weights) {
		try {
			return weightProductRepository.save(weights);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Weights> findAllByOrderByWeightCodeAsc() {
		try {
			return weightProductRepository.findAllByOrderByWeightCodeAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
