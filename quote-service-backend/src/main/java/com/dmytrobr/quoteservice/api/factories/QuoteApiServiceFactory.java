package com.dmytrobr.quoteservice.api.factories;

import com.dmytrobr.quoteservice.api.QuoteApiService;
import com.dmytrobr.quoteservice.api.impl.QuoteApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-10T11:39:05.186-05:00")
public class QuoteApiServiceFactory {

   private final static QuoteApiService service = new QuoteApiServiceImpl();

   public static QuoteApiService getQuoteApi()
   {
      return service;
   }
}
