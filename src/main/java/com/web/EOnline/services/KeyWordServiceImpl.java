package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Keywords;
import com.web.EOnline.repositories.KeyWordRepository;

@Service
public class KeyWordServiceImpl implements KeyWordService {

	@Autowired
	KeyWordRepository keyWordRepository;

	@Override
	public List<Keywords> findAllKeywords() {
		try {
			return keyWordRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Keywords createKeyWord(Keywords keyword) {
		try {
			return keyWordRepository.save(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Keywords updateKeyWord(Keywords keyword) {
		try {
			return keyWordRepository.save(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Keywords> findKeywordsByActive(String active) {
		try {
			return keyWordRepository.findByActive(active);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
