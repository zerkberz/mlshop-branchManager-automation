package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import utilities.ReusableComponents.GeneralMethod;

public class Login_PageObjects extends GeneralMethod{

    public WebElement userNameField(){
        return getDriver().findElement(By.name("username"));
    }
    public WebElement passwordField(){
        return getDriver().findElement(By.name("password"));
    }

    public WebElement invalidCredText(){
        return getDriver().findElement(By.cssSelector("[class='sc-aXZVg FiXoI']"));
    }
    public WebElement loginButton(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }
    public void loginKpx(String role){
        if(isInLoginPage()){
            type(userNameField(), "kpx username field", reader.getKpxUsername(role));
            type(passwordField(), "kpx password field", reader.getKpxPassword(role));
            click(loginButton(), "Login button");
        }
    }
    private boolean isInLoginPage(){
        if(isVisible(passwordField(), "Password Field")
                || isVisible(userNameField(),"Username Field")){
            ExtentReporter.logPass("Login page is loaded");
            LoggingUtils.info("Login page is successfully loaded");
            return true;
        }else{
            LoggingUtils.error("Failed to load login page");
            return false;
        }
    }

    public void isInvalidAccount(){
        if(isVisible(invalidCredText(), getText(invalidCredText()))){
            ExtentReporter.logPass("Successfully Validated Invalid Account");
        }else{
            ExtentReporter.logFail("Failed to Validate");
        }

    }

}
