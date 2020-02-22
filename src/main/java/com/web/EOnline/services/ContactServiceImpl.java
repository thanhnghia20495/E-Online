package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Contacts;
import com.web.EOnline.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public List<Contacts> findAllContact() {
		try {
			return contactRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Contacts createContact(Contacts contact) {
		try {
			return contactRepository.save(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Contacts updateContact(Contacts contact) {
		try {
			return contactRepository.save(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
