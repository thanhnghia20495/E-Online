package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Bills;
import com.web.EOnline.repositories.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillRepository billRepository;

	@Override
	public Bills findBillById(long billId) {
		try {
			return billRepository.findByBillId(billId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bills createBillingMethod(Bills bill) {
		try {
			return billRepository.save(bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bills updateBillingMethod(Bills bill) {
		// TODO Auto-generated method stub
		return null;
	}

}
