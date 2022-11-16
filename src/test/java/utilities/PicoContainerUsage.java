package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class PicoContainerUsage {

	public WebDriver driver;
	public String homePageProductName;
	public String offersPageProductName;
	public PageObjectManager pageObjectManager;
	public BaseClass baseClass;
	public GenericUtils genericUtils;
	
	public PicoContainerUsage() throws IOException {
	
		baseClass = new BaseClass();
		pageObjectManager = new PageObjectManager(baseClass.driverManager());
	
		genericUtils = new GenericUtils(baseClass.driverManager());
	}
	
}
