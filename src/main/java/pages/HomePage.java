package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriverWait wait;
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private By successMsg = By.id("flash");
	private By logoutBtn = By.linkText("Logout");

	public String getSuccessMsg() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
	}

	public void clickLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
	}

}
