package pages;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	@FindBy(id = "username")
	private WebElement usernameInput;
	private By passwordInput = By.id("password");
	@FindBy(id = "submit-login")
	private WebElement loginButton;
	@FindBy(id = "flash")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public boolean isLoginPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
	}

	public void enteruser(String user) {
		logger.info("Typing username: " + user);
		wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
		usernameInput.clear();
		usernameInput.sendKeys(user);
	}

	public void enterPass(String pwd) {
		logger.info("Typind Passwrd : "+ pwd);
		WebElement elem= wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
		elem.clear();
		elem.sendKeys(pwd);
		
	}

	public void clicklogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

	}

	public String getErrormsg() {
		return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
	}
}
