package api.testcases;
import api.endpoints.*;
import api.payloads.createUser_Payload;
import api.utilities.utility_readExcel;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
public class User_Testcases {
	
	Faker user_data;
	createUser_Payload create_user;
	@BeforeClass
	public void createSyntheticData()
	{
	
		user_data = new Faker();
		create_user = new createUser_Payload();
		
		create_user.setId(user_data.idNumber().hashCode());
		create_user.setFirstName(user_data.name().firstName());
		create_user.setLastName((user_data.name().lastName()));
		create_user.setUsername(user_data.name().username());
		create_user.setPassword(user_data.internet().password());
		create_user.setEmail(user_data.internet().safeEmailAddress());
		create_user.setPhone(user_data.phoneNumber().cellPhone());
		create_user.setUserStatus(0);
		
	}
	@Test (priority = 1)
	public void test_createUser()
	{
//		System.out.println(Routes.post_url);
//		System.out.println(create_user.getEmail());
		Response response = Endpoints.create_user(create_user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	@Test (priority = 2)
	public void test_getUser()
	{
		
		Response response = get_user.get_userDetails(create_user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test (priority = 3)
	public void test_updateUser()
	{
		Response response;
		Update_User UU = new Update_User();
		create_user.setUsername(user_data.name().firstName());
		response = UU.updateUser(create_user.getFirstName(), create_user);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test (priority = 4)
	public void test_deleteUser()
	{
		Delete_User DU = new Delete_User();
		Response response = DU.DeleteUser(create_user.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test
	public void test_simpletest()
	{
		utility_readExcel RE = new utility_readExcel();
		String filename = "C:\\Users\\hp\\eclipse-workspace\\RestAssuredFramework-17Feb\\ArtifactID_RestAssuredProject\\src\\test\\java\\api\\testdata\\TestData.xlsx";
		System.out.println("No. of rows: " + RE.get_rowCount(filename, "Sheet1") +  " No of Columns: " + RE.get_columnCount(filename, "Sheet1"));
		
	}
}
