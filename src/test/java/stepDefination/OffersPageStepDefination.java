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

public class OffersPageStepDefination {

	PicoContainerUsage picoContainerUsage;
	public OffersPageStepDefination(PicoContainerUsage picoContainerUsage) {
		this.picoContainerUsage = picoContainerUsage;
	}
	
	@And("user clicks on {string} link and search with {string} in offerspage to check if product exists")
	public void user_clicks_on_link_and_search_with_same_name_in_offerspage_to_check_if_product_exists(String url,String productName) throws InterruptedException {
	
		picoContainerUsage.driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Thread.sleep(2000);
		Set<String> allWindows = picoContainerUsage.driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		
		picoContainerUsage.driver.switchTo().window(childWindow);
		
		picoContainerUsage.driver.findElement(By.id("search-field")).sendKeys(productName);
		picoContainerUsage.offersPageProductName =	picoContainerUsage.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println("OffersPageProductname = "+picoContainerUsage.offersPageProductName);
		
		picoContainerUsage.driver.switchTo().window(parentWindow);
		
	
	}
	
	@Then("verify  homPageProductname and offerPageProdutname")
	public void verify_hom_page_productname_and_offer_page_produtname() {
	
		Assert.assertEquals(picoContainerUsage.homePageProductName, picoContainerUsage.offersPageProductName);
	}
	
}
