package stepDefination;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.PageObjectManager;
import utilities.PicoContainerUsage;
/*Here we have used the conecpt of PageFactoryDesignPatterns
 * Where we have eliminated of creating objects in StepDefination
 * Instead we have used A separete class of PicoCOntainer which has dependency Injection
 * If we have separate stepedefination and Logic also to be separated, so for this we have
 * used DEPENDENCY INJECTION Where the variables of different stepdefinations are 
 * grouped in one class and need to create constructor of that class and use those 
 * instances in stepdefinations.*/

public class HomePageStepDefination {

	public WebDriver driver;
	public String homePageProductName;
	public PicoContainerUsage picoContainerUsage;
	public PageObjectManager pageObjectManager;

	/*We have created this Constructor as to share/get the variables from 
	 * PicoContainer class--This Constructor should have parameter as DI class name
	 * to use the values in this class.*/
	public HomePageStepDefination(PicoContainerUsage picoContainerUsage) {
		this.picoContainerUsage = picoContainerUsage;
	}

	@Given("user is on homePage")
	public void user_is_on_home_page() throws InterruptedException, IOException {
		//picoContainerUsage.baseClass.driverManager();
		Thread.sleep(2000);
	}

	@When("^user searched product with (.+) searched results should display and extract the actual name of product$")
	public void user_searched_product_with_searched_results_should_display_and_extract_the_actual_name_of_product(
			String productName) throws InterruptedException {
		/*Actually we need to create object for Homepage and call 
		 * all the pageObject method to work on it. As we implemented Factory
		 * Design pattern, using Dependency Injection we have used below line
		 * to link for HomePage page object class as we used to get all the method
		 * available in HomePage*/
		
		HomePage homePage = picoContainerUsage.pageObjectManager.getHomePage();
		homePage.searchField(productName);
		Thread.sleep(2000);
		
		picoContainerUsage.homePageProductName = homePage.getProductText();
		System.out.println("Productname in HomePage = " + picoContainerUsage.homePageProductName);
		
	}

}
