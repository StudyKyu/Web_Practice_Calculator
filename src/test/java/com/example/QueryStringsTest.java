package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class QueryStringsTest {
	
	@Test
	void createTest() {
		QueryStrings queryString = new QueryStrings("operand1=11&operator=*&operand2=55");
		
		assertThat(queryString).isNotNull();
	}
}
