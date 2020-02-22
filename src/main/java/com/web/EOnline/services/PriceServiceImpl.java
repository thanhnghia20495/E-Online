package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.Prices;
import com.web.EOnline.repositories.PriceProductRepository;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PriceProductRepository priceProductRepository;

	@Override
	public Prices findPriceById(int priceCode) {
		return priceProductRepository.findByPriceCode(priceCode);
	}

	@Override
	public Prices createPrice(Prices prices) {
		try {
			return priceProductRepository.save(prices);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Prices updatePrice(Prices prices) {
		try {
			return priceProductRepository.save(prices);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Prices> findAllByOrderByPriceCodeAsc() {
		try {
			return priceProductRepository.findAllByOrderByPriceCodeAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
