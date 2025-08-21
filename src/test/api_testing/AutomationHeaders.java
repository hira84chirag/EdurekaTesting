package api_testing;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class AutomationHeaders {
	
	@Ignore
	public void multiple_headers_using_Headers() {
		Header header=new Header("header","value200");
		Header matchHeader= new Header("x-mock-response-code","header");
		
		Headers headers=new Headers(header,matchHeader);

		given().
    	baseUri("https://86a4c68c-bc6b-4210-8bb2-bd4dc05f62b3.mock.pstmn.io").
    	headers(headers).
   
    	when().
    			get("/workspaces").    	
    	then().
    			log().all().  			
    			assertThat().
    			statusCode(200);        

	}
	
	@Test
	public void multiple_headers_using_HashMap() {
		
	HashMap<String,String> headers=new HashMap<String,String>();
	
		headers.put("header","value200");
		headers.put("x-mock-response-code","header");
		
		given().
    	baseUri("https://86a4c68c-bc6b-4210-8bb2-bd4dc05f62b3.mock.pstmn.io").
    	headers(headers).  
    	when().
    			get("/workspaces").    	
    	then().
    			log().all().  			
    			assertThat().
    			statusCode(200);        		
	}

}
