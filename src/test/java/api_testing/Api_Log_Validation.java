package api_testing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Collections;

import org.hamcrest.core.IsEqual;
import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
public class Api_Log_Validation {

// validate_resposne_body
	
    @org.testng.annotations.Test
    public void log_only_validatoin_fails() {
    	given().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2").
    	config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
    	//  	log().ifValidationFails().
    	when().
    			get("/workspaces").    	
    	then().
   // 			log().ifValidationFails().
    			assertThat().
    			statusCode(200);    
    
    }

}
