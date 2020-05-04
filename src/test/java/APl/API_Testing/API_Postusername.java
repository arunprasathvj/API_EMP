package APl.API_Testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Postusername {
	@Test
	public void passuname  () {
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication=authscheme;
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET,"/");
		String responsebody=response.getBody().asString();
		System.out.println("Response Body is :"+ responsebody);
		
		
			
		
	}

}
