package com.dmytrobr.quoteservice;

import java.util.List;

import com.dmytrobr.quoteservice.model.QuoteRequest.ActionEnum;
import com.dmytrobr.quoteservice.model.QuoteResponse;

public class BruteForceAggregator implements BookAggregator {

	public QuoteResponse aggregateOrders(List<List<String>> orders, String amount, ActionEnum action) {

		double requestedAmount = Double.parseDouble(amount);
		double totalAmountFound=0;
		double totalCost=0;
		for (List<String> order : orders) {
			double price = Double.parseDouble(order.get(0));
			double size = Double.parseDouble(order.get(1));
			int numOrders = Integer.parseInt(order.get(2));
			if(size<requestedAmount){
				for (int i = 0; i < numOrders; i++) {
					totalCost+=size*price;
					totalAmountFound+=size;
				}
				
			}

		}

		QuoteResponse quoteResponse = new QuoteResponse();
		quoteResponse.setCurrency("USD");
		quoteResponse.setPrice("100");
		quoteResponse.setTotal("1000");

		return quoteResponse;
	}

	public QuoteResponse aggregateInversedOrders(List<List<String>> bids, String amount, ActionEnum action) {
		// TODO Auto-generated method stub
		return null;
	}

}
