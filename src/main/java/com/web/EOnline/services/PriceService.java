package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.Prices;

public interface PriceService {
	Prices findPriceById(int priceCode);

	Prices createPrice(Prices prices);
	
	Prices updatePrice(Prices prices);

	List<Prices> findAllByOrderByPriceCodeAsc();

}
