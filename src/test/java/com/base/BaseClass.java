package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public static RequestSpecification requestSpecification;

	public static void requestObject(String baseURI) {
		RestAssured.baseURI = baseURI;
		requestSpecification = RestAssured.given();
	}

	public static void addQueryParameter(String parameterName, String ParameterValue) {
		requestSpecification.queryParam(parameterName, ParameterValue);
	}

	public static void addPathParameter(String ParameterName, String ParameterValue) {
		requestSpecification.pathParam(ParameterName, ParameterValue);
	}

	public static Response createResponseObject(String requestType, String resources) {
		if (requestType.equals("GET")) {
			Response response = requestSpecification.request(Method.GET, resources);

			return response;

		} else if (requestType.equals("POST")) {
			Response response = requestSpecification.request(Method.POST, resources);

			return response;

		}

		else if (requestType.equals("put")) {
			Response response = requestSpecification.request(Method.PUT, resources);

			return response;

		} else {

			return requestSpecification.request(Method.DELETE, resources);

		}

	}

	public static int getResponseCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public static void printResponseBody(Response response) {
		String asPrettyString = response.getBody().asPrettyString();
		System.out.println(asPrettyString);

	}
	
	public static String readDataFromExcel(int rownum, int cellnum) throws IOException {
		
		Workbook w = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\keerthi\\Documents\\excel\\EcelSheet")));
		return w.getSheet("sheet1").getRow(rownum).getCell(cellnum).getStringCellValue();
	    
	
	}
	
	
	
}
