package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
//import utilities.ExcelUtils;


public class LoginSteps {

	private LoginPage loginpage;
	private HomePage homepage;
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		String actualTitle= DriverFactory.getDriver().getTitle();
		String expectedTitle= "Test Login Page for Automation Testing Practice";
		if(!actualTitle.equals(expectedTitle)) {
			System.out.println("Not on Login Page, actual title: "+ expectedTitle+" ii " + actualTitle);
		}
		loginpage = new LoginPage(DriverFactory.getDriver());
	}

	@When("user enter valid credentials user{string}")
	public void user_enter_valid_credentials_user(String user) {
		//String username = ExcelUtils.get("user");
		//loginpage = new LoginPage(DriverFactory.getDriver());
		loginpage.enteruser(user);
		logger.info("Attempting login with user: " + user);
	}

	@And("user enter valid credentials pass{string}")
	public void user_enter_valid_credentials_pass(String pwd) {
		//String password = ExcelUtils.get("user");
		loginpage.enterPass(pwd);

	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage.clicklogin();
		homepage = new HomePage(DriverFactory.getDriver());
	}

	@Then("user navigate to homepage")
	public void user_navigate_to_homepage() {
		logger.info("Validating homepage title...");
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("/secure"));
		logger.info("Homepage validation passed");
	}

	@And("user click on logout button")
	public void user_click_on_logout_button() {
		homepage.clickLogout();
	}

	@Then("user returns back")
	public void user_returns_back() {
		System.out.println("User logged out and returned to login page");
		// Thread.sleep(2000);

	}
}
