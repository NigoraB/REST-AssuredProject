package restassuredtest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_POST {

	@Test
	public void test_1() {
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
			post("https://reqres.in/api/users").
		then().
			statusCode(201);

	}
	
	
}
