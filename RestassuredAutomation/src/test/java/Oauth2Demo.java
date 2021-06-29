
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Oauth2Demo {
	
	@Test
    public void GetAccessToken() {
		
		
		// Get Access Code
		
		Response resp = RestAssured.
		given()
		.formParam("client_id", "SrinivasApp")
		.formParam("client_secret", "44edec390ce594294879f33d0460dbac")
		.formParam("grant_type", "client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println("Response Body is : " + resp.jsonPath().prettify());
		
		System.out.println("token is : "+ resp.jsonPath().get("access_token"));
		
		String token = resp.jsonPath().get("access_token");
		

	
		
		//Use Access Code for  POST Request by using Oauth2.0
		
		String body_text = "{\"name\":\"srinivas\",\"salary\":\"1234\",\"age\":\"23\",\"email\":\"johnravi@email.com\"}" ;
		
		HashMap<String, String> hm_header = new HashMap<String, String>() ;
		hm_header.put("Content-Type", "application/json");
		
		Response resp1 = RestAssured.
		given().baseUri("http://coop.apps.symfonycasts.com/")
		.auth()
		.oauth2(token)
		.headers(hm_header)
		.body(body_text)
		.when()
		.post("api/2019/chickens-feed/");
		
		System.out.println("StatusCode is : " + resp1.getStatusCode());
		
		System.out.println("ResponseBody of POST Request is : " + body_text);
		
		
		
	
	    
	   // POST Request to create repository in GitHub by using Oauth2.0
			
			String body_text1 = "{\r\n"
					+ "  \"name\": \"Hello-World123\",\r\n"
					+ "  \"description\": \"This your first repo!\",\r\n"
					+ "  \"homepage\": \"https://github.com\",\r\n"
					+ "  \"private\": false,\r\n"
					+ "  \"has_issues\": true,\r\n"
					+ "  \"has_projects\": true,\r\n"
					+ "  \"has_wiki\": true\r\n"
					+ "}" ;
			
			HashMap<String, String> hm_header1 = new HashMap<String, String>() ;
			hm_header.put("Content-Type", "application/json");
			
			Response resp4 = RestAssured.
			given()
			.auth()
			.oauth2("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")
			.headers(hm_header1)
			.body(body_text1)
			.when()
			.post("https://api.github.com/user/repos");
			
			System.out.println("StatusCode is : " + resp4.getStatusCode());
			
			System.out.println("ResponseBody of GitHub POST Request is : " + resp4.getBody().asString());
			
			
			
			// POST Request Oauth2.0 of different approach
			
		    Response resp3 = RestAssured.
			given()
		    .header("Authorization", "Bearer " + token)
		    .when()
		    .post("http://coop.apps.symfonycasts.com/api/2019/chickens-feed");
						
		    System.out.println("StatusCode is : " + resp3.getStatusCode());
							
		    System.out.println("ResponseBody of POST Request is : " + resp3.asString());
							
			
			
/*			
			
			// GET Request with Oauth2.0
			
			Response resp2 = RestAssured.
					given()
					.auth()
					.oauth2(token)
					.when()
					.get("http://coop.apps.symfonycasts.com/api/2019/chickens-feed");
			
	        System.out.println("StatusCode is : " + resp2.getStatusCode());
			
			System.out.println("ResponseBody of GET Request is : " + resp2.getBody().asString());
			
			
			
*/			
		
		
		
	}
	
}

