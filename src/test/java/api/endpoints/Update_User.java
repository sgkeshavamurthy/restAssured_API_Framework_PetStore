package api.endpoints;
import api.payloads.createUser_Payload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Update_User {
	
	public Response updateUser(String username, createUser_Payload payload)
	{
		Response response =
			RestAssured
				.given()
					.contentType(ContentType.JSON)
					.pathParam("username", username)
					.body(payload)
				.put(Routes.put_url);
		return response;
	}
}
