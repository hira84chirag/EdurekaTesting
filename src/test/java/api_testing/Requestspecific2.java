package api_testing;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Requestspecific2 {
	
	RequestSpecification Rs;
	
		
	@BeforeClass
	public void BeforeClass() {		
		Rs=with().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2").					
		log().all();
	}
	
	
	@Test
    public void validate_response_code() {    			
		Response response=Rs.get("/workspaces").then().log().all().extract().response();		
		assertThat(response.statusCode(), is(equalTo(200)));		
	}
	
	@Test
	
	public void validate_response_body() {
	  
			Response response=given().spec(Rs).get("/workspaces").then().log().all().extract().response();		
			assertThat(response.statusCode(), is(equalTo(200)));		
	  
	}
	 
	
}
