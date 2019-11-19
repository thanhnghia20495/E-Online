package com.web.EOnline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.TradeMarks;
import com.web.EOnline.repositories.TradeMarkProductRepository;

@Service
public class TradeMarkServiceImpl implements TradeMarkService {

	@Autowired
	TradeMarkProductRepository tradeMarkProductRepository;

	@Override
	public TradeMarks findByTradeMarkId(int tradeMarkId) {
		return tradeMarkProductRepository.findByTradeMarkId(tradeMarkId);
	}

	@Override
	public TradeMarks createTradeMark(TradeMarks tradeMarks) {
		return tradeMarkProductRepository.save(tradeMarks);
	}

	@Override
	public TradeMarks updateTradeMark(TradeMarks tradeMarks) {
		return tradeMarkProductRepository.save(tradeMarks);
	}

}
