package com.dmytrobr.quoteservice;

import java.util.List;

import com.dmytrobr.quoteservice.model.QuoteRequest.ActionEnum;
import com.dmytrobr.quoteservice.model.QuoteResponse;

public interface BookAggregator {
	public QuoteResponse aggregateOrders(List<List<String>> orders, String amount, ActionEnum actionEnum);

	public QuoteResponse aggregateInversedOrders(List<List<String>> bids, String amount, ActionEnum actionEnum);
}