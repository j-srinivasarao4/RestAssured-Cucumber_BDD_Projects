package StepDefs.POST;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PostRequest {
	
	RequestSpecification req_spec;
	Response response;
	ValidatableResponse valid_response;
	String server = "https://gorest.co.in";
	String name;
	String gender;
	int age;
	String salary;
	String location;
	
	Scenario scn;
	
	@Before
	public void BeforeMethod(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterMethod(Scenario s) {
		scn.write("Response is : ");
	}
	
	@Given("I Set PATCH Backup Policy endpoint")
	public void i_Set_PATCH_Backup_Policy_endpoint() {
		
		req_spec = given().baseUri(server);
		
		scn.write("server is : " + server);
	    
	}

	@When("I Set HEADER param request content type as {string}")
	public void i_Set_HEADER_param_request_content_type_as(String Header) {
		
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type", Header);
		
		req_spec.headers(hm_header);
		
		scn.write("Header is :" + hm_header.toString());
	    
	}

	
	@When("Set Patch Backup request Body")
	public void set_Patch_Backup_request_Body() {
		
		String body_string = "{\n" + 
				"	\"gender\":\"male\",\n" + 
				"	\"name\":\"karthik\",\n" + 
				"	\"age\":\"25\",\n" + 
				"	\"salary\":\"11LPA\",\n" +
				"	\"location\":\"Banglore\",\n" + 
				"}";
		
		req_spec.basePath(body_string);
		
		scn.write("body sent as: " +  body_string);
	    
	}
	

	@When("Set provider request Body")
	public void set_provider_request_Body() {
		
		String body_string = "{\n" + 
				"	\"gender\":\"female\",\n" + 
				"	\"name\":\"shivani\",\n" + 
				"	\"age\":\"24\",\n" + 
				"	\"salary\":\"12LPA\",\n" +
				"	\"location\":\"Pune\",\n" + 
				"}";
		
		req_spec.basePath(body_string);
		
		scn.write("body sent as: " +  body_string);
	    
	}
	

	@When("Set Connector request Body")
	public void set_Connector_request_Body() {
		
		String body_string = "{\n" + 
				"	\"gender\":\"female\",\n" + 
				"	\"name\":\"Ramya\",\n" + 
				"	\"age\":\"23\",\n" + 
				"	\"salary\":\"9LPA\",\n" +
				"	\"location\":\"Hyderabad\",\n" + 
				"}";
		
		req_spec.basePath(body_string);
		
		scn.write("body sent as: " +  body_string);
	   
		
	}

	@When("Send a POST HTTP request")
	public void send_a_POST_HTTP_request() {
		
		response = req_spec.when().post("/public-api/users");
		
		scn.write("Response is :" + response.asString());
	    
	}

	@Then("I receive valid HTTP response code {int}")
	public void i_receive_valid_HTTP_response_code(Integer int1) {
		
		valid_response = response.then();
		valid_response.statusCode(int1);
		
		scn.write("StatusCode is :" + int1);		
	   
	}

	@Then("Response BODY POST is non-empty.")
	public void response_BODY_POST_is_non_empty() {
		
		int id = response.jsonPath().getInt("data.id");
		
		valid_response.
		assertThat().body("data.id", equalTo(id)).
		assertThat().body("data.name", equalTo(name)).
		assertThat().body("data.age", equalTo(age)).
		assertThat().body("data.salary", equalTo(salary)).
		assertThat().body("data.gender", equalTo(gender)).
		assertThat().body("data.location", equalTo(location));
	}

	@Given("I Set POST Provider endpoint")
	public void i_Set_POST_Provider_endpoint() {
		
        req_spec = given().baseUri(server);
		
		scn.write("server is : " + server);
	    
		
	}

	@Given("I Set POST Connector endpoint")
	public void i_Set_POST_Connector_endpoint() {
		
        req_spec = given().baseUri(server);
		
		scn.write("server is : " + server);
	    
	}



}
