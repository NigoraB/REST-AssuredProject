package restassuredtest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_GET {
	
	@Test
	public void test_1() {
		
		given().
		header("Content_Type", "application/json").
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			body("data.first_name", hasItems("Michael", "Lindsay")).
			log().all();
		
	}
	
	
	
	
	
	
	

}
