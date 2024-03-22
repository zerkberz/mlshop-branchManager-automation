package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;
import utilities.ReusableComponents.GeneralMethod;
import utilities.ReusableComponents.TOTPGenerator;

public class Google_PageObjects extends GeneralMethod {
    public WebElement googleContainer (){
        return getDriver().findElement(By.cssSelector("[role='button']"));
    }

    public WebElement emailField(){
        return getDriver().findElement(By.cssSelector("[id='identifierId']"));
    }

    public WebElement emailNextButton(){
        return getDriver().findElement(By.cssSelector("[id='identifierNext']"));
    }

    public WebElement passwordField(){
        return getDriver().findElement(By.name("Passwd"));
    }

    public WebElement passNextButton(){
        return getDriver().findElement(By.cssSelector("[id='passwordNext']"));
    }

    public WebElement anotherWayButton(){
        return getDriver().findElement(By.cssSelector("[jsname='eBSUOb']"));
    }

    public WebElement selectGoogleAuthenticator(){
        return getDriver().findElement(By.xpath("//*[contains(text(), 'Google Authenticator')]"));
    }

    public WebElement codeField(){
        return getDriver().findElement(By.cssSelector("[type='tel']"));
    }
    public WebElement totpNextButton(){
        return getDriver().findElement(By.cssSelector("[id='totpNext']"));
    }

    public void signViaGoogle(){
        click(googleContainer(), getText(googleContainer()));
        switchToNextTab();
        typeEnter(emailField(), "Email Field", reader.getEmailByRole("admin"));
        typeEnter(passwordField(), "Password Field", reader.getPasswordByRole("admin"));
        //click(anotherWayButton(), getText(anotherWayButton()));
        click(selectGoogleAuthenticator(), getText(selectGoogleAuthenticator()));
        typeEnter(codeField(), "Auth Key Field", TOTPGenerator.getTwoFactorCode());
        switchToPreviousTab();
        waitSleep(5000);

    }
}
