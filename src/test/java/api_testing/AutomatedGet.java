package api_testing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.hamcrest.core.IsEqual;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class AutomatedGet {
	
	
    public void validate_response_code() {
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
    @Test
    public void validate_response_body() {
    	given().
    	baseUri("https://api.postman.com").
    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2").
    	
    	when().
    			get("/workspaces").    	
    	then().
    			log().all().
    			assertThat().
    			statusCode(200).
    			body("workspaces.name", hasItems("My Workspace2","Api-Testing"),
    					"workspaces.type",hasItems("personal","personal"),
    					"workspaces[0].name",equalTo("My Workspace2"),
    					"workspaces[0].name",is(equalTo("My Workspace2")),
    					"workspaces.size()",equalTo(2));
    }
  
    @Test
    public void extract_response() {
    	
//    	RestAssured.baseURI = "https://api.postman.com";    	
	    	Response res=  given().
	//    	Response id = given().	
	    	baseUri("https://api.postman.com").
	    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2").    	
    	when().    	
			get("/workspaces").    	
		then(). 			
			assertThat().
			statusCode(200).
			extract().
			response();
	    
	    JsonPath jsonpath=new JsonPath(res.asString());		

	    System.out.println("My Response = "+ jsonpath.getString("workspaces[0].name"));	

// 		get name of workspace.
//	    System.out.println("My Response = "+ res.asString());		    	
//    	System.out.println("Workspace name = "+ res.path("workspaces[1].name"));		
    
    	 
    }
    @Test  
public void extractString_Single_Value_From_response() {
    	
//    	RestAssured.baseURI = "https://api.postman.com";    	
	    	String res=  given().
	//    	Response id = given().	
	    	baseUri("https://api.postman.com").
	    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2").    	
    	when().    	
			get("/workspaces").    	
		then(). 			
			assertThat().
			statusCode(200).
			extract().
			response().asString();
	    	
	    System.out.println("My Response = "+ JsonPath.from(res).get("workspaces[0].name"));	

// 		get name of workspace.	    
//	    System.out.println("My Response = "+ res.asString());		    	
//    	System.out.println("Workspace name = "+ res.path("workspaces[1].name"));		
    
    	 
    }
    
   @Test
    public void extractSingle_Value_From_response() {
        	
//        	RestAssured.baseURI = "https://api.postman.com";    	
    	    	String name=  given().
    	//    	Response id = given().	
    	    	baseUri("https://api.postman.com").
    	    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2").    	
        	when().    	
    			get("/workspaces").    	
    		then(). 			
    			assertThat().
    			statusCode(200).
    			extract().
    			response().path("workspaces[1].name");    	    	
    	    System.out.println("My Response-2 = "+ name);	        
        }

    @Test
    public void hemcrest_assert_on_response() {
        	
//        	RestAssured.baseURI = "https://api.postman.com";    	
    	    	String name=  given().
    	//    	Response id = given().	
    	    	baseUri("https://api.postman.com").
    	    	header("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2").    	
        	when().    	
    			get("/workspaces").    	
    		then(). 			
    			assertThat().
    			statusCode(200).
    			extract().
    			response().path("workspaces[0].name");    	    	
    	    System.out.println("My workspace name = "+ name);	         	
    	    Assert.assertEquals(name,"My Workspace2");    
    	    
        }
}
