package localAPItest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestOnLocalAPI {

	//@Test
	public void test_GET() {
		baseURI = "http://localhost:3000";
		given().get("/data").then().statusCode(200).log().all();

	}

//	@Test
	public void test_POST() {

		JSONObject request = new JSONObject();
		request.put("first_name", "Joseph");
		request.put("last_name", "Edison");
		request.put("email", "joseph@reqres.in");
		System.out.println(request.toJSONString());

		baseURI = "http://localhost:3000";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).body(request.toJSONString())
				.when().post("/data").then().statusCode(201).log().all();

	}

//	@Test
	public void test_PUT() {

		JSONObject request = new JSONObject();
		request.put("id", 13);
		request.put("email", "dan@reqres.in");
		request.put("first_name", "Dan");
		request.put("last_name", "Einstein");
		System.out.println(request.toJSONString());

		baseURI = "http://localhost:3000";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).body(request.toJSONString())
				.when().put("/data/13").then().statusCode(200).log().all();

	}

//	@Test
	public void test_PATCH() {

		JSONObject request = new JSONObject();

		request.put("last_name", "Edison");
		request.put("id", 13);

		System.out.println(request.toJSONString());

		baseURI = "http://localhost:3000";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("/data/13").then().statusCode(200).log().all();

	}

	@Test
	public void test_delete() {
		baseURI = "http://localhost:3000";
		when().delete("/data/13").then().statusCode(200).log().all();

	}
}
