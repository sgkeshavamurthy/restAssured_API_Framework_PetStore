package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Routes;
import api.payloads.createUser_Payload;
import api.utilities.DataLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_DDTestCases {
	
	createUser_Payload CUP = new createUser_Payload();
	@Test(priority = 1, dataProvider = "dataForPOST", dataProviderClass=DataLoader.class)
	public void load_Data(String id, String username, String fname, String lname,  String email, String pwd, String phno)
	{
		
		CUP.setFirstName(fname);
		CUP.setLastName(lname);
		CUP.setUsername(username);
		CUP.setId(Integer.parseInt(id));
		CUP.setEmail(email);
		CUP.setPassword(pwd);
		CUP.setPhone(phno);
		CUP.setUserStatus(0);
		
	}
	@Test (priority = 2)
	public void POSTRequest()
	{
		Response response =
		RestAssured
			.given()
				.contentType(ContentType.JSON)
				.body(CUP)
				.accept(ContentType.JSON)
			.when()
				.post(Routes.post_url);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	
//	public void test_CreateUser()	
//	{
//		String filename = "C:\\Users\\hp\\eclipse-workspace\\RestAssuredFramework-17Feb\\ArtifactID_RestAssuredProject\\src\\test\\java\\api\\testdata\\TestData.xlsx";
//		DataLoader DM = new DataLoader();
//		
//		String returnVal[][] = DM.DataMatrix(filename, "Sheet1");
//		int rows = returnVal.length;
//		int columns = returnVal[0].length;
//		System.out.println("Rows: " + rows + "  " + "Columns: " + columns);
//		for(int i=0;i<rows-1; i++)
//		{
//			for(int j=0; j<columns; j++)
//			{
//				System.out.println(returnVal[i][j]);
//			}
//			
//		}
//	}

}
