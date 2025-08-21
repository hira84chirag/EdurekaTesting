package api_testing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.core.IsEqual;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
public class Api_Log_Error {

		@Test
	  public void Blacklist_Headers() {
			Set<String> headers=new HashSet<String>();
			headers.add("X-API-Key");
			headers.add("Accept");
			
	     	given().
	    	baseUri("https://api.postman.com").
	    	header("X-API-Key","1PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2"). 
	    	config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers))).
	    	log().all().
	    	
	    	get("/workspaces").    	
	    	
	    	then().
	   // 			log().ifValidationFails().
	    			assertThat().
	    			statusCode(201);        
	    
	    }

	
	@Test(enabled = false)
    public void Blacklist_Header() {
     	given().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","1PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2"). 
    	config(config.logConfig(LogConfig.logConfig().blacklistHeader("X-API-Key"))).
    	log().all().
    	
    	get("/workspaces").    	
    	
    	then().
   // 			log().ifValidationFails().
    			assertThat().
    			statusCode(201);        
    
    }

	
	@Test(enabled = false)
    public void log_only_validatoin_fail() {
     	given().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","1PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2"). 
    	config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
   // 	log().ifValidationFails().
    	when().
    			get("/workspaces").    	
    	then().
   // 			log().ifValidationFails().
    			assertThat().
    			statusCode(201);        
    
    }

    @Test(enabled = false)
    public void log_validatoin_fails() {
     	given().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","1PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2"). 
    	log().all().
    	when().
    			get("/workspaces").    	
    	then().
    			log().ifError().
    			assertThat().
    			statusCode(200);        
    
    }

}
