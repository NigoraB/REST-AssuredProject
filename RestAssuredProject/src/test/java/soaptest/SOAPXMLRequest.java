package soaptest;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SOAPXMLRequest {

	@Test
	public void validateSoapXML() throws IOException {
		
		File file = new File("./SOAPRequest/CountryName.xml");
		if(file.exists())
			System.out.println(">> File Exists");
		
		FileInputStream fis = new FileInputStream(file);
		String requestBody= IOUtils.toString(fis, "UTF-8");
		
		baseURI= "http://webservices.oorsprong.org";
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/websamples.countryinfo/CountryInfoService.wso").
		then().
			statusCode(200).
			log().all().and().body("//*:CountryNameResult.text()", equalTo("United States"));
	}
}
