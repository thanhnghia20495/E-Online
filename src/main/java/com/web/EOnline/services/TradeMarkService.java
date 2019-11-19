package com.web.EOnline.services;

import com.web.EOnline.entities.TradeMarks;

public interface TradeMarkService {
	TradeMarks findByTradeMarkId(int tradeMarkId);

	TradeMarks createTradeMark(TradeMarks tradeMarks);

	TradeMarks updateTradeMark(TradeMarks tradeMarks);

}
