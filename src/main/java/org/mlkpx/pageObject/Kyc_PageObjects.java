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
    public WebElement lastName_required(){return getDriver().findElement(By.xpath("//*[contains(text(), 'Last name is required.')]"));}
    public WebElement firstName_required(){return getDriver().findElement(By.xpath("//*[contains(text(), 'First name is required.')]"));}


    public WebElement birthDate(){
        return getDriver().findElement(By.xpath("//input[@placeholder='Birth Date']"));
    }
    public WebElement searchOtherDevice(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Search in Other Systems']"));
    }

    public WebElement lastName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[1]/div/small"));}
    public WebElement firstName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[2]/div/small"));}
    public WebElement middleName_max60(){return getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div/div[3]/div/small"));}

}
