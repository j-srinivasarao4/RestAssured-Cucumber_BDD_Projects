package StepDefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GETRequestStepDefs {
	
	RequestSpecification req_spec;
	Response response;
	ValidatableResponse valid_response;
	String server_name = "http://localhost:3000";
	
	Scenario scn;
	@Before
	public void BeforeHook(Scenario s) {
		this.scn = s;
	}
	

	@Given("Go rest API is up and running")
	public void go_rest_API_is_up_and_running() {

        req_spec = given().baseUri(server_name);
	}

	@When("I hit the api with get request and end point as {string}")
	public void i_hit_the_api_with_get_request_and_end_point_as(String endpoint) {
		response = req_spec.when().get(endpoint);
		scn.write("Response returned as : " + response.toString()) ;
	    
	}

	@Then("API should return all the users")
	public void api_should_return_all_the_users(Integer int1) {
		
        valid_response = response.then();
		
		valid_response.statusCode(int1).
		//assertThat().body("Content-Length",equalTo(576)).
		body("Users[0].id",equalTo(1)).
		body("Users[2].name",equalTo("Satish"));
	    
	}

}
