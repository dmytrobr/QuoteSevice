package com.dmytrobr.quoteservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.dmytrobr.quoteservice.api.ApiException;
import com.dmytrobr.quoteservice.model.QuoteResponse;

public class BookAggregatorTest {
	private static final double COMPARISON_DELTA = 0.000001;
	BookAggregator bookAggregator = new BruteForceAggregator();

	@SuppressWarnings("unchecked")
	@Test
	public void aggregate() throws Exception {
		List<List<String>> orders = Arrays.asList(
				Arrays.asList(new String[] { "5", "10", "1" }),
				Arrays.asList(new String[] { "4", "20", "1" }),
				Arrays.asList(new String[] { "3", "40", "1" }),
				Arrays.asList(new String[] { "2", "15", "1" }), 
				Arrays.asList(new String[] { "1", "15", "1" }));
		QuoteResponse quoteResponse = bookAggregator.aggregateOrders(orders, "100", false);
		assertEquals(295.0, Double.parseDouble(quoteResponse.getTotal()), COMPARISON_DELTA);
		assertEquals(2.95, Double.parseDouble(quoteResponse.getPrice()), COMPARISON_DELTA);
	}
	
	@Test
	public void aggregateWithEmptyOrderList() throws Exception {
		List<List<String>> orders = Collections.emptyList();
		try {
			bookAggregator.aggregateOrders(orders, "100", false);
		} catch (ApiException e) {
			assertEquals(400,e.getCode());
			assertEquals(Messages.NOT_ENOUGH_ORDERS.getMessage(),e.getMessage());
			return;
		}
		fail("Exception should occur in prior code");
	}


	@SuppressWarnings("unchecked")
	@Test
	public void aggregateSell() throws Exception {
		List<List<String>> orders = Arrays.asList(
				Arrays.asList(new String[] { "1", "15", "1" }),
				Arrays.asList(new String[] { "2", "15", "1" }),
				Arrays.asList(new String[] { "3", "40", "1" }),
				Arrays.asList(new String[] { "4", "20", "1" }),
				Arrays.asList(new String[] { "5", "10", "1" }));
		QuoteResponse quoteResponse = bookAggregator.aggregateOrders(orders, "100", false);
		assertEquals(295, Double.parseDouble(quoteResponse.getTotal()), COMPARISON_DELTA);
		assertEquals(2.95, Double.parseDouble(quoteResponse.getPrice()), COMPARISON_DELTA);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void aggregateTakeSplitBiggerOrder() throws Exception {
		List<List<String>> orders = Arrays.asList(
				Arrays.asList(new String[] { "5", "10", "1" }),
				Arrays.asList(new String[] { "4", "20", "1" }),
				Arrays.asList(new String[] { "3", "1000", "1" }));
		QuoteResponse quoteResponse = bookAggregator.aggregateOrders(orders, "100", false);
		assertEquals(340, Double.parseDouble(quoteResponse.getTotal()), COMPARISON_DELTA);
		assertEquals(3.40, Double.parseDouble(quoteResponse.getPrice()), COMPARISON_DELTA);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void aggregateManyOrdersWithTheSamePrice() throws Exception {
		List<List<String>> orders = Arrays.asList(
				Arrays.asList(new String[] { "5.1", "11", "10" }),
				Arrays.asList(new String[] { "4.9", "11", "10" }));

		QuoteResponse quoteResponse = bookAggregator.aggregateOrders(orders, "100", false);
		assertEquals(510.0, Double.parseDouble(quoteResponse.getTotal()), COMPARISON_DELTA);
		assertEquals(5.1, Double.parseDouble(quoteResponse.getPrice()), COMPARISON_DELTA);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void notEnoughOrdersForQuotedAmount() throws Exception {
		List<List<String>> orders = Arrays.asList(
				Arrays.asList(new String[] { "5.1", "11", "10" }),
				Arrays.asList(new String[] { "4.9", "11", "10" }));

		try {
			bookAggregator.aggregateOrders(orders, "10000", false);
		} catch (ApiException e) {
			assertEquals(400,e.getCode());
			assertEquals(Messages.NOT_ENOUGH_ORDERS.getMessage(),e.getMessage());
			return;
		}
		fail("Exception should occur in prior code");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void aggregateInverse() throws Exception {
		List<List<String>> orders = Arrays.asList(
				Arrays.asList(new String[] { "5", "10", "1" }),
				Arrays.asList(new String[] { "4", "20", "1" }),
				Arrays.asList(new String[] { "3", "40", "1" }),
				Arrays.asList(new String[] { "2", "15", "1" }), 
				Arrays.asList(new String[] { "1", "15", "1" }));
		QuoteResponse quoteResponse = bookAggregator.aggregateOrders(orders, "100", true);
		assertEquals(22.5, Double.parseDouble(quoteResponse.getTotal()), COMPARISON_DELTA);
		assertEquals(0.225, Double.parseDouble(quoteResponse.getPrice()), COMPARISON_DELTA);
	}

}
