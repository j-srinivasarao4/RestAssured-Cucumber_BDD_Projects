 package StepDefs.GET;

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

public class GetRequestOf6ScenariosStepDefs {
	
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
	
	@Given("I Set GET organization service api endpoint")
	public void i_Set_GET_organization_service_api_endpoint() {
		
        req_spec = given().baseUri(server);
		
		scn.write("ORGANIZATION server is : " + server);
	    
	}

	@When("I Set request HEADER content type as {string}")
	public void i_Set_request_HEADER_content_type_as(String Header) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		scn.write("ORGANIZATION Header is : " + hm_header);
		
		req_spec.headers(hm_header);
	   
	}

	@When("Send a GET HTTP request")
	public void send_a_GET_HTTP_request() {
		
        response = req_spec.when().get("public-api/posts");
        
        scn.write("ORGANIZATION endpoint is : " + "public-api/posts");
		
		scn.write("ORGANIZATION Responsse is :" + response.asString());
	   
	}

	@Then("I receive valid HTTP response code {int} while fetching Organizasion")
	public void i_receive_valid_HTTP_response_code_while_fetching_Organizasion(Integer int1) {
		
        valid_response = response.then();
        
        valid_response.statusCode(int1);
		
		scn.write("ORGANIZATION Response is coming correctly of statusCode is :" + int1 );
	    
	}

	@Given("I Set GET providers service api endpoint")
	public void i_Set_GET_providers_service_api_endpoint() {
		
        req_spec = given().baseUri(server);
		
		scn.write("PROVIDER server is : " + server);
	   
	}

	@When("I Set request HEADER content type as {string} to get providers")
	public void i_Set_request_HEADER_content_type_as_to_get_providers(String Header) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		scn.write("PROVIDER Header is : " + hm_header);
		
		req_spec.headers(hm_header);
	    
	}

	@When("Send a GET HTTP request to get providers")
	public void send_a_GET_HTTP_request_to_get_providers() {
		
        response = req_spec.when().get("public-api/users");
        
        scn.write("PROVIDER endpoint is : " + "public-api/users");
		
		scn.write("PROVIDER Response is :" + response.asString());
		
	}

	@Then("I receive valid HTTP response code {int} while fetching providers")
	public void i_receive_valid_HTTP_response_code_while_fetching_providers(Integer int1) {
		
		    valid_response = response.then();
		
		    valid_response.statusCode(int1);
			
			scn.write("PROVIDER Response is coming correctly of statusCode is :" + int1 );
	    
	}

	@Given("I Set GET connectors service api endpoint")
	public void i_Set_GET_connectors_service_api_endpoint() {
		
        req_spec = given().baseUri(server);
		
		scn.write("CONNECTORS server is : " + server);
	    
	}

	@When("I Set request HEADER content type as {string} to get connectors")
	public void i_Set_request_HEADER_content_type_as_to_get_connectors(String Header) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		scn.write("CONNECTORS Header is : " + hm_header);
		
		req_spec.headers(hm_header);
	    
	}

	@When("Send a GET HTTP request to get connectors")
	public void send_a_GET_HTTP_request_to_get_connectors() {
		
		    response = req_spec.when().get("public-api/comments");
		    
		    scn.write("CONNECTORS endpoint is : " + "public-api/comments");
			
			scn.write("CONNECTORS Responsse is :" + response.asString());
	   
	}

	@Then("I receive valid HTTP response code {int} while fetching connectors")
	public void i_receive_valid_HTTP_response_code_while_fetching_connectors(Integer int1) {
		
		valid_response = response.then();
		
	    valid_response.statusCode(int1);
		
		scn.write("CONNECTORS Response is coming correctly of statusCode is :" + int1 );
	    
	}

	@Given("I Set GET containers service api endpoint")
	public void i_Set_GET_containers_service_api_endpoint() {
		
		    req_spec = given().baseUri(server);
			
			scn.write("CONTAINERS server is : " + server);
	   
	}

	@When("I Set request HEADER content type as {string} to get containers")
	public void i_Set_request_HEADER_content_type_as_to_get_containers(String Header) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		scn.write("CONTAINERS Header is : " + hm_header);
		
		req_spec.headers(hm_header);
	   
	}

	@When("Send a GET HTTP request to get containers")
	public void send_a_GET_HTTP_request_to_get_containers() {
		
		    response = req_spec.when().get("public-api/todos");
		    
		    scn.write("CONTAINERS endpoint is : " + "public-api/todos");
			
			scn.write("CONTAINERS Response is :" + response.asString());
	   
	}

	@Then("I receive valid HTTP response code {int} while fetching containers")
	public void i_receive_valid_HTTP_response_code_while_fetching_containers(Integer int1) {
		
		valid_response = response.then();
		
	    valid_response.statusCode(int1);
		
		scn.write("CONTAINERS Response is coming correctly of statusCode is :" + int1 );
	    
	   
	}

	@Given("I Set GET containerItems service api endpoint")
	public void i_Set_GET_containerItems_service_api_endpoint() {
		
        req_spec = given().baseUri(server);
		
		scn.write("CONTAINERITEMS server is : " + server);
	   
	}

	@When("I Set request HEADER content type as {string} to get containerItems")
	public void i_Set_request_HEADER_content_type_as_to_get_containerItems(String Header) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		scn.write("CONTAINERITEMS Header is : " + hm_header);
		
		req_spec.headers(hm_header);
	   
	}

	@When("Send a GET HTTP request to get containerItems")
	public void send_a_GET_HTTP_request_to_get_containerItems() {
		
        response = req_spec.when().get("public-api/categories");
        
        scn.write("CONTAINERITEMS endpoint is : " + "public-api/categories");
		
		scn.write("CONTAINERITEMS Responsse is :" + response.asString());
	   
	}

	@Then("I receive valid HTTP response code {int} while fetching containerItems")
	public void i_receive_valid_HTTP_response_code_while_fetching_containerItems(Integer int1) {
		
		valid_response = response.then();
		
	    valid_response.statusCode(int1);
		
		scn.write("CONTAINERITEMS Response is coming correctly of statusCode is :" + int1 );
	    
	   
	}

	@Given("I Set GET containerItemBackups service api endpoint")
	public void i_Set_GET_containerItemBackups_service_api_endpoint() {
		
        req_spec = given().baseUri(server);
		
		scn.write("CONTAINERITEMBACKUPS server is : " + server);
	    
	}

	@When("I Set request HEADER content type as {string} to get containerItemBackups")
	public void i_Set_request_HEADER_content_type_as_to_get_containerItemBackups(String Header) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		scn.write("CONTAINERITEMBACKUPS Header is : " + hm_header);
		
		req_spec.headers(hm_header);
	   
	}

	@When("Send a GET HTTP request to get containerItemBackups")
	public void send_a_GET_HTTP_request_to_get_containerItemBackups() {
		
        response = req_spec.when().get("public-api/products");
        
        scn.write("CONTAINERITEMBACKUPS endpoint is : " + "public-api/products");
		
		scn.write("CONTAINERITEMBACKUPS Responsse is :" + response.asString());
	    
	}

	@Then("I receive valid HTTP response code {int} while fetching containerItemBackups")
	public void i_receive_valid_HTTP_response_code_while_fetching_containerItemBackups(Integer int1) {
		
		valid_response = response.then();
		
	    valid_response.statusCode(int1);
		
		scn.write("CONTAINERITEMBACKUPS Response is coming correctly of statusCode is :" + int1 );
	   
	}



}
