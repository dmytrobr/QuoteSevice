# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.dmytrobr.quoteservice.client.*;
import com.dmytrobr.quoteservice.client.auth.*;
import com.dmytrobr.quoteservice.client.model.*;
import com.dmytrobr.quoteservice.client.api.ProductsApi;

import java.io.File;
import java.util.*;

public class ProductsApiExample {

    public static void main(String[] args) {
        
        ProductsApi apiInstance = new ProductsApi();
        QuoteRequest quote = new QuoteRequest(); // QuoteRequest | Request your quote
        try {
            QuoteResponse result = apiInstance.quotePost(quote);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductsApi#quotePost");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ProductsApi* | [**quotePost**](docs/ProductsApi.md#quotePost) | **POST** /quote | Quote Sell or Buy transaction


## Documentation for Models

 - [Error](docs/Error.md)
 - [QuoteRequest](docs/QuoteRequest.md)
 - [QuoteResponse](docs/QuoteResponse.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



