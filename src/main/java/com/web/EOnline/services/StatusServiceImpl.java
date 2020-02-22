package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Statuses;
import com.web.EOnline.repositories.StatusProductRepository;

@Service
public class StatusServiceImpl implements StatusService{
	
	@Autowired
	StatusProductRepository statusProductRepository;
	
	@Override
	public Statuses findStatusById(int statusCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statuses createStatus(Statuses status) {
		try {
			return statusProductRepository.save(status);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Statuses updateStatus(Statuses status) {
		try {
			return statusProductRepository.save(status);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
