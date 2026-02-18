package api.testcases;
import api.endpoints.*;
import api.payloads.createUser_Payload;
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
	@Test
	public void test_createUser()
	{
		System.out.println(Routes.post_url);
		System.out.println(create_user.getEmail());
		Response response = Endpoints.create_user(create_user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
}
