package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/UserTests.feature",
        glue = {"stepdefs/UserEndpointStepDefinitions.java"},
		//monochrome = true,
        //strict = true,
        dryRun=true
		)

public class RunnerTest {

}
