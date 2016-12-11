package com.dmytrobr.quoteservice.api;

import org.jboss.resteasy.test.TestPortProvider;

import com.dmytrobr.quoteservice.client.ApiClient;

public class ClientFactory {

	private static ApiClient apiClient;

	public static ApiClient getApiClient() {
		if (apiClient != null) {
			return apiClient;
		}

		apiClient = new ApiClient();
		apiClient.setBasePath(TestPortProvider.generateURL(""));
		
		

		apiClient.setDebugging(true);
		apiClient.setVerifyingSsl(false);

		return apiClient;
	}

}
