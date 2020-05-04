package APl.API_Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Resposebody {
	 @Test
	 void GettestResponsebody() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequst = RestAssured.given();
		
		Response response = httprequst.request(Method.GET,"/Chennai");
		String responsebody=response.getBody().asString();
		System.out.println("Respone is :" + responsebody);
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WeatherDescription"));
		System.out.println(jsonpath.get("WindSpeed"));
		System.out.println(jsonpath.get("WindDirectionDegree"));
		Assert.assertEquals(jsonpath.get("City"),"Chennai" );
		Assert.assertEquals(jsonpath.get("Temperature"), "33.69 Degree celsius");
		Assert.assertEquals(jsonpath.get("Humidity"), "59 Percent");
		Assert.assertEquals(jsonpath.get("WeatherDescription"), "scattered clouds");
		Assert.assertEquals(jsonpath.get("WindSpeed"), "2.1 Km per hour");
		Assert.assertEquals(jsonpath.get("WindDirectionDegree"), "150 Degree");
		int statuscode = response.getStatusCode();
		System.out.println("statuscode is "+ statuscode);
		Assert.assertEquals(statuscode, 200);
		String statusline = response.getStatusLine();
		System.out.println("ststus line is :" + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
	}
}
