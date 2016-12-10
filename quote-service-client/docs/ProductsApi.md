# ProductsApi

All URIs are relative to *http://localhost/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**quotePost**](ProductsApi.md#quotePost) | **POST** /quote | Quote Sell or Buy transaction


<a name="quotePost"></a>
# **quotePost**
> QuoteResponse quotePost(quote)

Quote Sell or Buy transaction

Service will handle requests to buy or sell a particular amount of a currency (the base currency) with another currency (the quote currency). The service uses the orderbook to determine the best price the user would be able to get for that request by executing trades on GDAX. 

### Example
```java
// Import classes:
//import com.dmytrobr.quoteservice.client.ApiException;
//import com.dmytrobr.quoteservice.client.api.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
QuoteRequest quote = new QuoteRequest(); // QuoteRequest | Request your quote
try {
    QuoteResponse result = apiInstance.quotePost(quote);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#quotePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **quote** | [**QuoteRequest**](QuoteRequest.md)| Request your quote |

### Return type

[**QuoteResponse**](QuoteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

