package com.dmytrobr.quoteservice.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.dmytrobr.quoteservice.model.QuoteRequest;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-10T11:39:05.186-05:00")
public abstract class QuoteApiService {
      public abstract Response quotePost(QuoteRequest quote,SecurityContext securityContext)
      throws NotFoundException;
}
