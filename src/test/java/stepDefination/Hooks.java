package stepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilities.PicoContainerUsage;

public class Hooks {

	PicoContainerUsage picoContainerUsage;

	public Hooks(PicoContainerUsage picoContainerUsage) {
		this.picoContainerUsage = picoContainerUsage;
	}

	@After
	public void afterScenario() throws IOException {
		picoContainerUsage.baseClass.driverManager().quit();
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) throws IOException {
		
		WebDriver driver = picoContainerUsage.baseClass.driverManager();
		if(scenario.isFailed()) {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] obj = FileUtils.readFileToByteArray(src);
			scenario.attach(obj, "image/png", "image");
			
		}
	}
}
