package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Endpoints;
import api.endpoints.Routes;
import api.payloads.createUser_Payload;
import api.utilities.DataLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_DDTestCases {
	
	createUser_Payload CUP = new createUser_Payload();
	@Test(priority = 1, dataProvider = "dataForPOST", dataProviderClass=DataLoader.class)
	public void test_POSTrequest(String id, String username, String fname, String lname,  String email, String pwd, String phno)
	{
		
		CUP.setFirstName(fname);
		CUP.setLastName(lname);
		CUP.setUsername(username);
		CUP.setId(Integer.parseInt(id));
		CUP.setEmail(email);
		CUP.setPassword(pwd);
		CUP.setPhone(phno);
		CUP.setUserStatus(0);
		Response response = Endpoints.create_user(CUP);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
}