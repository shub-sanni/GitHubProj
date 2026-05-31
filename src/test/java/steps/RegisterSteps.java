package steps;


import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;
import utilities.ConfigReader;

public class RegisterSteps {
private RegisterPage registerPage;
	@Given("user is on registration page")
	public void user_is_on_registration_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("regUrl"));
		registerPage = new RegisterPage(DriverFactory.getDriver());
	}
	@When("user enters new username {string}")
	public void user_enters_new_username(String user) {
		registerPage.enterUsername(user);
	}
	@And("user enters new password {string}")
	public void user_enters_new_password(String pass) {
		registerPage.enterPassword(pass);
	}
	@And("user confirms new password {string}")
	public void user_confirms_new_password(String pass) {
		registerPage.reenterPassword(pass);
	}
	@And("user clicks on registration button")
	public void user_clicks_on_registration_button() {
		registerPage.clickRegisterButton();
	}
	@Then("user land on login page")
	public void user_land_on_login_page() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
	}
	@And("user confirms success message {string} should be displayed")
	public void user_confirms_success_message_should_be_displayed(String expected) {
		Assert.assertEquals(expected, registerPage.verifyRegisterMsg());
	}

}
