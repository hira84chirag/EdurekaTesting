package api_testing;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import javax.annotation.MatchesPattern;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AutomatePostFile {
		 
	@BeforeClass
	public void BeforeClass() 			{		
		RequestSpecBuilder rsb =new RequestSpecBuilder()
		.setBaseUri("https://reqres.in/")
		.setContentType(ContentType.JSON)
		.log(LogDetail.ALL);
		
		RestAssured.requestSpecification =rsb.build();
		
		ResponseSpecBuilder rsb1=new ResponseSpecBuilder().
				expectStatusCode(201).expectContentType(ContentType.JSON).
				log(LogDetail.ALL);
		RestAssured.responseSpecification=rsb1.build();
	}
	
	@Test
    public void validate_post_request_file() {	
		
		File file=new File("src/test/resources/workspacepayload.json");				
		given().
			body(file).
		when().
			post("api/users").
		then().
			assertThat().
			body("name", equalTo("morpheus123"));	
	
	}
	
}
