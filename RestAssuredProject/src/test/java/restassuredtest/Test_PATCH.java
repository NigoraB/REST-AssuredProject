package restassuredtest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PATCH {

	@Test
	public void test_1_put() {
//		
//		Map<String,Object> map= new HashMap<String, Object>();
//		map.put("name", "Seva");
//		map.put("job", "Teacher");
//		System.out.println(map);
//		

		JSONObject request = new JSONObject();
		request.put("name", "Seva");
		request.put("job", "Teacher");
		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
	
	}
}
