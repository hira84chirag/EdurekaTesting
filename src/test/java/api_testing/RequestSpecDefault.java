package api_testing;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import net.bytebuddy.implementation.Implementation.SpecialMethodInvocation;

public class RequestSpecDefault {
	
	@BeforeClass
	public void BeforeClass() {		
		RequestSpecBuilder Rsbuilder =new RequestSpecBuilder();
		Rsbuilder.setBaseUri("https://api.postman.com");
		Rsbuilder.addHeader("X-API-Key","PMAK-6766e110224b7600019821e6-7b6c6067013a23ffefd863d72ad57390b2");
		RestAssured.requestSpecification  =Rsbuilder.build();		
	}

	@Test
	 public void QueryTest() {
	
	QueryableRequestSpecification qrS=SpecificationQuerier.
			query(RestAssured.requestSpecification);
	
		System.out.println(qrS.getBaseUri());
		System.out.println(qrS.getHeaders());		
	}

		 	
	@Test
	 public void validate_status_code() {
		Response response=get("/workspaces").then().log().all().extract().response();		
		assertThat(response.statusCode(), is(equalTo(200)));			  
	  }
		
	@Test	
	  public void validate_response_body() { 
		Response response=get("/workspaces").then().log().all().extract().response(); 
		assertThat(response.statusCode(), is(equalTo(200))); 
		assertThat(response.path("workspaces[1].name").toString(),equalTo("Api-Testing"));
		
	}
	
}
