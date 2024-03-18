//package utilities.reusableComponents;
//
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.LoadableComponent;
//import testSteps.BasePage;
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import utilities.logger.LoggingUtils;
//
//public class GeneralMethod extends BasePage{
//    private final RemoteWebDriver driver;
//    private static WebDriverWait wait;
//
//    public GeneralMethod() {
//        this.driver = BasePage.getDriver();
//        GeneralMethod.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//    }
//
//    public void click(By locator, String elementName){
//       try {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//        element.click();
//        LoggingUtils.info(">>Clicked element: " + elementName.toString());
//        } catch (Exception e) {
//        LoggingUtils.error(">>Failed to click element: "+ elementName.toString());
//        }
//    }
//
//    public void type(By locator, String elementName, String text){
//        try {
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        element.sendKeys(text);
//        LoggingUtils.info(">>Typed into field: " + elementName.toString() + "\t >>Value: "+ text);
//        } catch (Exception e) {
//        LoggingUtils.error(">>Failed to type into field: "+ elementName.toString() + "\t >>Value: "+ text);
//        }
//    }
//
//    public void typeEnter(By locator, String elementName, String text){
//        try {
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        element.sendKeys(text + Keys.ENTER);
//        LoggingUtils.info(">>Typed into field: " + elementName.toString() + "\t >>Value: "+ text);
//        } catch (Exception e) {
//        LoggingUtils.error(">>Failed to type into field: "+ elementName.toString() + "\t >>Value: "+ text);
//        }
//    }
//
//    public boolean isVisible(By locator, String elementName){
//        try{
//            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//            LoggingUtils.info(">>Element: " + elementName.toString() + "\t is visible");
//        }catch(Exception e){
//            LoggingUtils.error(">>Element: "+ elementName.toString() + "\t is not visible");
//        }
//        return true;
//    }
//
//    public String getText(By locator){
//        String val = null;
//        try{
//            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//            val = element.getText();
//        }catch(Exception e){
//            LoggingUtils.error(">>Cannot get text for element" + e.getMessage());
//        }
//       return val;
//
//    }
//
//    public boolean assertEqual(String actual, String expected){
//        try{
//            assertEqual(actual, expected);
//        }catch(Exception e){
//            LoggingUtils.error(">>Assertion error: "+ e.getMessage());
//        }
//        return true;
//    }
//
//    public void waitImplicitly(int seconds){
//        try{
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
//            LoggingUtils.info(">>Waiting implicitly for: " + seconds + " seconds");
//        }catch(Exception e){
//            LoggingUtils.error(">>waitImplicitly error: "+ e.getMessage());
//        }
//    }
//
//}
