package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.VAT;
import com.web.EOnline.repositories.VATProductRepository;

@Service
public class VATServiceImpl implements VATService {

	@Autowired
	VATProductRepository vatProductRepository;

	@Override
	public VAT findByVATId(int VATId) {
		return vatProductRepository.findByVatId(VATId);
	}

	@Override
	public VAT createVAT(VAT VAT) {
		return vatProductRepository.save(VAT);
	}

	@Override
	public VAT updateVAT(VAT VAT) {
		return vatProductRepository.save(VAT);
	}

}
