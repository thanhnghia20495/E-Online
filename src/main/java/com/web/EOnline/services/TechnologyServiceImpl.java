package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Technologies;
import com.web.EOnline.repositories.TechnologyProductRepository;

@Service
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	TechnologyProductRepository technologyProductRepository;

	@Override
	public Technologies findByTechnologyId(int technologyId) {
		return technologyProductRepository.findByTechnologyId(technologyId);
	}

	@Override
	public Technologies createTechnology(Technologies technologies) {
		return technologyProductRepository.save(technologies);
	}

	@Override
	public Technologies updateTechnology(Technologies technologies) {
		return technologyProductRepository.save(technologies);
	}

}
