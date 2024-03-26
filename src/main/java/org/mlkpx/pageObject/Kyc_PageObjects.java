package org.mlkpx.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Kyc_PageObjects {
    public WebElement kyc_link(){
        return getDriver().findElement(By.cssSelector("[href='/kyc']"));
    }
    public WebElement kycPage_h2(){
        return getDriver().findElement(By.xpath("//h2"));
    }
    public WebElement lastName_field(){
        return getDriver().findElement(By.name("lastName"));
    }
    public WebElement firstName_field(){
        return getDriver().findElement(By.name("firstName"));
    }
    public WebElement middleName_field(){
        return getDriver().findElement(By.name("middleName"));
    }
    public WebElement suffix_field(){
        return getDriver().findElement(By.name("suffix"));
    }
    public WebElement searchBtn(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }

    public List<WebElement> buttonList(){
        return getDriver().findElements(By.cssSelector("[type='button']"));
    }

}
