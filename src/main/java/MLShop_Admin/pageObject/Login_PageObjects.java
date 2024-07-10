package MLShop_Admin.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class Login_PageObjects {

    //Dashboard
    public WebElement EmailField_LoginPage(){return getDriver().findElement(By.xpath("//input[@id='email']"));}
    public WebElement PasswordField_LoginPage(){return getDriver().findElement(By.xpath("//input[@id='password']"));}
    public WebElement PasswordVisibility_LoginPage(){return getDriver().findElement(By.xpath("//input[@id='passVisibility']"));}
    public WebElement LoginButton_LoginPage(){return getDriver().findElement(By.xpath("//button[@id='btnLogin']"));}
    public WebElement ForgotPasswordButton_LoginPage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Forgot Password?']"));}
    public WebElement RegisterButton_LoginPage(){return getDriver().findElement(By.xpath("//span[@id='btnregister']"));}
    public WebElement NoInputNotification_LoginPage(){return getDriver().findElement(By.xpath("//div[@class='toast-message' and contains(text(), 'Please provide email or password!')]"));}
    public WebElement InvalidLoginNotification_LoginPage(){return getDriver().findElement(By.xpath("//div[@class='toast-message' and contains(text(), 'No data found')]"));}

    //    Header
    public WebElement UserIcon_Header(){return getDriver().findElement(By.xpath("//*[@class='nav-dropdown']"));}
    public WebElement Profile_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Profile']"));}
    public WebElement Messages_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Messages']"));}
    public WebElement Settings_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Settings']"));}
    public WebElement Logout_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Logout']"));}

    public WebElement Notification_Header(){return getDriver().findElement(By.cssSelector( "[class='notification fa fa-bell']"));}
    public WebElement MLSHOPADMIN_Header(){return getDriver().findElement(By.xpath("//span[contains(.,'ML Shop Admin')]"));}
    public WebElement MLHUILLIERSideBarLogo_Header(){return getDriver().findElement(By.xpath("//i[@class='fas fa-chevron-right sidebarLogo']"));}

    //User Avatar Object/s
    public WebElement UserAvatar_Icon_HomePage(){return getDriver().findElement(By.xpath("//i[@class='fas fa-caret-down']"));}
    public WebElement UserAvatar_LogoutButton_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Logout']"));}

    //      Overview Dashboard
    public WebElement TotalSales_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Total Sales')]"));}
    public WebElement ReturningCustomerRate_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Returning Customer Rate')]"));}
    public WebElement AverageOrderValue_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Average Order Value')]"));}
    public WebElement TotalOrders_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Total Orders')]"));}
    public WebElement TopProductsByUnitsSold_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Top Products by Units Sold')]"));}

    //Home Page Object/s
    public WebElement ReceiveItemFromMerchant_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Receive Item from Merchant']"));}
    public WebElement PickUpItemFromCargo_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Pick-up Item by Cargo']"));}
    public WebElement ReceiveItemFromCargo_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Receive Item from Cargo']"));}
    public WebElement ForCustomerPickUp_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='For Customer Pick-up']"));}
    public WebElement Reports_HomePage(){return getDriver().findElement(By.xpath("//a[normalize-space()='Reports']"));}

    //Forgot Password
    public WebElement Email_NumberTextbox_ForgetPassword(){return getDriver().findElement(By.xpath("//input[@id='phonenumberoremail']"));}
    public WebElement ContinueButton_ForgetPassword(){return getDriver().findElement(By.xpath("//span[@id='continue']"));}

    public WebElement InvalidNumberNotification_ForgetPassword(){return getDriver().findElement(By.xpath("//div[@class='toast-message' and contains(text(), 'Please provide a valid phone number to get an OTP code')]"));}
    public WebElement EnterAValidDataNotification_ForgetPassword(){return getDriver().findElement(By.xpath("//div[@class='toast-message' and contains(text(), 'Please enter a valid data')]"));}
    public WebElement PasswordNotMatchNotification_ForgetPassword(){return getDriver().findElement(By.xpath("//div[@class='toast-message' and contains(text(), 'The passwords do not match.')]"));}
    public WebElement LessThan8CharacterNotification_ForgetPassword(){return getDriver().findElement(By.xpath("//div[@class='toast-message' and contains(text(), 'The Passwords must have at least 8 characters')]"));}
    public WebElement SimilarPasswordNotification_ForgetPassword(){return getDriver().findElement(By.xpath("//div[@class='toast-message' and contains(text(), 'Your new password is too similar to your current password. Please try another password.')]"));}
    public WebElement InvalidOTPNotification_ForgetPassword(){return getDriver().findElement(By.xpath("//div[@class='toast-message' and contains(text(), 'The one-time PIN (OTP) you entered is invalid. Please try again.')]"));}
    //Reset Password
    public WebElement NewPassword_ForgetPassword(){return getDriver().findElement(By.xpath("//input[@id='newpassword']"));}
    public WebElement ConfirmPassword_ForgetPassword(){return getDriver().findElement(By.xpath("//input[@id='confirmpassword']"));}
    public WebElement BackButton_ForgetPassword(){return getDriver().findElement(By.xpath("//form[@id='resetpass']//i[@class='fa fa-arrow-circle-left']"));}
    public WebElement ResetPasswordButton_ForgetPassword(){return getDriver().findElement(By.xpath("//div[@id='resetpassbtn']//button[@type='button']"));}
    public WebElement SuccessChange_ForgetPassword(){return getDriver().findElement(By.cssSelector("[class='toast-message']"));}
    public WebElement StatusMessage_ForgetPassword(){return getDriver().findElement(By.cssSelector("[class='toast-message']"));}

    //OTP
    public WebElement VerificationCode1_OTP(){return getDriver().findElement(By.xpath("//input[@id='input1']"));}
    public WebElement VerificationCode2_OTP(){return getDriver().findElement(By.xpath("//input[@id='input2']"));}
    public WebElement VerificationCode3_OTP(){return getDriver().findElement(By.xpath("//input[@id='input3']"));}
    public WebElement VerificationCode4_OTP(){return getDriver().findElement(By.xpath("//input[@id='input4']"));}
    public WebElement VerificationCode5_OTP(){return getDriver().findElement(By.xpath("//input[@id='input5']"));}
    public WebElement VerificationCode6_OTP(){return getDriver().findElement(By.xpath("//input[@id='input6']"));}

    public WebElement VerifyButton_OTP(){return getDriver().findElement(By.xpath("//span[@id='verify']"));}


}