package com.page;

import org.junit.Assert;

import com.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleRestAssured  extends BaseClass{
	public static void main(String[] args) {

//		RestAssured.baseURI = "https://reqres.in/";
//		RequestSpecification requestSpecification = RestAssured.given();
//		requestSpecification.queryParam("page", "2");
//		Response response = requestSpecification.request(Method.GET, "api/users");
//		int statusCode = response.getStatusCode();
//		System.out.println(statusCode);
//		Assert.assertEquals(200, statusCode);
//		System.out.println("Response code validated");
//		String asPrettyString = response.getBody().asPrettyString();
//		System.out.println("asPrettyString");

		// Using BaseClass

		requestObject("https://reqres.in/");
		addQueryParameter("page","2");
		Response response1 =createResponseObject("GET","api/users");
		int responseCode =getResponseCode(response1);
		System.out.println(responseCode);
		printResponseBody(response1);
		

	}


}
