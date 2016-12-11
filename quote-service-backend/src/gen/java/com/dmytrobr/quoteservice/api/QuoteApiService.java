package com.dmytrobr.quoteservice.api;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-11T10:49:55.979-05:00")
public abstract class QuoteApiService {
      public abstract Response quoteTransaction(QuoteRequest quote,SecurityContext securityContext)
      throws NotFoundException;
}
