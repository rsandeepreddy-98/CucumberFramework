package stepDefination;


import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utilities.PicoContainerUsage;

public class OffersPageStepDefination {
	
	public String offersPageProductName;
	public PicoContainerUsage picoContainerUsage;
	public PageObjectManager pageObjectManager;


	public OffersPageStepDefination(PicoContainerUsage picoContainerUsage) {
		this.picoContainerUsage = picoContainerUsage;
	}

	@And("^user clicks on TopDeals link and search with (.+) in offerspage to check if product exists$")
	public void user_clicks_on_link_and_search_with_same_name_in_offerspage_to_check_if_product_exists(
			String productName) throws InterruptedException {
		
		OfferPage offerPage = picoContainerUsage.pageObjectManager.getOfferPage();
		offerPage.clickTopDealLink();
		
		Thread.sleep(1500);
		
		picoContainerUsage.genericUtils.switchWindows();
		offerPage.searchFieldElement(productName);
		Thread.sleep(2000);
		picoContainerUsage.offersPageProductName = offerPage.getOffersPageText();
		Thread.sleep(2000);
		System.out.println("OffersPageProductname = " + picoContainerUsage.offersPageProductName);

		//picoContainerUsage.driver.switchTo().window(parentWindow);

	}

	@Then("verify  homPageProductname and offerPageProdutname")
	public void verify_hom_page_productname_and_offer_page_produtname() {
		Assert.assertEquals(picoContainerUsage.homePageProductName, picoContainerUsage.offersPageProductName);
	}
	


}
