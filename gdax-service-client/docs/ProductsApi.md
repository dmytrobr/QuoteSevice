# ProductsApi

All URIs are relative to *https://api.gdax.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProductOrderBook**](ProductsApi.md#getProductOrderBook) | **GET** /products/{productId}/book | Book fors selected product


<a name="getProductOrderBook"></a>
# **getProductOrderBook**
> ProductBookResponse getProductOrderBook(productId, level)

Book fors selected product

### Example
```java
// Import classes:
//import com.gdax.service.ApiException;
//import com.gdax.service.client.api.ProductsApi;


ProductsApi apiInstance = new ProductsApi();
String productId = "productId_example"; // String | 
String level = "level_example"; // String | 
try {
    ProductBookResponse result = apiInstance.getProductOrderBook(productId, level);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductsApi#getProductOrderBook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **String**|  |
 **level** | **String**|  | [optional]

### Return type

[**ProductBookResponse**](ProductBookResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

