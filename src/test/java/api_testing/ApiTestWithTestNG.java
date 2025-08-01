package api_testing;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class ApiTestWithTestNG {

	@Test(invocationCount=3)
    public void validateGetRequest() {

        // Set base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // Send GET request and store the response
        Response response = given()
        						//.header("Content-Type", "application/json")
        						.when().get("/posts/1")
        					.then().statusCode(200)  // Assert status code is 200
        						.extract().response();   // Extract the response

        // Extract values using JSON path
        int userId = response.jsonPath().getInt("userId");
        String title = response.jsonPath().getString("title");

        // Assertions for validation using extracted values
        Assert.assertEquals(userId, 1, "User ID does not match the expected value");

        // Assertion to check if the title is not empty
        Assert.assertTrue(!title.isEmpty(), "Title should not be empty");

        // Print the response body at the end
        System.out.println("Response Body: " + response.getBody().asString());
    }
}