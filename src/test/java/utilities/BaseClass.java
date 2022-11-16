package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public  WebDriver driver;
	public PicoContainerUsage picoContainerUsage;
	public Properties properties;

	public WebDriver driverManager() throws IOException {

		FileInputStream fileInputStream = new FileInputStream("./Configurations/data.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		String baseUrl = properties.getProperty("baseUrl");

		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(baseUrl);
			} else if (properties.getProperty("browser").equalsIgnoreCase("fireFox")) {
				// FireFox code driver
			}
		}
		
		return driver;
	}

}
