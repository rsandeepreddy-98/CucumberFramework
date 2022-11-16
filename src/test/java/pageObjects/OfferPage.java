package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferPage {

	public WebDriver driver;

	public OfferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Top Deals']")
	private WebElement topDealsLink;

	public void clickTopDealLink() {
		topDealsLink.click();
	}

	@FindBy(id = "search-field")
	private WebElement searchFieldElement;

	public void searchFieldElement(String productName) {
		searchFieldElement.sendKeys(productName);
	}

	@FindBy(css = "tr td:nth-child(1)")
	private WebElement offersPageProductText;

	public String getOffersPageText() {
		return offersPageProductText.getText();
	}
}
