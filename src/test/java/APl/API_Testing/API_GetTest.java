package APl.API_Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_GetTest {
     @Test
	public void gettest() {
		
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		String responsebody = response.getBody().asString();
		System.out.println("response body ; "+ responsebody );
		String ContentType = response.header("Content-Type");
		System.out.println("Content Type"+ContentType);
		Assert.assertEquals(ContentType, "application/xml; charset=UTF-8");
		String ContentEncoding = response.header("Content-Encoding");
		System.out.println("Content endcoding"+ContentEncoding);
		Assert.assertEquals(ContentEncoding, "gzip");
		String Server = response.header("Server");
		System.out.println("Server Type"+Server);
		Assert.assertEquals(Server, "scaffolding on HTTPServer2");
		
		
	}
	
	
}
