package api_testing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Collections;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Disabled;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;
import io.restassured.RestAssured;
public class Api_Log_Headers {

	// validate_resposne_body
	@Test
	public void request_response_logging() {
    	given().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2"). 
    	log().all().
    	when().
    			get("/workspaces").    	
    	then().
    			log().cookies().
    			log().body().    			
    			assertThat().
    			statusCode(200);        
    }

	
	//@Disabled
    @Test
    public void log_only_validatoin_fails() {
    	given().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2"). 
    	log().headers().
    	when().
    			get("/workspaces").    	
    	then().
    			log().body().
    			assertThat().
    			statusCode(200);        
    }

}
