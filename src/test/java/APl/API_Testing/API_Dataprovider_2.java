package APl.API_Testing;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class API_Dataprovider_2 {
	
	@Test(dataProvider="datas")
	void post (String fname , String lname , String uname , String pwd ,String email ) {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification httprequst = RestAssured.given();
		JSONObject json= new JSONObject();
		json.put("FirstName", fname);
		json.put("LastName", lname);
		json.put("UserName", uname);
		json.put("Password", pwd);
		json.put("Email", email);
		httprequst.header("Content-Type", "application/json");
		httprequst.body(json.toJSONString());
		Response response = httprequst.request(Method.POST,"/register");
		String responsebody = response.getBody().asString();
		System.out.println("Response Body is :"+responsebody);
		/*Assert.assertEquals(responsebody.contains(fname),true);
		Assert.assertEquals(responsebody.contains(lname),true);
		Assert.assertEquals(responsebody.contains(uname),true);
		Assert.assertEquals(responsebody.contains(pwd),true);
		Assert.assertEquals(responsebody.contains(email),true);
		
		*/
		
		
		
	}
	
	@DataProvider(name="datas")
	String [][] getdata() throws IOException{
		
		String path ="./data/TC_002.xlsx";
		
		int rowcount =ExelUtills.getrowcount(path, "Sheet1");
		int cellcount = ExelUtills.getcelcount(path, "Sheet1", 1);
		String data [][] = new String [rowcount][cellcount];
		for(int i = 1 ; i<=rowcount ; i++) {
			for(int j=0; j<cellcount ; j++) {
				
				data [i-1][j] =ExelUtills.getcelldata(path, "Sheet1", i, j);
			}
		}
		
		
		
		
		//String data [][] = { {"arifnccunhs","praccsathg","prasjghj","pahsb","arcncun@gmail.com"} ,{"arvmvmunhs","praebqndsathg","pramjbevwdsathvjghj","pahvngsb","acbfqfqffnrun@gmail.com"}};
	
	return(data);
		
		
		
	}

}
