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


public class StepDefs_When {
	
	Scenario scn;
	scnContext cntxt;
	
	public StepDefs_When(scnContext cntxt) {
		this.cntxt = cntxt;
		
	}

	@When("I add these two numbers")
	public void i_add_these_two_numbers() {
	    cntxt.Result = cntxt.num1 + cntxt.num2;
	    scn.write("Numbers added the Result is : " + cntxt.Result);
	}

  }
    

