package utilities.ReusableComponents;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import utilities.yamlReader.yamlReader;

import static utilities.Driver.DriverManager.getDriver;

public class GeneralMethod extends ExtentReporter{
    private final WebDriver driver = getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public final yamlReader reader = new yamlReader();
    public void click(WebElement locator, String elementName){
       try {
           if(isVisible(locator, elementName)){
               WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
               element.click();
               LoggingUtils.info(">>Clicked on element: " + elementName);
               ExtentReporter.logInfo(">>Clicked on element: " + elementName);
           }
        } catch (Exception e) {
           ExtentReporter.logFail(">>Failed to click element: "+ elementName);
           LoggingUtils.error(">>Failed to click element: "+ elementName + e.getMessage());
        }
    }

    public void type(WebElement locator, String elementName, String text){
        try {
            if(isVisible(locator, elementName)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.sendKeys(text);
                LoggingUtils.info(">>Typed into field: " + elementName + ", Value: "+ text);
                ExtentReporter.logInfo(">>Typed into field: " + elementName + ", Value: "+ text);
            }else{
                ExtentReporter.logFail(">>Failed to type into field: "+ elementName + ", Value: "+ text);
            }
        } catch (Exception e) {
        LoggingUtils.error(">>Failed to type into field: "+ elementName + ", Value: "+ text);
        ExtentReporter.logFail(">>Failed to type into field: "+ elementName + ", Value: "+ text);
        }
    }

    public void typeEnter(WebElement locator, String elementName, String text){
        try {
            if(isVisible(locator, elementName)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.sendKeys(text + Keys.ENTER);
                LoggingUtils.info(">>Typed into field: " + elementName + ", Value: "+ text);
                ExtentReporter.logInfo(">>Typed into field: " + elementName + ", Value: "+ text);
            }else{
                ExtentReporter.logFail(">>Failed to type into field: "+ elementName + ", Value: "+ text);
            }
        } catch (Exception e) {
            LoggingUtils.error(">>Failed to type into field: "+ elementName + ", Value: "+ text);
            ExtentReporter.logFail(">>Failed to type into field: "+ elementName + ", Value: "+ text);
        }
    }

    public boolean isVisible(WebElement locator, String elementName){
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
            LoggingUtils.info(">>Element: " + elementName + ", is visible");
        } catch (NoSuchElementException e) {
            ExtentReporter.logFail(">>Element: " + elementName + ", is not visible");
            LoggingUtils.error(">>Element: " + elementName + ", is not visible");
            throw new AssertionError(">>Element: " + elementName + ", is not visible", e);
        } catch (Exception ex) {
            ExtentReporter.logFail(">>An exception occurred while checking element visibility: " + ex.getMessage());
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
            ExtentReporter.logFail(">>Cannot get text for element" + e.getMessage());
            LoggingUtils.error(">>Cannot get text for element" + e.getMessage());
        }
       return val;

    }

//    public boolean assertEqual(String actual, String expected){
//        try{
//            assertEqual(actual, expected);
//        }catch(Exception e){
//            LoggingUtils.error(">>Assertion error: "+ e.getMessage());
//        }
//        return false;
//    }

    public void waitImplicitly(int seconds){
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
            LoggingUtils.info(">>Waiting implicitly for: " + seconds + " seconds");
        }catch(Exception e){
            LoggingUtils.error(">>waitImplicitly error: "+ e.getMessage());
        }
    }
    public void waitSleep(int seconds){
        try{
            Thread.sleep(seconds);
            LoggingUtils.info(">>Waiting for: " + seconds + " miliseconds");
        }catch(Exception e){
            LoggingUtils.error(">>wait error: "+ e.getMessage());
        }
    }

    public void switchToNextTab() {
        String currentWindowHandle = getWebDriver().getWindowHandle();
        Set<String> windowHandles = getWebDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                getWebDriver().switchTo().window(windowHandle);
                LoggingUtils.info("Switch to " + currentWindowHandle);
                ExtentReporter.logInfo("Switch to " + currentWindowHandle);
                break;
            }
        }
    }

    public void switchToPreviousTab() {
        String currentWindowHandle = getWebDriver().getWindowHandle();
        Set<String> windowHandles = getWebDriver().getWindowHandles();
        String previousWindowHandle = null;

        for (String windowHandle : windowHandles) {
            if (windowHandle.equals(currentWindowHandle)) {
                break;
            }
            previousWindowHandle = windowHandle;
        }

        if (previousWindowHandle != null) {
            getWebDriver().switchTo().window(previousWindowHandle);
            LoggingUtils.info("Switch to " + previousWindowHandle);
            ExtentReporter.logInfo("Switch to " + currentWindowHandle);
        } else {
            throw new IllegalStateException("No previous tab found");
        }
    }

}
