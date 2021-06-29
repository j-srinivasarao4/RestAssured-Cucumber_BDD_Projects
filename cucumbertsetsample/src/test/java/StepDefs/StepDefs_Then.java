package StepDefs;


import cucumber.api.Scenario;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;
//import com.aventstack.extentreports.gherkin.model.Scenario;


public class StepDefs_Then {
	
	Scenario scn;
	scnContext cntxt;
	
	public StepDefs_Then(scnContext cntxt) {
		this.cntxt = cntxt;
	}
	
	@Then("Result is {int}")
	public void result_is(Integer expected) {
		
		if (cntxt.Result==expected) {
			scn.write("Result matched with expected");
			Assert.assertTrue(true);
		}else {
			scn.write("Result did not matched with expected");
			Assert.assertTrue(false);
		}
	   
	}
    
}
