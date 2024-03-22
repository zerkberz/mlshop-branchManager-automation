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
    public WebElement loginButton(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }
    public void loginKpx(){
        if(isInLoginPage()){
            type(userNameField(), "kpx username field", reader.getKpxUsername("admin"));
            type(passwordField(), "kpx password field", reader.getKpxPassword("admin"));
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

}
