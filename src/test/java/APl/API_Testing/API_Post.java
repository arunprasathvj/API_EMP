package APl.API_Testing;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class API_Post {

	@Test
	public void posttest() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification httprequst = RestAssured.given();
		
		JSONObject json = new JSONObject();
		json.put("FirstName", "audnnjghk");
		json.put("LastName", "Raeds bhbig");
		json.put("UserName", "raegvhjshsdsghsh");
		json.put("Password", "rajgvakdg");
		json.put("Email", "abgciihdd@ggmail.com");
		httprequst.header("Content-Type", "application/json");
		httprequst.body(json.toJSONString());
		
		Response response = httprequst.request(Method.POST,"/register");
		String responsebody=response.getBody().asString();
		System.out.println(" ResponseBody is :" + responsebody);
		JsonPath jsonpath = response.jsonPath();
		String sucess =jsonpath.get("SuccessCode");
		String msg =jsonpath.get("Message");
		Assert.assertEquals(sucess, "OPERATION_SUCCESS");
		Assert.assertEquals(msg, "Operation completed successfully");
		int statuscode = response.getStatusCode();
		System.out.println("Status code is "+ statuscode);
		Assert.assertEquals(statuscode, 201);
		
		String sucesscode = response.jsonPath().get("SuccessCode");
		System.out.println("sucesscode is :"+ sucesscode);
		Assert.assertEquals(sucesscode, "OPERATION_SUCCESS");
		
		
		
		
	}
	
	
}
