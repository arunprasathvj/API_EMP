package APl.API_Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Get {
     @Test
	 void Gettest() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequst = RestAssured.given();
		
		Response response = httprequst.request(Method.GET,"/Chennai");
		String responsebody=response.getBody().asString();
		System.out.println("Respone is :" + responsebody);
		int statuscode = response.getStatusCode();
		System.out.println("statuscode is "+ statuscode);
		Assert.assertEquals(statuscode, 200);
		String statusline = response.getStatusLine();
		System.out.println("ststus line is :" + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
	}
	
}
