package api_testing;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class Requestspecific {
	RequestSpecification Rs;
	
	@BeforeClass
	public void BeforeClass() {		
		Rs=with().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2");						
	}
	
	@Test
    public void validate_response_code() {    	
   	
		given().spec(Rs).    //		given(Rs). 
    	when().
    			get("/workspaces").    	
    	then().
    			log().all().
    			assertThat().
    			statusCode(200); 
    	}
	@Test
	public void validate_response_body() {    	
       	
		given().spec(Rs).    //		given(Rs). 
    	when().
    			get("/workspaces").    	
    	then().
    			log().all().
    			assertThat().
    			statusCode(200); 
    	}

	
}
