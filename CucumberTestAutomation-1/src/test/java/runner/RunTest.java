package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="src/test/resources/features/GETRequests.feature",
		glue="src/test/java/stepdefs/api/GetRequestStepDefs.java",
		plugin = {"pretty",
						"html:target/html/",
						"json:target/json/file.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
        strict = true,
        dryRun=false
		)
public class RunTest {

}

