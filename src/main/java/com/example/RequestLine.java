package com.example;

import java.util.Objects;

public class RequestLine {
	/*
	 * GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
	 */
	
	private final String method;  // GET
	private final String urlPath; // /calculate?operand1=11&operator=*&operand2=55
	private QueryStrings queryStrings;

	public RequestLine(String requestLine) {
		String[] tokens = requestLine.split(" ");
		this.method = tokens[0];
		String[] urlPathTokens = tokens[1].split("\\?");
		this.urlPath = urlPathTokens[0];
		
		if(urlPathTokens.length == 2)
			this.queryStrings = new QueryStrings(urlPathTokens[1]);
	}
	
	public RequestLine(String method, String urlPath, String queryString) {
		this.method = method;
		this.urlPath = urlPath;
		this.queryStrings = new QueryStrings(queryString);
	}

	@Override
	public int hashCode() {
		return Objects.hash(method, queryStrings, urlPath);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestLine other = (RequestLine) obj;
		return Objects.equals(method, other.method) && Objects.equals(queryStrings, other.queryStrings)
				&& Objects.equals(urlPath, other.urlPath);
	}

	public boolean isGetRequest() {
		return "GET".equals(this.method);
	}

	public boolean isMatchPath(String requestPath) {
		return urlPath.equals(requestPath);
	}

	public QueryStrings getQueryStrings() {
		return this.queryStrings;
	}
}
