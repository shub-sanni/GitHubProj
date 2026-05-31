package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class ScreenshotUtils {

	public static void takeScreenshot(WebDriver driver, String name) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src,
					new File("C:\\Users\\hp\\Pictures\\selinium failed SS\\" + System.currentTimeMillis() + ".png"));
			System.out.println("Screenshot taken: " + name);
		} catch (Exception e) {
			System.out.println("Screeshot failed: " + e.getMessage());
		}
	}

}