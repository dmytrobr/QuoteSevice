package com.dmytrobr.quoteservice.api.factories;

import com.gdax.service.ApiClient;

public class ClientFactory {

	private static final String GDAX_API_URL = "https://api.gdax.com";
	private static ApiClient apiClient;

	public static ApiClient getGdaxApiClient() {
		if (apiClient != null) {
			return apiClient;
		}

		apiClient = new ApiClient();
		apiClient.setBasePath(GDAX_API_URL);
		apiClient.setUserAgent("QuoteApi");

		apiClient.setDebugging(true);
		apiClient.setVerifyingSsl(false);

		return apiClient;
	}

}
