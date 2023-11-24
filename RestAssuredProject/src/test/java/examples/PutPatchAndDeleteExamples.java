package examples;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class PutPatchAndDeleteExamples {

//	@Test
	public void putTest() {

		baseURI = "https://reqres.in";

		JSONObject request = new JSONObject();
		request.put("name", "Seva");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("/api/users/2").then().statusCode(200).log().all();

	}

//	@Test
	public void patchTest() {

		baseURI = "https://reqres.in";

		JSONObject request = new JSONObject();
		request.put("name", "Eva");
		request.put("job", "Manager");
		System.out.println(request.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("/api/users/2").then().statusCode(200).log().all();

	}

	@Test
	public void deleteTest() {
		baseURI = "https://reqres.in";
		when().delete("/api/users/2").then().statusCode(204).log().all();
	}
}
