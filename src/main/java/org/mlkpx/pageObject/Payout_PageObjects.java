package org.mlkpx.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;
public class Payout_PageObjects {
    public WebElement payout_link(){
        return getDriver().findElement(By.cssSelector("[href='/payout']"));
    }
    public WebElement payoutPage_h2(){
        return getDriver().findElement(By.xpath("//h2"));
    }
}
