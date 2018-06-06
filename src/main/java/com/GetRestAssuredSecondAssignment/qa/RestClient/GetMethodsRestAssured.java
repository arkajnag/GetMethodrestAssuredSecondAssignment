package com.GetRestAssuredSecondAssignment.qa.RestClient;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMethodsRestAssured {

	public Response HttpGetMethodsRESTASSURED(String URI)
	{
		Response httpGetResponse=RestAssured.get(URI);
		System.out.println("Object API Response:"+httpGetResponse);
		return httpGetResponse;
	}
}
