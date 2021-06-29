import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OauthDemo {
	
	@Test
     public void GetAccessToken() {
		   
		
///*		
		      Response resp = RestAssured.
			  given()
			  .formParam("client_id", "f855c30da86c6f69589d")
			  .get("https://github.com/login/oauth/authorize");
				
			   //System.out.println("Response Body of GET is : " + resp.asString());
			   
			   
			   Response resp1 = RestAssured.
				given()
				.formParam("client_id", "f855c30da86c6f69589d")
				.accept("application/json")
			    .post("https://github.com/login/device/code");
							
				System.out.println("Response Body of POST is : " + resp1.jsonPath().prettify());
				
				System.out.println("user_code of POST Request is : " + resp1.jsonPath().get("user_code"));
				
				String user_code = resp1.jsonPath().get("user_code");
				
				System.out.println("device_code of POST Request is : " + resp1.jsonPath().get("device_code"));
				
				String device_code = resp1.jsonPath().get("device_code");
				
				
//*/			   

//*
			
		   // Get Access Code
		
		    Response resp3 = RestAssured.
		    given()
		    .formParam("client_id", "f855c30da86c6f69589d")
			.formParam("client_secret", "d8295f972eb6228b9aeee81a397ec75aedf2ef3d")
			//.formParam("grant_type", "urn:ietf:params:oauth:grant-type:device_code.")
			.formParam("device_code",device_code)
			.accept("application/json")
			.post("https://github.com/login/oauth/access_token");
			
		    System.out.println("Response Body of POST for access_token  is : " + resp3.jsonPath().prettify());
		    
			//System.out.println("Response Body is : " + resp.jsonPath().prettify());
			
			System.out.println("token is : "+ resp3.jsonPath().get("access_token"));
			
			String token = "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" ;
			
			
			
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
			
			HashMap<String, String> hm_header = new HashMap<String, String>() ;
			hm_header.put("Content-Type", "application/json");
			
			Response resp4 = RestAssured.
			given()
			.auth()
			.oauth2(token)
			.headers(hm_header)
			.body(body_text1)
			.when()
			.post("https://api.github.com/user/repos");
			
			System.out.println("StatusCode is : " + resp4.getStatusCode());
			
			System.out.println("ResponseBody of GitHub POST Request is : " + resp4.getBody().asString());
			
			 
//*/	
}

}