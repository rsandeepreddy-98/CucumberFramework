package stepDefination;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.PicoContainerUsage;

public class HomePageStepDefination {

	public WebDriver driver;
	public String homePageProductName;
	public String offersPageProductName;
	PicoContainerUsage picoContainerUsage;
	
	public HomePageStepDefination(PicoContainerUsage picoContainerUsage) {
		this.picoContainerUsage = picoContainerUsage;
	}

	@Given("user is on homePage")
	public void user_is_on_home_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		picoContainerUsage.driver = new ChromeDriver();
		picoContainerUsage.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
	}

	@When("user searched product with {string} searched results should display and extract the actual name of product")
	public void user_searched_product_with_searched_results_should_display_and_extract_the_actual_name_of_product(
			String productName) throws InterruptedException {
		picoContainerUsage.driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(productName);
	Thread.sleep(2000);
	
	picoContainerUsage.homePageProductName=picoContainerUsage.driver.findElement(By.xpath("//div[@class='product-image']/following-sibling::h4")).getText().split("-")[0].trim();
	System.out.println("Productname in HomePage = "+picoContainerUsage.homePageProductName);
	Thread.sleep(3000);
	}

	
	
}
