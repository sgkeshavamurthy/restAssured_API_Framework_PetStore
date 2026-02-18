package api.endpoints;
import org.testng.annotations.Test;

import api.payloads.createUser_Payload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Endpoints {
	
	//user actions
	public static Response create_user(createUser_Payload payload)
	{
		Response response=
		RestAssured
			.given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
			.post(Routes.post_url);
		return response;
	}

}
