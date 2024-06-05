package MLShop_BRANCH.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

public class LoginBranch_PageObjects {


    public WebElement EmailField_LoginPage(){return getDriver().findElement(By.xpath("//input[@id='email']"));}
    public WebElement PasswordField_LoginPage(){return getDriver().findElement(By.xpath("//input[@id='password']"));}
    public WebElement PasswordVisibility_LoginPage(){return getDriver().findElement(By.xpath("//input[@id='passVisibility']"));}
    public WebElement LoginButton_LoginPage(){return getDriver().findElement(By.xpath("//button[@id='btnLogin']"));}
    public WebElement ForgotPasswordButton_LoginPage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Forgot Password?']"));}
    public WebElement RegisterButton_LoginPage(){return getDriver().findElement(By.xpath("//span[@id='btnregister']"));}

    //User Avatar Object/s
    public WebElement UserAvatar_HomePage(){return getDriver().findElement(By.xpath("//i[@class='fa fa-user']"));}

    //Home Page Object/s
    public WebElement ReceiveItemFromMerchant_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Receive Item from Merchant']"));}
    public WebElement PickUpItemFromCargo_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Pick-up Item by Cargo']"));}
    public WebElement ReceiveItemFromCargo_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Receive Item from Cargo']"));}
    public WebElement ForCustomerPickUp_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='For Customer Pick-up']"));}
    public WebElement Reports_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Reports']"));}

}