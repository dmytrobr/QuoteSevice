package com.dmytrobr.quoteservice.api.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.dmytrobr.quoteservice.api.NotFoundException;
import com.dmytrobr.quoteservice.api.QuoteApiService;
import com.dmytrobr.quoteservice.api.factories.ClientFactory;
import com.dmytrobr.quoteservice.model.QuoteRequest;
import com.dmytrobr.quoteservice.model.QuoteResponse;
import com.gdax.service.ApiException;
import com.gdax.service.client.api.ProductsApi;
import com.gdax.service.client.model.ProductBookResponse;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-10T11:39:05.186-05:00")
public class QuoteApiServiceImpl extends QuoteApiService {
	@Override
	public Response quoteTransaction(QuoteRequest quote, SecurityContext securityContext) throws NotFoundException {

		ProductsApi gdaxApi = new ProductsApi(ClientFactory.getGdaxApiClient());
		try {
			String productId = quote.getBaseCurrency()+quote.getQuoteCurrency();
			ProductBookResponse orderBook = gdaxApi.getProductOrderBook(productId, "2");
			QuoteResponse quoteResponse = new QuoteResponse();
			quoteResponse.setCurrency(quote.getQuoteCurrency());
			String price = "TODO";
			quoteResponse.setPrice(price);

			return Response.ok().entity(quoteResponse).build();
		} catch (ApiException e) {
			return Response.status(e.getCode()).build();
		}
	}
}
