package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

public class SignUp_Register_PageObjects{

    public WebElement userIcon() {

        return getDriver().findElement(By.xpath("//img[@alt='Avatar']"));
    }
    public WebElement signupbtn() {

        return getDriver().findElement(By.xpath("//div[normalize-space()='Sign up']"));
    }
    public WebElement signupEmailtxtbox() {

        return getDriver().findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement signupNametxtbox() {
        return getDriver().findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement signupPasswordtxtbox() {
        return getDriver().findElement(By.xpath("//input[@id='initialPassword']"));
    }
    public WebElement signupRepasstxtbox() {

        return getDriver().findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement TickboxMerchant() {

        return getDriver().findElement(By.xpath("//input[@type='checkbox']"));
    }
    public WebElement Continuebtn() {
        return getDriver().findElement(By.xpath("(//button[contains(text(),'Continue')])"));
    }
    public WebElement Confirmbtn(){
        return getDriver().findElement(By.xpath(" //button[normalize-space()='Confirm']"));
    }
    public WebElement ContactNum(){

        return getDriver().findElement(By.xpath("//input[@id='storeNumber']"));
    }
    public WebElement StoreEmail(){

        return getDriver().findElement(By.xpath("//input[@id='storeEmail']"));
    }
    public WebElement exitbtn() {

        return getDriver().findElement(By.xpath("(//button)[1]"));
    }
    //input[@id='storeNumber']
    //input[@id='storeEmail']

}

