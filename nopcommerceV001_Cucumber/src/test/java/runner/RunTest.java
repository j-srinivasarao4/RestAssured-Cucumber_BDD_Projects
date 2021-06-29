package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="classpath:Features",
		glue="StepDefs",
		plugin = {"pretty",
						"html:target/html/",
						"json:target/json/file.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags= {"@customers"},
        strict = false,
        monochrome = true,
        dryRun=true
        
		)

public class RunTest {

}



