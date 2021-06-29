
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.RequestSpecification;

public class TC_Edit_Customer_004 {
	
	@Test
	public void RegistrationSuccessful() {
		
		
		//  1. Scenario: POST Sync Connector Containers -- POST Request ---------------------------------------------------
		
		// 2. Scenario: Poll And Verify Backup Completion -- POST Request -------------------------------------------------
		
		
		
		//Body text
		String body_text = "{\"name\":\"srinivas\",\"salary\":\"1234\",\"age\":\"23\",\"email\":\"johnravi@email.com\"}" ;
		
		System.out.println("Body text sent as : " + body_text);
		
		// Header Hash Map
		HashMap<String, String> hm_header = new HashMap<String, String>() ;
		hm_header.put("Content-Type", "application/json");
		
		System.out.println("Header sent as : " + hm_header.toString());	
		
		//send POST request with BaseURI, Header, Body text & getting response of POST request
		Response response = given()
		.baseUri("http://localhost:3000")
		.headers(hm_header)
		.body(body_text)
		.when()
		.post("/Users");
		int id = response.jsonPath().getInt("id");
		
		// Assertion - 1
		response.then().statusCode(201)
		.assertThat().body("name",equalTo("srinivas"))
		.assertThat().body("age",equalTo("23"))
		.assertThat().body("salary",equalTo("1234"))
		.assertThat().body("email",equalTo("johnravi@email.com"));
		
		System.out.println("Response Body after sending POST Request is : " + response.asString());

		
		
		
		// Scenario: GET  ContainersSetLastCreatedBackup --GET Request ---------------------------------------------
		
		
		
		// Assertion 2 - Get Request using the id generated in previous step
		//int id = response.jsonPath().getInt("data.id");
		//String salary = response.jsonpath().getString("data.salary);
		//Map<String, String> hm_data = response.jsonPath().getMap("data");
		response = given().baseUri("http://localhost:3000")
		.when().get("/Users/" + id);
		
		response.then().
		assertThat().statusCode(200).
		//assertThat().body("status",equalTo("success")).
		assertThat().body("id",equalTo(id)).
		assertThat().body("name",equalTo("srinivas")).
		assertThat().body("email",equalTo("johnravi@email.com")).
		assertThat().body("age",equalTo("23")).
		assertThat().body("salary",equalTo("1234"));
		
		System.out.println("Response Body after sending POST-GET Request is : " + response.asString());
		
		
		
		
		
		//    Scenario: DELETE Organization -- DELETE Request ----------------------------------------
		
		
		
		//Delete operation
		response = given().baseUri("http://localhost:3000")
				.when().delete("/Users/" + id);
		
		response.then().statusCode(200);
		//assertThat().body("status", equalTo("success")).
		//assertThat().body("data", equalTo(2)).
		//assertThat().body("message", equalTo("Successfully! Record has been deleted"));
		
		System.out.println("Selected Organization Deleted Successfully");
		
		
		
		
		// GET Request ---------------------------------------------------------------------------------
		//Assertion3
		
		response = given().baseUri("http://localhost:3000")
				.when().get("/Users/" + id);
				
				response.then().
				assertThat().statusCode(404);
				
		System.out.println("User is not found with Corresponding USERID-" + id );	
		
		
	}

	
	
}