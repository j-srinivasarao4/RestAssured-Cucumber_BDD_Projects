package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
 
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests/End2End_Test.feature",
        glue = {"stepDefinitions"},
        //monochrome = true,
        //strict = true,
        dryRun=false
)
 
public class RunnerTest {
 
}

