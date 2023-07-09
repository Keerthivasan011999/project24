package com.base;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Sample1 extends BaseClass{ 
	
	@Test(dataProvider="SampleData")
	private void tc01(String key1,String Value1,String key2,String Value2) {
		requestObject("reqres.in");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key1, Value1);
		jsonObject.put(key2, Value2);
		requestSpecification.body(jsonObject.toJSONString());
		Response response = createResponseObject("POST","api/users");
		int responseCode = getResponseCode(response);
		Assert.assertEquals(responseCode, 200);
		System.out.println("New Record is created");
		

	}
	
	@DataProvider(name="SampleData")
	private Object [][] dataProviding(){
		return new Object[][] {
			{"name","keerthi","job","Tester"},	
			{"name","vasan","job","manager"}
		
		
		
	
		};
}
}
