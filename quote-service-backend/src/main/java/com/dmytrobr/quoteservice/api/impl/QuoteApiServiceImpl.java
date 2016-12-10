package com.dmytrobr.quoteservice.api.impl;

import com.dmytrobr.quoteservice.api.*;
import com.dmytrobr.quoteservice.model.*;


import com.dmytrobr.quoteservice.model.QuoteRequest;
import com.dmytrobr.quoteservice.model.Error;
import com.dmytrobr.quoteservice.model.QuoteResponse;

import java.util.List;
import com.dmytrobr.quoteservice.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-10T11:39:05.186-05:00")
public class QuoteApiServiceImpl extends QuoteApiService {
      @Override
      public Response quotePost(QuoteRequest quote,SecurityContext securityContext)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
}
