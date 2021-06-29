package StepDefs.POST_GET;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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

public class Post_GetRequest {
	
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
		//scn.write("Response is : ");
	}
	
	
	@Given("I Set POST Connector OneDrive endpoint")
	public void i_Set_POST_Connector_OneDrive_endpoint() {
	    
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

	@When("Set Post connector request Body")
	public void set_Post_connector_request_Body() {
	    
		String body_string = "{\n" + 
				"	\"gender\":\"male\",\n" + 
				"	\"name\":\"Ravi\",\n" + 
				"	\"age\":\"25\",\n" + 
				"	\"salary\":\"11.5LPA\",\n" +
				"	\"location\":\"Banglore\",\n" + 
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
	

	@Given("I Set POST organizations endpoint")
	public void i_Set_POST_organizations_endpoint() {
	    
        req_spec = given().baseUri(server);
		
		scn.write("server is : " + server);
	    
	}

	@When("Set organization request Body")
	public void set_organization_request_Body() {
	   
		String body_string = "{\n" + 
				"	\"gender\":\"female\",\n" + 
				"	\"name\":\"Srilatha\",\n" + 
				"	\"age\":\"22\",\n" + 
				"	\"salary\":\"15LPA\",\n" +
				"	\"location\":\"Pune\",\n" + 
				"}";
		
		req_spec.basePath(body_string);
		
		scn.write("body sent as: " +  body_string);
		
	}

	@Given("I Set GET posts api endpoint ContainersSetLastCreatedBackup")
	public void i_Set_GET_posts_api_endpoint_ContainersSetLastCreatedBackup() {
	   
        req_spec = given().baseUri(server);
		
		scn.write("server is : " + server);
	}

	@When("Send GET HTTP request")
	public void send_GET_HTTP_request() {
		
        response = req_spec.when().get("public-api/posts");
		
		scn.write("Responsse is :" + response.asString());   
		
	}

	@Then("I receive valid HTTP response code {int} for GET.")
	public void i_receive_valid_HTTP_response_code_for_GET(Integer int1) {
		
        valid_response = response.then();
        
        valid_response.statusCode(int1);
		
		scn.write("Response is coming correctly of statusCode is :" + int1 );
	    
	}

	@Then("Response BODY GET is non-empty")
	public void response_BODY_GET_is_non_empty() {
		
		valid_response.
		assertThat().body("code", equalTo(200)).
		assertThat().body("meta.pagination.pages", equalTo(64)).
		assertThat().body("meta.pagination.limit", equalTo(20)).
		assertThat().body("data[19].user_id", equalTo(51)).
		assertThat().body("data[19].title", equalTo("Ait vivo curatio sumptus ultra sto summa solutio adflicto iusto."));
		
		scn.write("Response is coming correctly as excepted");
		
	}

	@Given("I Set POST Sync Containers endpoint")
	public void i_Set_POST_Sync_Containers_endpoint() {
		
		    req_spec = given().baseUri(server);
			
			scn.write("server is : " + server);
	    
	}

	@When("Set sync connector containers request Body")
	public void set_sync_connector_containers_request_Body() {
	    
		String body_string = "{\n" + 
				"	\"gender\":\"female\",\n" + 
				"	\"name\":\"Kavya\",\n" + 
				"	\"age\":\"24\",\n" + 
				"	\"salary\":\"10LPA\",\n" +
				"	\"location\":\"Hyderabad\",\n" + 
				"}";
		
		req_spec.basePath(body_string);
		
		scn.write("body sent as: " +  body_string);
	}



}
