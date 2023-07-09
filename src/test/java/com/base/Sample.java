package com.base;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Sample extends BaseClass {

	@Test
	private void tc01() {
		requestObject("https://reqres.in/");
		addQueryParameter("page", "2");
		Response response = createResponseObject("GET", "api/users");
		int responseCode = getResponseCode(response);
		Assert.assertEquals(200, responseCode);
		System.out.println("Response code is validated");
		printResponseBody(response);
		Object object = response.jsonPath().get("data[1].first_name");
		String first_name = (String) object;
		Assert.assertEquals(first_name, "Linsay");
		System.out.println("Response Body is Validate");

	}

	@Test
	private void tc02() {
        requestObject("https://reqres.in/");
        JSONObject JsonObject = new JSONObject();
        JsonObject.put("name", "keerthi");
        JsonObject.put("job", "Tester");
        requestSpecification.body(JsonObject.toJSONString());
        addPathParameter("id","7");
        Response response = createResponseObject("PUT", "api/users/2");
        Assert.assertEquals(getResponseCode(response), 200);
        System.out.println("PUT is validated");
        
	}
	@Test
	private void tc03() {
         requestObject("https://reqres.in/");
         addPathParameter("id", "2");
         Response response = createResponseObject("DELETE", "api/users/{id}");
         Assert.assertEquals(response, 204);
         System.out.println("DELETE is validated");
	}

}
