package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.TelePhones;
import com.web.EOnline.repositories.TelephoneRepository;

@Service
public class TelephoneServiceImpl implements TelephoneService {

	@Autowired
	TelephoneRepository telephoneRepository;

	@Override
	public List<TelePhones> findAllPhone() {
		try {
			return telephoneRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TelePhones createTelephone(TelePhones telePhone) {
		try {
			return telephoneRepository.save(telePhone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TelePhones updateTelephone(TelePhones telePhone) {
		try {
			return telephoneRepository.save(telePhone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TelePhones findByHotLine(String hotLine) {
		try {
			return telephoneRepository.findByHotLine(hotLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
