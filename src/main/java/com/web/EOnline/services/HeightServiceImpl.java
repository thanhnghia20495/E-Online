package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Heights;
import com.web.EOnline.repositories.HeightProductRepository;

@Service
public class HeightServiceImpl implements HeightService {

	@Autowired
	HeightProductRepository heightProductRepository;

	@Override
	public Heights findHeightById(int heightCode) {

		return null;
	}

	@Override
	public Heights createHeight(Heights heights) {
		try {
			return heightProductRepository.save(heights);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Heights updateHeight(Heights heights) {
		try {
			return heightProductRepository.save(heights);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Heights> findAllByOrderByHeightCodeAsc() {
		try {
			return heightProductRepository.findAllByOrderByHeightCodeAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
