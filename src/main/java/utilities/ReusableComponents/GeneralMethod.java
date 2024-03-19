package utilities.ReusableComponents;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;
import static utilities.Driver.DriverManager.getDriver;

public class GeneralMethod{
    private final WebDriver driver = getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void click(WebElement locator, String elementName){
       try {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        LoggingUtils.info(">>Clicked on element: " + elementName);
        } catch (Exception e) {
        LoggingUtils.error(">>Failed to click element: "+ elementName + e.getMessage());
        }
    }

    public void type(WebElement locator, String elementName, String text){
        try {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        element.sendKeys(text);
        LoggingUtils.info(">>Typed into field: " + elementName + "\t >>Value: "+ text);
        } catch (Exception e) {
        LoggingUtils.error(">>Failed to type into field: "+ elementName + "\t >>Value: "+ text);
        }
    }

    public void typeEnter(WebElement locator, String elementName, String text){
        try {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        element.sendKeys(text + Keys.ENTER);
        LoggingUtils.info(">>Typed into field: " + elementName + "\t >>Value: "+ text);
        } catch (Exception e) {
        LoggingUtils.error(">>Failed to type into field: "+ elementName + "\t >>Value: "+ text);
        }
    }

    public boolean isVisible(WebElement locator, String elementName){
        try{
            wait.until(ExpectedConditions.visibilityOf(locator));
            LoggingUtils.info(">>Element: " + elementName + "\t is visible");
        }catch(Exception e){
            LoggingUtils.error(">>Element: "+ elementName + "\t is not visible");
        }
        return true;
    }

    public String getText(WebElement locator){
        String val = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            val = element.getText();
        }catch(Exception e){
            LoggingUtils.error(">>Cannot get text for element" + e.getMessage());
        }
       return val;

    }

    public boolean assertEqual(String actual, String expected){
        try{
            assertEqual(actual, expected);
            return true;
        }catch(Exception e){
            LoggingUtils.error(">>Assertion error: "+ e.getMessage());
        }
        return false;
    }

    public void waitImplicitly(int seconds){
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
            LoggingUtils.info(">>Waiting implicitly for: " + seconds + " seconds");
        }catch(Exception e){
            LoggingUtils.error(">>waitImplicitly error: "+ e.getMessage());
        }
    }

}
