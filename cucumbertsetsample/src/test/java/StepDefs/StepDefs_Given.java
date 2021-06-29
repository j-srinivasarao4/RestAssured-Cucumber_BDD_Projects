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



public class StepDefs_Given {
	
	scnContext cntxt;
	Scenario scn;
	
	public StepDefs_Given(scnContext cntxt) {
		this.cntxt = cntxt;
	}
	
	@Before
	public void BeforeHook(Scenario s) {
		this.scn = s;
	}
	
	@After
	public void AfterHook(Scenario s) {
		scn.write("scn is completed with status as: " + scn.isFailed());
		
		}

	@Given("I have to two numbers {int} and {int}")
	public void i_have_to_two_numbers_and(Integer int1, Integer int2) {
		cntxt.num1 = int1;
		cntxt.num2 = int2;
		scn.write("numbers to be added as  Num1 :" + cntxt.num1 + "2nd number: " + cntxt.num2);
		
	   
	}


    
}
