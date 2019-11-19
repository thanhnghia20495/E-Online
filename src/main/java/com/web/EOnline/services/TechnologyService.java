package com.web.EOnline.services;

import com.web.EOnline.entities.Technologies;

public interface TechnologyService {
	Technologies findByTechnologyId(int technologyId);

	Technologies createTechnology(Technologies technologies);

	Technologies updateTechnology(Technologies technologies);

}
