package com.dmytrobr.quoteservice.api.factories;

import com.gdax.service.ApiClient;

public class ClientFactory {

	private static ApiClient apiClient;

	public static ApiClient getGdaxApiClient() {
		if (apiClient != null) {
			return apiClient;
		}

		apiClient = new ApiClient();
		apiClient.setBasePath("https://api.gdax.com");

		apiClient.setDebugging(true);
		apiClient.setVerifyingSsl(false);

		return apiClient;
	}

}
