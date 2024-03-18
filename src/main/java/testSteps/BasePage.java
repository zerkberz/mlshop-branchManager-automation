package testSteps;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.logger.LoggingUtils;

import java.time.Duration;
import testSteps.DriverBase;

public abstract class BasePage <T extends BasePage<T>> extends LoadableComponent<T> {
    RemoteWebDriver driver;
    static WebDriverWait wait;

    public BasePage() {
        try {
            driver = DriverBase.getDriver();
            if (driver == null) {
                // Handle the case when the driver is null
                LoggingUtils.error("Driver is null. Cannot initialize BasePage.");
                // You can throw an exception or take other appropriate action here
            } else {
                BasePage.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            }
        } catch (Exception ignored) {
            // Ignore error if it cannot connect
        }
    }

    public static void click(By locator, String elementName){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            LoggingUtils.info(">>Clicked element: " + elementName.toString());
        } catch (Exception e) {
            LoggingUtils.error(">>Failed to click element: "+ e);
        }
    }
    public static void type(By locator, String elementName, String text){
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(text);
            LoggingUtils.info(">>Typed into field: " + elementName.toString() + "\t >>Value: "+ text);
        } catch (Exception e) {
            LoggingUtils.error(">>Failed to type into field: "+ elementName.toString() + "\t >>Value: "+ text);
        }
    }
        public boolean isVisible(By locator, String elementName){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            LoggingUtils.info(">>Element: " + elementName.toString() + "\t is visible");
            return true;
        }catch(Exception e){
            LoggingUtils.error(">>Element: "+ elementName.toString() + "\t is not visible");
        }
        return false;
    }
        public void waitImplicitly(int seconds){
        try{
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
            LoggingUtils.info(">>Waiting implicitly for: " + seconds + " seconds");
        }catch(Exception e){
            LoggingUtils.error(">>waitImplicitly error: "+ e.getMessage());
        }
    }
}