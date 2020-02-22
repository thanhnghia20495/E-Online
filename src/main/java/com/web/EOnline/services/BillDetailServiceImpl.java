package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.BillDetails;
import com.web.EOnline.repositories.BillDetalRepository;

@Service
public class BillDetailServiceImpl implements BillDetailService {

	@Autowired
	BillDetalRepository billDetalRepository;

	@Override
	public BillDetails findBillById(int billDetailId) {
		try {
			return billDetalRepository.findByBillDetailId(billDetailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BillDetails createBillingMethod(BillDetails billDetail) {
		try {
			return billDetalRepository.save(billDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BillDetails updateBillingMethod(BillDetails billDetail) {
		// TODO Auto-generated method stub
		return null;
	}

}
