package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.Contacts;

public interface ContactService {
	List<Contacts> findAllContact();

	Contacts createContact(Contacts contact);

	Contacts updateContact(Contacts contact);


}
