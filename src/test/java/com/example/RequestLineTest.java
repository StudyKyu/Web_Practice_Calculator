package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.RequestLine;

public class RequestLineTest {
	@Test
	void create() {
		RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1");
		
		assertThat(requestLine).isNotNull();
		assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "operand1=11&operator=*&operand2=55"));
	}
	
}



/*

HttpRequest
	- RequestLine (GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1")
		- HttpMethod
		- path
		- queryString
	- Header
	- Body

*/