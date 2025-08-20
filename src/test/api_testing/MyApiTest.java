package api_testing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.hamcrest.core.IsEqual;
import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.restassured.RestAssured;
public class MyApiTest {

    @org.testng.annotations.Test
    public void testGet() {
    	given().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2").
    	
    	when().
    			get("/workspaces").    	
    	then().
    			log().all().
    			assertThat().
    			statusCode(200);
    	

    	
    
    }

}
// .body("name",is(equalTo("My Workspace")),"type",is(equalTo("personal")))

/*
 
RestAssured.baseURI = "http://myapi.com";

// Send a GET request to the API
Response response = RestAssured.get("/api/resource");

// Verify that the response has a 200 OK status code
response.then()
.assertThat()
.statusCode(200);

// Verify that the response body contains the expected data
response
.then()
.assertThat
().body("some.property",equalTo("expected value"));

*/
