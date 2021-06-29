package StepDefsFromMockLab;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	RequestSpecification req_spec;
	Response response;
	ValidatableResponse valid_response;
	String server_name = "http://dummy.restapiexample.com/";
	
	Scenario scn;
	
	@Before
	public void BeforeHook(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterHook(Scenario s) {
		//scn.write("server_name : " + server_name);
	}
	
	
	@Given("Send GET HTTP request")
	public void send_get_http_request() {
		
		req_spec = given().baseUri(server_name);
		
		scn.write("server_name : " + server_name);
	    
	}

	@When("I hit the api with get request and end point as {string}")
	public void i_hit_the_api_with_get_request_and_end_point_as(String endpoint) {

		response = req_spec.when().get(endpoint);
		
		scn.write("Sending GET Request of endpoint as  : " + endpoint) ;
	    
	}


	@Then("I receive valid HTTP response code {int} for GET")
	public void i_receive_valid_http_response_code_for_get(Integer int1) {
		
        response.then().statusCode(int1);
        
        scn.write("StatusCode : " + int1);
        
	}
	
	
	@Then("Response BODY of GET request is non-empty")
    public void response_body_of_get_request_is_non_empty() {
		
        scn.write("Response body is : " + response.asString());
		
		response.then().
		assertThat().body("status",equalTo("success")).
		assertThat().body("message",equalTo("Successfully! All records has been fetched."));
		
		
		
	    
	}

}
