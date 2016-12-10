/**
 * Quote Service API
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dmytrobr.quoteservice.client.api;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dmytrobr.quoteservice.RestApplication;
import com.dmytrobr.quoteservice.client.ApiException;
import com.dmytrobr.quoteservice.client.Configuration;
import com.dmytrobr.quoteservice.client.model.QuoteRequest;
import com.dmytrobr.quoteservice.client.model.QuoteRequest.ActionEnum;
import com.dmytrobr.quoteservice.client.model.QuoteResponse;

/**
 * API tests for ProductsApi
 */
public class ProductsApiTest {

	private final ProductsApi api = new ProductsApi();

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
	public void quotePostTest() throws ApiException {
		QuoteRequest quote = new QuoteRequest();

		quote.setAction(ActionEnum.BUY);
		QuoteResponse response = api.quotePost(quote);

		// TODO: test validations
	}

}
