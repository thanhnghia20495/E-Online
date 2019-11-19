package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.Heights;

public interface HeightService {
	Heights findHeightById(int heightCode);

	Heights createHeight(Heights heights);

	Heights updateHeight(Heights heights);

	List<Heights> findAllByOrderByHeightCodeAsc();

}
