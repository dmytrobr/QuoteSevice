package com.dmytrobr.quoteservice;

import java.util.List;

import com.dmytrobr.quoteservice.api.ApiException;
import com.dmytrobr.quoteservice.model.QuoteRequest.ActionEnum;
import com.dmytrobr.quoteservice.model.QuoteResponse;

/**
 * Quoting algorithm relies on the fact that orders returned by GDAX API are
 * sorted by price
 *
 */
public class BruteForceAggregator implements BookAggregator {

	private static class Order {
		double price;
		double size;
		int numOrders;

		private static Order parseOrder(List<String> stringOrder) {
			Order order = new Order();
			order.price = Double.parseDouble(stringOrder.get(0));
			order.size = Double.parseDouble(stringOrder.get(1));
			order.numOrders = Integer.parseInt(stringOrder.get(2));
			return order;
		}

		private static Order parseOrderInverse(List<String> stringOrder) {
			Order order = new Order();
			order.price = 1 / Double.parseDouble(stringOrder.get(0));
			order.size = Double.parseDouble(stringOrder.get(1)) * Double.parseDouble(stringOrder.get(0));
			order.numOrders = Integer.parseInt(stringOrder.get(2));
			return order;
		}

	}

	public QuoteResponse aggregateOrders(List<List<String>> orders, String amount, boolean inverseOrders)
			throws ApiException {
		double requestedAmount = 0;
		try {
			requestedAmount = Double.parseDouble(amount);
		} catch (Exception e) {
			throw new ApiException(400, e.getMessage());

		}
		double totalAmountFound = 0;
		double totalCost = 0;
		for (List<String> stringOrder : orders) {
			Order order = inverseOrders ? Order.parseOrderInverse(stringOrder) : Order.parseOrder(stringOrder);
			for (int i = 0; i < order.numOrders; i++) {
				if (totalAmountFound + order.size < requestedAmount) {
					totalCost += order.size * order.price;
					totalAmountFound += order.size;
				} else {
					double amountLeft = requestedAmount - totalAmountFound;
					totalCost += amountLeft * order.price;
					totalAmountFound += amountLeft;
					return buildResponse(totalAmountFound, totalCost);
				}
			}
		}
		throw new ApiException(400, Messages.NOT_ENOUGH_ORDERS.getMessage());
	}

	private QuoteResponse buildResponse(double totalAmountFound, double totalCost) {
		QuoteResponse quoteResponse = new QuoteResponse();
		quoteResponse.setPrice(Double.toString(totalCost / totalAmountFound));
		quoteResponse.setTotal(Double.toString(totalCost));
		return quoteResponse;
	}

}
