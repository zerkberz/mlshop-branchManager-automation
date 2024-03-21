package utilities.ReusableComponents;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Logger.LoggingUtils;
import static utilities.Driver.DriverManager.getDriver;
import utilities.ExtentReport.ExtentReport;

public class GeneralMethod{
    private final WebDriver driver = getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void click(WebElement locator, String elementName){
       try {
           if(isVisible(locator, elementName)){
               WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
               element.click();
               LoggingUtils.info(">>Clicked on element: " + elementName);
               ExtentReport.logInfo(">>Clicked on element: " + elementName);
           }
        } catch (Exception e) {
           ExtentReport.logFail(">>Failed to click element: "+ elementName);
           LoggingUtils.error(">>Failed to click element: "+ elementName + e.getMessage());
        }
    }

    public void type(WebElement locator, String elementName, String text){
        try {
            if(isVisible(locator, elementName)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.sendKeys(text);
                LoggingUtils.info(">>Typed into field: " + elementName + ", Value: "+ text);
                ExtentReport.logInfo(">>Typed into field: " + elementName + ", Value: "+ text);
            }
        } catch (Exception e) {
        LoggingUtils.error(">>Failed to type into field: "+ elementName + ", Value: "+ text);
        ExtentReport.logFail(">>Failed to type into field: "+ elementName + ", Value: "+ text);
        }
    }

    public void typeEnter(WebElement locator, String elementName, String text){
        try {
            if(isVisible(locator, elementName)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.sendKeys(text + Keys.ENTER);
                LoggingUtils.info(">>Typed into field: " + elementName + ", Value: "+ text);
                ExtentReport.logInfo(">>Typed into field: " + elementName + ", Value: "+ text);
            }
        } catch (Exception e) {
            LoggingUtils.error(">>Failed to type into field: "+ elementName + ", Value: "+ text);
            ExtentReport.logFail(">>Failed to type into field: "+ elementName + ", Value: "+ text);
        }
    }

    public boolean isVisible(WebElement locator, String elementName){
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
            LoggingUtils.info(">>Element: " + elementName + ", is visible");
        } catch (NoSuchElementException e) {
            ExtentReport.logFail(">>Element: " + elementName + ", is not visible");
            LoggingUtils.error(">>Element: " + elementName + ", is not visible");
            throw new AssertionError(">>Element: " + elementName + ", is not visible", e);
        } catch (Exception ex) {
            LoggingUtils.error(">>An exception occurred while checking element visibility: " + ex.getMessage());
            throw ex;
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
    public boolean switchTab(int tab) {
        ArrayList<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        if (tab >= 0 && tab < windowHandles.size()) {
            try {
                getDriver().switchTo().window(windowHandles.get(tab));
                return true;
            } catch (NoSuchWindowException e) {
                ExtentReport.logFail("Failed to switch to tab with index: " + tab);
                LoggingUtils.error("Failed to switch to tab with index: " + tab);
            }
        }
        return false;
    }

}
