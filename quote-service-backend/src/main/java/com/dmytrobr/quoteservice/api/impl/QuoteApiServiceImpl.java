package com.dmytrobr.quoteservice.api.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.dmytrobr.quoteservice.BookAggregator;
import com.dmytrobr.quoteservice.BruteForceAggregator;
import com.dmytrobr.quoteservice.Messages;
import com.dmytrobr.quoteservice.api.ApiException;
import com.dmytrobr.quoteservice.api.NotFoundException;
import com.dmytrobr.quoteservice.api.QuoteApiService;
import com.dmytrobr.quoteservice.api.factories.ClientFactory;
import com.dmytrobr.quoteservice.model.QuoteRequest;
import com.dmytrobr.quoteservice.model.QuoteResponse;
import com.gdax.service.client.api.ProductsApi;
import com.gdax.service.client.model.ProductBookResponse;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-10T11:39:05.186-05:00")
public class QuoteApiServiceImpl extends QuoteApiService {
	private BookAggregator bookAggregator = new BruteForceAggregator();

	@Override
	public Response quoteTransaction(QuoteRequest quote, SecurityContext securityContext) throws NotFoundException {

		String productId = quote.getBaseCurrency() + "-" + quote.getQuoteCurrency();
		ProductsApi gdaxApi = new ProductsApi(ClientFactory.getGdaxApiClient());
		ProductBookResponse orderBook;
		boolean inversed = false;
		try {
			try {
				orderBook = gdaxApi.getProductOrderBook(productId, "2");
			} catch (com.gdax.service.ApiException e) {
				if (e.getCode() == 404) {
					// trying to find inverse product
					String reverseProductId = quote.getQuoteCurrency() + "-" + quote.getBaseCurrency();
					orderBook = gdaxApi.getProductOrderBook(reverseProductId, "2");
					inversed = true;
				} else {
					throw e;
				}
			}
		} catch (com.gdax.service.ApiException e) {
			return Response.status(404).entity(Messages.PRODUCT_NOT_FOUND.getMessage())
					.build();
		}
		QuoteResponse quoteResponse;
		try {
			List<List<String>> ordersToUse;
			switch (quote.getAction()) {
			case BUY:
				ordersToUse = inversed ? orderBook.getBids() : orderBook.getAsks();
				break;
			case SELL:
				ordersToUse = inversed ? orderBook.getAsks() : orderBook.getBids();
				break;

			default:
				return Response.status(400).entity(Messages.ACTION_NOT_SUPPORTED.getMessage()).build();
			}

			quoteResponse = bookAggregator.aggregateOrders(ordersToUse, quote.getAmount(), inversed);
		} catch (

		ApiException e) {
			return Response.status(e.getCode()).entity(e.getMessage()).build();
		}
		quoteResponse.setCurrency(quote.getQuoteCurrency());
		return Response.ok().entity(quoteResponse).build();
	}
}
