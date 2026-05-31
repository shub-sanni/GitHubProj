//package utilities;
//
//import java.time.Duration;
//import java.util.NoSuchElementException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class WaitUtils {
//    private static final Logger logger = LogManager.getLogger(WaitUtils.class);
//    private final WebDriver driver;
//    private final int timeoutSeconds;
//
//    public WaitUtils(WebDriver driver, int timeoutSeconds) {
//        this.driver = driver;
//        this.timeoutSeconds = timeoutSeconds;
//    }
//
//    // ================= VISIBILITY (By) =================
//    public WebElement waitForVisibility(By locator) {
//        logger.info("Waiting for visibility of: " + locator);
//        return new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(timeoutSeconds))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(StaleElementReferenceException.class)
//                .until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    // ================= VISIBILITY (WebElement) =================
//    public WebElement waitForVisibility(WebElement element) {
//        logger.info("Waiting for visibility of WebElement: " + element);
//        return new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(timeoutSeconds))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(StaleElementReferenceException.class)
//                .until(ExpectedConditions.visibilityOf(element));
//    }
//
//    // ================= CLICKABLE (By) =================
//    public WebElement waitForClickable(By locator) {
//        logger.info("Waiting for clickability of: " + locator);
//        return new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(timeoutSeconds))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(StaleElementReferenceException.class)
//                .until(ExpectedConditions.elementToBeClickable(locator));
//    }
//
//    // ================= CLICKABLE (WebElement) =================
//    public WebElement waitForClickable(WebElement element) {
//        logger.info("Waiting for clickability of WebElement: " + element);
//        return new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(timeoutSeconds))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(StaleElementReferenceException.class)
//                .until(ExpectedConditions.elementToBeClickable(element));
//    }
//
//    // ================= URL =================
//    public boolean waitForUrlContains(String urlPart) {
//        logger.info("Waiting for URL to contain: " + urlPart);
//        return new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(timeoutSeconds))
//                .pollingEvery(Duration.ofMillis(500))
//                .until(ExpectedConditions.urlContains(urlPart));
//    }
//}
