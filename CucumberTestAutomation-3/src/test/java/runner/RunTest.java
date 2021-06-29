package runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="classpath:features/GET",
		glue="StepDefs/GET",
		plugin = {"pretty",
						"html:target/html/",
						"json:target/json/file.json", 
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		//tags= {"@sree1,@sree2,@sree3,@sree4,@sree5"},
		//tags= {"@tag1,@tag2,@tag3"},
		//tags= {"@get1,@get2,@get3,@get4,@get5,@get6"},
		tags= {"@Get-6S"},
        strict = false,
        monochrome = true,
        dryRun=false
        
		)
public class RunTest {

}
