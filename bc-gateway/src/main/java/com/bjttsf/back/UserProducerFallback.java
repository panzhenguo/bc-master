package com.bjttsf.back;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class UserProducerFallback implements ZuulFallbackProvider {

	@Override
	public ClientHttpResponse fallbackResponse() {
		  return new ClientHttpResponse() {
	            @Override
	            public HttpStatus getStatusCode() throws IOException {
	                return HttpStatus.OK;
	            }
	 
	            @Override
	            public int getRawStatusCode() throws IOException {
	                return 200;
	            }
	 
	            @Override
	            public String getStatusText() throws IOException {
	                return "OK";
	            }
	 
	            @Override
	            public void close() {
	 
	            }
	 
	            @Override
	            public InputStream getBody() throws IOException {
	                return new ByteArrayInputStream("The service is unavailable.".getBytes());
	            }
	 
	            @Override
	            public HttpHeaders getHeaders() {
	                HttpHeaders headers = new HttpHeaders();
	                headers.setContentType(MediaType.APPLICATION_JSON);
	                return headers;
	            }
	        };
	}

	@Override
	public String getRoute() {
		return "bc-provider-user";
	}

}