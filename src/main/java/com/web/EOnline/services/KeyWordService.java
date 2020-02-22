package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.Keywords;

public interface KeyWordService {

	List<Keywords> findAllKeywords();
	
	List<Keywords> findKeywordsByActive(String active);
	
	Keywords createKeyWord(Keywords keyword);

	Keywords updateKeyWord(Keywords keyword);

}
