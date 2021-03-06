

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequest2StepDefs {
	
	RequestSpecification req_spec;
	Response response;
	ValidatableResponse valid_response;
	
	Scenario scn;
	
	String server = "https://gorest.co.in/";
	
	@Before
	public void BeforeMethod(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterMethod(Scenario s) {
		//scn.write(server);
	}
	
	
	@Given("I Set GET connectors service api endpoint")
	public void i_Set_GET_connectors_service_api_endpoint() {
		
        req_spec = given().baseUri(server);
		
		scn.write("server is : " + server);
	   
	}

	@When("I Set request HEADER content type as {string} to get connectors")
	public void i_Set_request_HEADER_content_type_as_to_get_connectors(String Header) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		scn.write("Header is : " + hm_header);
		
		req_spec.headers(hm_header);
	   
	}

	@When("Send a GET HTTP request to get connectors")
	public void send_a_GET_HTTP_request_to_get_connectors() {
		
        response = req_spec.when().get("public-api/posts");
		
		scn.write("Responsse is :" + response.asString());
	     
	    
	}

	@Then("I receive valid HTTP response code {int} while fetching connectors")
	public void i_receive_valid_HTTP_response_code_while_fetching_connectors(Integer int1) {
	    
        valid_response = response.then().statusCode(int1);
		
		scn.write("Response is coming correctly of statusCode is :" + int1 );
	}

}
