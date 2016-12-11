package com.dmytrobr.quoteservice;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.dmytrobr.quoteservice.model.QuoteRequest.ActionEnum;
import com.dmytrobr.quoteservice.model.QuoteResponse;

public class BookAggregatorTest {
	BookAggregator bookAggregator = new BruteForceAggregator();

	@Test
	public void aggregate() throws Exception {
		List<List<String>> orders = Arrays.asList(
				Arrays.asList(new String[] { "5", "10", "1" }),
				Arrays.asList(new String[] { "4", "20", "1" }),
				Arrays.asList(new String[] { "3", "40", "1" }),
				Arrays.asList(new String[] { "2", "15", "1" }),
				Arrays.asList(new String[] { "1", "15", "1" }));
		QuoteResponse quoteResponse = bookAggregator.aggregateOrders(orders, "100",ActionEnum.BUY);
		assertEquals("295",quoteResponse.getTotal());
		assertEquals("2.95",quoteResponse.getPrice());
	}

}
