package com.dmytrobr.quoteservice;

import java.util.List;

import com.dmytrobr.quoteservice.api.ApiException;
import com.dmytrobr.quoteservice.model.QuoteResponse;

public interface BookAggregator {
	public QuoteResponse aggregateOrders(List<List<String>> orders, String amount, boolean inverseOrders) throws ApiException;

}