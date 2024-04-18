package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

public class Login_PageObjects {

    public WebElement userIcon() {
        return getDriver().findElement(By.xpath("//img[@alt='Avatar']"));
    }
    public WebElement HeaderAcctOwnership(){
        return getDriver().findElement(By.xpath("//span[@class='font-bold']"));
    }
    public WebElement MLoginbtn() {
        return getDriver().findElement(By.xpath("//div[normalize-space()='Login']"));
    }
    public WebElement MLogoutbtn() {
        return getDriver().findElement(By.xpath("//div[normalize-space()='Logout']"));
    }
    public WebElement Email_add() {
        return getDriver().findElement(By.cssSelector("[id='email']"));
    }
    public WebElement Login_pass() {
        return getDriver().findElement(By.cssSelector("[id='password']"));
    }
    public WebElement Continuebtn() {
        return getDriver().findElement(By.xpath("(//button[contains(text(),'Continue')])"));
    }
    public WebElement Status() {
        return getDriver().findElement(By.xpath("//div[@role='status' and contains(text(), 'Invalid credentials')]"));
    }
    public WebElement CreateanAcct_btn() {
        return getDriver().findElement(By.xpath("//div[@class='text-neutral-800 cursor-pointer hover:underline']"));
    }
    public WebElement ExitPopup_btn() {
        return getDriver().findElement(By.xpath("(//*[name()='path' and contains(@d,'M405 136.7')]"));
    }
    public WebElement EmailError_Warning() {
        return getDriver().findElement(By.xpath("//span[contains(text(), 'The email address is invalid and incorrect')]"));
    }
    // sign up
    public WebElement Msignupbtn() {
        return getDriver().findElement(By.xpath("//div[normalize-space()='Sign up']"));
    }
    public WebElement MsignupEmailtxtbox() {
        return getDriver().findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement MsignupNametxtbox() {
        return getDriver().findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement MsignupPasswordtxtbox() {
        return getDriver().findElement(By.xpath("//input[@id='initialPassword']"));
    }
    public WebElement MsignupRepasstxtbox() {
        return getDriver().findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement exitbtn() {
        return getDriver().findElement(By.xpath("(//button)[1]"));
    }
}