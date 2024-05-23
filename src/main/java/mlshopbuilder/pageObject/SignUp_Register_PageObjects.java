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
    public WebElement ContactNumtxtbox(){
        return getDriver().findElement(By.xpath("//input[@id='storeNumber']"));
    }
    public WebElement InvalidContactNum(){
        return getDriver().findElement(By.xpath("//span[@class='text-rose-500 text-sm mt-[-15px]' and text()='The contact number should be 11 digits']"));
    }
    public WebElement StoreEmail(){
        return getDriver().findElement(By.xpath("//input[@id='storeEmail']"));
    }
    public WebElement InvalidStoreEmail(){
        return getDriver().findElement(By.xpath("(//span[contains(@class, 'text-rose-500') and contains(@class, 'text-sm') and contains(@class, 'mt-1') and text() = 'The email address is invalid and incorrect'])[last()]"));
    }
    public WebElement exitbtn() {
        return getDriver().findElement(By.xpath("(//button)[1]"));
    }
    public WebElement provincetxtbox(){
        return getDriver().findElement(By.xpath("(//div[@class=' css-hlgwow'])[1]"));
    }
    public WebElement ProvDropDown(){
        return getDriver().findElement(By.xpath("//input[@id='react-select-2-input']"));
    }
    public WebElement CityDropDown(){
        return getDriver().findElement(By.xpath("//input[@id='react-select-3-input']"));
    }
    public WebElement BranchDropDown(){
        return getDriver().findElement(By.xpath("//input[@id='react-select-5-input']"));
    }
    public WebElement StoreEmailError(){
        return getDriver().findElement(By.xpath("//span[contains(@class, 'text-rose-500') and contains(@class, 'text-sm') and contains(@class, 'mt-1') and contains(text(), 'The email address is invalid and incorrect')]"));
    }
    public WebElement ContactNumberError(){
        return getDriver().findElement(By.xpath("//span[@class='text-rose-500 text-sm mt-[-15px]' and contains(text(),'The contact number should be 11 digits')]"));
    }
    public WebElement BranchnameError(){
        return getDriver().findElement(By.cssSelector("[role='status']"));
    }
    public WebElement SignUpsuccessful(){
        return getDriver().findElement(By.xpath("//p[contains(text(),'Successfully registered!')]"));
    }
    public WebElement ConfirmBtn(){
        return getDriver().findElement(By.xpath("//button[contains(text(),'Confirm')]"));
    }
}

