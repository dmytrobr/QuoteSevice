package com.dmytrobr.quoteservice.api;

import com.dmytrobr.quoteservice.model.*;
import com.dmytrobr.quoteservice.api.QuoteApiService;
import com.dmytrobr.quoteservice.api.factories.QuoteApiServiceFactory;

import com.dmytrobr.quoteservice.model.QuoteRequest;
import com.dmytrobr.quoteservice.model.Error;
import com.dmytrobr.quoteservice.model.QuoteResponse;

import java.util.List;
import com.dmytrobr.quoteservice.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/quote")

@Produces({ "application/json" })
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-10T11:39:05.186-05:00")
public class QuoteApi  {
   private final QuoteApiService delegate = QuoteApiServiceFactory.getQuoteApi();

    @POST
    
    
    @Produces({ "application/json" })
    public Response quotePost( QuoteRequest quote,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.quotePost(quote,securityContext);
    }
}
