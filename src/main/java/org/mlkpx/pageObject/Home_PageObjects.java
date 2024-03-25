package org.mlkpx.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import static utilities.Driver.DriverManager.getDriver;

import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import utilities.ReusableComponents.GeneralMethod;

public class Home_PageObjects extends GeneralMethod {
    public WebElement searchField (){
        return getDriver().findElement(By.cssSelector("[placeholder=\"Search MLKP\"]"));
    }


    public void isInHomepage() {
        if (isVisible(searchField(), getText(searchField()))) {
            LoggingUtils.info("Successfully directed to the Homepage");
            ExtentReporter.logPass("Successfully directed to the Homepage");
        } else {
            LoggingUtils.info("Failed directed to the Homepage");
            ExtentReporter.logFail("Failed");
        }


    }

}
