package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

public class Merchant_Objects {

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
    public WebElement Continuebtn() { return getDriver().findElement(By.xpath("(//button[contains(text(),'Continue')])"));
    }

    public WebElement shopbuilderbutton() {
        return getDriver().findElement(By.xpath("//div[normalize-space()='Shop Builder']"));
    }

    public WebElement TotalStore() {
        return getDriver().findElement(By.xpath("//div[@class='pt-3 sm:text-[16px] md:text-[20px]']"));
    }
    public WebElement TotalNumberStore() {
        return getDriver().findElement(By.xpath("//b[normalize-space()='3']"));
    }
}
