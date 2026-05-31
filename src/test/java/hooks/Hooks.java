package hooks;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import base.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
//import utilities.ExcelUtils;
import utilities.ScreenshotUtils;

public class Hooks {
	// private static ExtentReports extent;
//	@BeforeAll
//    public static void beforeAll() {
//        String path = System.getProperty("user.dir") + "/src/test/resources/testdata/LoginData.xlsx";
//        ExcelUtils.loadLoginData(path);
//    }
	@Before
	public void startBrowser() {
		ConfigReader.initProperties();
		String browser = ConfigReader.getProperty("browser");
		boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
		DriverFactory.initDriver(browser, headless);
		// DriverFactory.getDriver().get(ConfigReader.getproperty("url"));
		// ExtentTest test = extent.createTest(scenario.getName());
		// ExtentTestManager.setTest(test);
	}

	@After
	public void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			System.out.println("senario failed-> Taking Screenshoot");
			ScreenshotUtils.takeScreenshot(DriverFactory.getDriver(), scenario.getName());
		}
		DriverFactory.quitDriver();
	}

}
