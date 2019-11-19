package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.TradeMarks;

@Repository
public interface TradeMarkProductRepository extends JpaRepository<TradeMarks, Integer> {
	TradeMarks findByTradeMarkId(int tradeMarkId);
}
