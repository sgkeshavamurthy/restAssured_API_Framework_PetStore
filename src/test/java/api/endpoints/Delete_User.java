package api.endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Delete_User {
	
	public Response DeleteUser(String username)
	{
		Response response =
			RestAssured
				.given()
					.contentType(ContentType.JSON)
					.pathParam("username", username)
				.when()
					.delete(Routes.delete_url);
			return response;
				
	}

}
