package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	@BeforeMethod
	public void setup() {
				ConfigReader.initProperties();
		String browser = ConfigReader.getProperty("browser");
		boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
		DriverFactory.initDriver(browser, headless);
		driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getProperty("url"));
	}

	@AfterMethod
	public void teardown() {
		DriverFactory.quitDriver();
	}
}
