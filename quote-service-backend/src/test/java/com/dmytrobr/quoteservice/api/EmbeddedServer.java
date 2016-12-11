package com.dmytrobr.quoteservice.api;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import com.dmytrobr.quoteservice.RestApplication;

public class EmbeddedServer {
	public static void main(String[] args) {
		UndertowJaxrsServer server = new UndertowJaxrsServer().start();

		server.deploy(RestApplication.class);
	}

}
