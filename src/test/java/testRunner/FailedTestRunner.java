package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

/*In order to run our tests parallel in cucumber using testng we need to override scenarios method
 * which is available in AbstractTestnglistener abstract class
 * */
@CucumberOptions(
		
		features = "@target/failed_scenarios.txt",
		glue = "stepDefination",
		monochrome = true,
		plugin = {"html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
public class FailedTestRunner extends AbstractTestNGCucumberTests{

	
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios(){
	 * 
	 * return super.scenarios(); }
	 */
}
