
package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="classpath:MockLabFeatures",
		glue="StepDefsFromMockLab",
		plugin = {"pretty",
						"html:target/html/",
						"json:target/json/file.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		//tags= {"@sree1,@sree2,@sree3"},
		tags= {"@sree3"},
        strict = false,
        monochrome = true,
        dryRun=false
		)
public class Run1Test {

}



