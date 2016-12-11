package com.dmytrobr.quoteservice.api;

import static org.junit.Assert.*;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dmytrobr.quoteservice.RestApplication;
import com.dmytrobr.quoteservice.client.ApiException;
import com.dmytrobr.quoteservice.client.Configuration;
import com.dmytrobr.quoteservice.client.api.QuoteApi;
import com.dmytrobr.quoteservice.client.model.QuoteRequest;
import com.dmytrobr.quoteservice.client.model.QuoteRequest.ActionEnum;
import com.dmytrobr.quoteservice.client.model.QuoteResponse;

/**
 * API tests for ProductsApi
 */
public class QuoteApiTest {

	private final QuoteApi api = new QuoteApi();

	@BeforeClass
	public static void startEmbeddedServer() {
		Configuration.setDefaultApiClient(ClientFactory.getApiClient());

		UndertowJaxrsServer server = new UndertowJaxrsServer().start();
		server.deploy(RestApplication.class);
	}

	/**
	 * Quote Sell or Buy transaction
	 *
	 * Service will handle requests to buy or sell a particular amount of a
	 * currency (the base currency) with another currency (the quote currency).
	 * The service uses the orderbook to determine the best price the user would
	 * be able to get for that request by executing trades on GDAX.
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void quoteTransactionTest() throws ApiException {
		QuoteRequest quote = new QuoteRequest();

		quote.action(ActionEnum.BUY);
		quote.amount("123");
		quote.baseCurrency("BTC");
		quote.quoteCurrency("USD");

		QuoteResponse response = api.quoteTransaction(quote);
		assertNotNull(response);
		assertNotNull(response.getCurrency());
		assertNotNull(response.getPrice());
		assertNotNull(response.getTotal());

	}

	@Test
	public void quoteTransactionInvalidProduct() throws ApiException {
		QuoteRequest quote = new QuoteRequest();

		quote.action(ActionEnum.BUY);
		quote.amount("123");
		quote.baseCurrency("USD");
		quote.quoteCurrency("BTC1");

		try {
			api.quoteTransaction(quote);
		} catch (ApiException e) {
			assertEquals(404, e.getCode());
		}

	}

}
