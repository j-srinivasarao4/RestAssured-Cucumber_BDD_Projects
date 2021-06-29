package StepDefsFromMockLab;

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

public class DeleteRequest {
	
	RequestSpecification req_spec;
	Response response;
	ValidatableResponse valid_response;
	
	String server = "http://dummy.restapiexample.com/";
	
	Scenario scn;
	
	@Before
	public void BeforeMethod(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterMethod(Scenario s) {
		scn.write("Response : " + response);
	}
	
	
	@Given("I Set DELETE posts api endpoint for DELETE Organization")
	public void i_Set_DELETE_posts_api_endpoint_for_DELETE_Organization() {
		
		req_spec = given().baseUri(server);
		
		scn.write("Server is : " + server);
	    
	}

	@When("I Send DELETE request")
	public void i_Send_DELETE_request() {
		
		response = when().delete("api/v1/delete/2");
		
		scn.write("Response Body as : "+ response.asString());
		
		
	    
	}

	@Then("I receive valid HTTP response code {int} for DELETE. to delete Organizasion")
	public void i_receive_valid_HTTP_response_code_for_DELETE_to_delete_Organizasion(Integer int1) {
		
		int id = response.jsonPath().getInt("id");
		
		response.then().statusCode(int1).
		assertThat().body("status", equalTo("success")).
		assertThat().body("data", equalTo(id)).
		assertThat().body("message", equalTo("Successfully! Record has been deleted"));
		
		scn.write("selected organization deleted successfully");
	}

}
