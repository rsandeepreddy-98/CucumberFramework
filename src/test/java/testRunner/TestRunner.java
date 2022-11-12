package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "Features",
		glue = "stepDefination",
		monochrome = true,
		dryRun = false
		
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
