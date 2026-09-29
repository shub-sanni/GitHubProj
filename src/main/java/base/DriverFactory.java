package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	// private static WebDriver driver;
	private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static void initDriver(String browser, boolean headless) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();			//sets up the ChromeDriver executable so Selenium knows what driver binary to use.
			ChromeOptions chromeOptions = new ChromeOptions();
			if (headless)
				chromeOptions.addArguments("--headless=new");
			chromeOptions.addArguments("--start-maximized");
			// driver = new ChromeDriver(chromeOptions);
			tlDriver.set(new ChromeDriver(chromeOptions));	}//create and to store new WebDriver instance in ThreadLocal for the current thread
		else if (browser.equalsIgnoreCase("brave")) {
		    WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();

		    if (headless) {
		        options.addArguments("--headless=new");
		    }

		    // *** This points Selenium to Brave ***
		    options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		    options.addArguments("--brave-default-browser-check=false");
		    options.addArguments("--disable-features=BraveNews");
		    options.addArguments("--disable-features=BraveRewards");
		    options.addArguments("--disable-ads");
		    options.addArguments("--disable-tracking");
		    options.addArguments("--start-maximized");
		    options.addArguments("--disable-notifications");
		    options.addArguments("--disable-popup-blocking");

		    tlDriver.set(new ChromeDriver(options));
		}

		 else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else {
			throw new IllegalArgumentException("browser erroR" + browser);
		}
		// driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {

		return tlDriver.get();
	}

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			tlDriver.remove();  //clears the driver reference associated with the current thread
		}
	}
	}
