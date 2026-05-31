package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage  {
	private WebDriver driver;
	private WebDriverWait wait;
	private By Username= By.id("username");
	private By Password=By.id("password");
	private By ConfirmPasswrod= By.id("confirmPassword");
	private By RegisterButton= By.xpath("//button[@type='submit']");
	private By Registermsg= By.id("flash");
public RegisterPage(WebDriver driver) {
	this.driver=driver;
	wait= new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
	}
	public void enterUsername(String user) {
		WebElement userField= wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
		userField.clear();
		userField.sendKeys(user);
		}
	public void enterPassword(String pass) {
		WebElement passField= wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		passField.clear();
		passField.sendKeys(pass);
		}
	public void reenterPassword(String pass) {
		WebElement repassField= wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPasswrod));
		repassField.clear();
		repassField.sendKeys(pass);
		}
	public void clickRegisterButton() {
		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterButton));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		wait.until(ExpectedConditions.elementToBeClickable(RegisterButton));
		element.click();
	}
	public String verifyRegisterMsg() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Registermsg)).getText().trim();
	}
}
