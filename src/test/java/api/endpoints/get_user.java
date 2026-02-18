package api.endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class get_user {
	
	public static Response get_user()
	{
	Response response =
			RestAssured
				.given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
				.get(Routes.get_url);
			return response;
	}
}
