package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.BillingMethods;
import com.web.EOnline.repositories.BillingMethodRepository;

@Service
public class BillingMethodServiceImpl implements BillingMethodService {

	@Autowired
	BillingMethodRepository billingMethodRepository;

	@Override
	public BillingMethods findBillingMethodById(int billingMethodId) {
		try {
			return billingMethodRepository.findByBillingMethodId(billingMethodId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BillingMethods createBillingMethod(BillingMethods billingMethods) {
		try {
			return billingMethodRepository.save(billingMethods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BillingMethods updateBillingMethod(BillingMethods billingMethods) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BillingMethods> findAllBillingMethod() {
		try {
			return billingMethodRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
