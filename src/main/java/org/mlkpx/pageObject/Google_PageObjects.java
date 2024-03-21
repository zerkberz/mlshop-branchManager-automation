package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;
import utilities.ReusableComponents.GeneralMethod;

public class Google_PageObjects extends GeneralMethod {
    public WebElement googleContainer (){
        return getDriver().findElement(By.id("container")) ;
    }

    public WebElement emailField(){
        return getDriver().findElement(By.id("identifierId"));
    }

    public WebElement emailNextButton(){
        return getDriver().findElement(By.id("identifierNext"));
    }

    public WebElement passwordField(){
        return getDriver().findElement(By.name("Passwd"));
    }

    public WebElement passNextButton(){
        return getDriver().findElement(By.id("passwordNext"));
    }

    public WebElement anotherWayButton(){
        return getDriver().findElement(By.cssSelector("[jsname='eBSUOb']"));
    }

    public WebElement selectGoogleAuthenticator(){
        return getDriver().findElement(By.cssSelector("[data-challengetype='6']"));
    }

    public WebElement codeField(){
        return getDriver().findElement(By.cssSelector("[type='tel']"));
    }
    public WebElement totpNextButton(){
        return getDriver().findElement(By.id("totpNext"));
    }

    // method for google login
    // click sign in google
    // switch driver window
    // input credentials
    // click for google authenticator
    // enter totp code and next
    // switch driver window back

    public void signViaGoogle(){
        click(googleContainer(), "Google Container");
        switchTab(1);
        typeEnter();

    }

}
