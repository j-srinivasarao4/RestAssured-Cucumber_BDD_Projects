package StepDefsFromMockLab;

import java.util.HashMap;

import org.json.simple.JSONObject;


import static io.restassured.RestAssured.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;



public class PostRequest {
	
	RequestSpecification req_spec;
	Response response;
	ValidatableResponse valid_response;
	String gender;
	String first_name;
	String last_name;
	String salary;
	
	
	Scenario scn;
	
	@Before
	public void BeforeHook(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterHook(Scenario s) {
		//scn.write("Response : " + response.asString());
	}


	@Given("I Set POST Connector endpoint as {string}")
	public void i_Set_POST_Connector_endpoint_as(String baseuri) {
		
		req_spec = given().baseUri(baseuri);
		
		scn.write("Base Uri is : " + baseuri);
		
	}

	@When("I Send a POST HTTP request with request body & HEADER as {string} of endpoint as {string}")
	public void i_Send_a_POST_HTTP_request_with_request_body_HEADER_as_of_endpoint_as(String Header, String endpoint) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		scn.write("Header as : " + hm_header);

/*
		String body_string = "{\n" + 
				"	\"gender\":\"male\",\n" + 
				"	\"last_name\":\"Bapatla\",\n" + 
				"	\"first_name\":\"Ravindra\",\n" + 
				"	\"salary\":\"20LPA\",\n" +
				"	\"email\":\" johnravi@gmail.com\",\n" + 
				"}";
				
*/				
				
		
		JSONObject body_text = new JSONObject();
		body_text.put("gender", "male");
		body_text.put("last_name", "Bapatla");
		body_text.put("first_name", "Ravindra");
		body_text.put("salary", "20LPA");
		body_text.put("email", "johnravi@gmail.com");
		
		scn.write("Body as : " + body_text.toJSONString());
		
		req_spec.headers(hm_header).body(body_text);
		
		response = req_spec.when().post(endpoint);
		
	    
	}

	@Then("I receive valid HTTP response code {int}")
	public void i_receive_valid_HTTP_response_code(Integer int1) {
		
		response.then().statusCode(int1);
		
		scn.write("Status code : " + int1);
	   
	}

	@Then("Response BODY POST is non-empty.")
	public void response_BODY_POST_is_non_empty() {
		response.then().assertThat().body("first_name",equalTo(first_name))
		.assertThat().body("last_name", equalTo(last_name))
		.assertThat().body("gender", equalTo(gender))
		.assertThat().body("salary", equalTo(salary));
		
		scn.write(" Response body is correctly coming as request body");
	    
	}
	
	

}




