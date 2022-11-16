package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
/*This is a class defined for Dependency injection where these all variables are 
 * driven through out the framework wherever it is used*/
public class PicoContainerUsage {

	public WebDriver driver;
	public String homePageProductName;
	public PageObjectManager pageObjectManager;
	public BaseClass baseClass;
	public GenericUtils genericUtils;
	
	public PicoContainerUsage() throws IOException {
	
		baseClass = new BaseClass();
		pageObjectManager = new PageObjectManager(baseClass.driverManager());
	
		genericUtils = new GenericUtils(baseClass.driverManager());
	}
	
}
