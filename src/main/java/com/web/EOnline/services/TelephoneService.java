package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.TelePhones;

public interface TelephoneService {
	List<TelePhones> findAllPhone();

	TelePhones createTelephone(TelePhones telePhone);

	TelePhones updateTelephone(TelePhones telePhone);
	
	public TelePhones findByHotLine(String hotLine);

}
