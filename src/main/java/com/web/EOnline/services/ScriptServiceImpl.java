package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Scripts;
import com.web.EOnline.repositories.ScriptRepository;

@Service
public class ScriptServiceImpl implements ScriptService {

	@Autowired
	ScriptRepository scriptRepository;

	@Override
	public Scripts findScriptByDescription(String description) {
		try {
			return scriptRepository.findByDescription(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Scripts createScript(Scripts script) {
		try {
			return scriptRepository.save(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Scripts updateScript(Scripts script) {
		try {
			return scriptRepository.save(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
