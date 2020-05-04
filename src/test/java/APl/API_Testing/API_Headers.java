package APl.API_Testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Headers {
	 

	@Test
	public void headers() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET,"/Chennai");
		 Headers allheaters =response.headers();
		for(Header heaters:allheaters) {
			
			System.out.println(heaters.getName()+"   "+ heaters.getValue());
		}
		
	}
}
