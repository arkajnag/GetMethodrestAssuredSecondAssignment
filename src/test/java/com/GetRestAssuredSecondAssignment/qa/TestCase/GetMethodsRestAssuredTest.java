package com.GetRestAssuredSecondAssignment.qa.TestCase;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.GetRestAssuredSecondAssignment.qa.RestClient.GetMethodsRestAssured;
import com.GetRestAssuredSecondAssignment.qa.TestBase.TestBase;
import com.GetRestAssuredSecondAssignment.qa.TestUtil.TestUtil;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetMethodsRestAssuredTest extends TestBase{

	public GetMethodsRestAssuredTest()
	{
		super();
	}
	
	GetMethodsRestAssured httpGetMethodClass;
	String HostURL;
	String ServiceURL;
	String BaseURI;
	Response resp;
	TestUtil util;
	
	@BeforeMethod
	public void SetUp()
	{
		httpGetMethodClass=new GetMethodsRestAssured();
		HostURL=prop.getProperty("hosturl");
		ServiceURL=prop.getProperty("serviceurl");
		BaseURI=HostURL+ServiceURL;
		resp=httpGetMethodClass.HttpGetMethodsRESTASSURED(BaseURI);
	}
	
	@Test(priority=1)
	public void ValidateStatusCode()
	{
		String ResponseStatusLine=resp.getStatusLine();
		System.out.println("Response Status Line:"+ResponseStatusLine);
		int ResponseStatusCode=resp.getStatusCode();
		Assert.assertEquals(ResponseStatusCode, Response_Code_Success, "Response Code is Matching");	
	}
	@Test(priority=2)
	public void ValidateResponseBody()
	{
		util=new TestUtil();
		String ResponseStringBody=resp.asString();
		JSONObject JSONResponseBody=new JSONObject(ResponseStringBody);
		System.out.println("JSON Object Response Body:"+JSONResponseBody);
		String ActualCityResponse=util.getValueByJPath(JSONResponseBody, "/sys/country");
		System.out.println("Actual Response City Values::"+ActualCityResponse);
	}
	@Test(priority=3)
	public void ValidateHeader()
	{
		Headers ResponseHeader=resp.getHeaders();
		for(Header headerResponse:ResponseHeader)
		{
			System.out.println("Key::"+headerResponse.getName()+"\nValue::"+headerResponse.getValue());
		}
	}
}

