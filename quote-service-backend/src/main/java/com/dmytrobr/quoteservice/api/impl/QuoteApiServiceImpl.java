package com.dmytrobr.quoteservice.api.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.dmytrobr.quoteservice.BookAggregator;
import com.dmytrobr.quoteservice.BruteForceAggregator;
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
			return Response.status(404).entity("product does not exist for requested quote and base currencies")
					.build();
		}
		QuoteResponse quoteResponse;
		try {
			if (inversed) {
				switch (quote.getAction()) {
				case BUY:
					quoteResponse = bookAggregator.aggregateOrders(orderBook.getBids(), quote.getAmount(), true);
					break;
				case SELL:
					quoteResponse = bookAggregator.aggregateOrders(orderBook.getAsks(), quote.getAmount(), true);
					break;

				default:
					return Response.status(400).entity("requested quote action is not supported").build();
				}

			} else {
				switch (quote.getAction()) {
				case BUY:
					quoteResponse = bookAggregator.aggregateOrders(orderBook.getAsks(), quote.getAmount(), false);
					break;
				case SELL:
					quoteResponse = bookAggregator.aggregateOrders(orderBook.getBids(), quote.getAmount(), false);
					break;
				default:
					return Response.status(400).entity("requested quote action is not supported").build();
				}
			}
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		quoteResponse.setCurrency(quote.getQuoteCurrency());
		return Response.ok().entity(quoteResponse).build();
	}
}
