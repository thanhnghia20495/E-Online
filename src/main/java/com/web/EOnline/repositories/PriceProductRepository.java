package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Prices;

@Repository
public interface PriceProductRepository extends JpaRepository<Prices, Integer> {
	Prices findByPriceCode(int priceCode);
	public List<Prices> findAllByOrderByPriceCodeAsc();
}
