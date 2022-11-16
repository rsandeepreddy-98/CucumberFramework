package pageObjects;

import org.openqa.selenium.WebDriver;
/*This class is responsible for creating objects for all PageObjects, as we 
 * have declared the pageObject class here with this class we can get rid of creating 
 * objects in stepDefinations.*/

public class PageObjectManager {

	public WebDriver driver;
	 HomePage homePage;
	 OfferPage offerPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		homePage = new HomePage(driver);
		return homePage;
	}

	public OfferPage getOfferPage() {
		offerPage = new OfferPage(driver);
		return offerPage;
	}
}
