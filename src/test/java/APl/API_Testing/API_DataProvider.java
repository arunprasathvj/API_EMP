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

public class API_DataProvider {
	
	@Test(dataProvider="datas")
	void post (String ename , String esalary , String eage) {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequst = RestAssured.given();
		JSONObject json= new JSONObject();
		json.put("name", ename);
		json.put("salary", esalary);
		json.put("age", eage);
		httprequst.header("Content-Type", "application/json");
		httprequst.body(json.toJSONString());
		Response response = httprequst.request(Method.POST,"/create");
		String responsebody = response.getBody().asString();
		System.out.println("Response Body is :"+responsebody);
		Assert.assertEquals(responsebody.contains(ename),true);
		Assert.assertEquals(responsebody.contains(esalary),true);
		Assert.assertEquals(responsebody.contains(eage),true);
		
		
		
		
		
	}
	
	@DataProvider(name="datas")
	String [][] getdata() throws IOException{
		String path = "./data/TC_002.xlsx";
		
		
		int rowcount =ExelUtills.getrowcount(path, "Sheet2");
		int cellcount =ExelUtills.getcelcount(path, "Sheet2", 1);
		
		String data[][] = new String [rowcount][cellcount];
		for (int i =1 ; i<= rowcount ; i++) {
			for(int j = 0 ; j <cellcount ; j++) {
				
				data [i-1][j]= ExelUtills.getcelldata(path, "Sheet2", i, j);
			}
			
		}
		
		
		
		//String data [][] = { {"arunhs","50000","26"}, {"agiyrunhs","650000","19"}, {"arkpunhs","40000","36"}};
	
	return (data);
		
		
		
	}
	
	

}
