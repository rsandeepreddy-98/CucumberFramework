package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By searchField = By.xpath("//input[@class='search-keyword']");

	public void searchField(String name) {
		driver.findElement(searchField).sendKeys(name);
	}

	private By productText = By.xpath("//div[@class='product-image']/following-sibling::h4");

	public String getProductText() {
		return driver.findElement(productText).getText().split("-")[0].trim();
	}

}
