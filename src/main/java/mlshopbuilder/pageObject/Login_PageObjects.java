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
    public WebElement Continuebtn() { return getDriver().findElement(By.xpath("(//button[contains(text(),'Continue')])"));}
    public WebElement Status() {return getDriver().findElement(By.xpath("//div[@role='status' and contains(text(), 'Invalid credentials')]"));}
    public WebElement CreateanAcct_btn() {return getDriver().findElement(By.xpath("//div[@class='text-neutral-800 cursor-pointer hover:underline']"));}
    public WebElement ExitPopup_btn() {return getDriver().findElement(By.xpath("(//*[name()='path' and contains(@d,'M405 136.7')]"));}
    public WebElement EmailError_Warning() {return getDriver().findElement(By.xpath("//span[contains(text(), 'The email address is invalid and incorrect')]"));}

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
    public WebElement MsignupPasswordtxtbox() { return getDriver().findElement(By.xpath("//input[@id='initialPassword']"));}
    public WebElement MsignupRepasstxtbox() {
        return getDriver().findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement exitbtn() {
        return getDriver().findElement(By.xpath("(//button)[1]"));
    }

    // public static By objLogin_btn=By.xpath(" //button[normalize-space()='Login']"); 
    // public static By objMobileNumber_field=By.xpath("//input[@id='OTP']"); 
    // public static By objVerify_mobile_number=By.xpath("//h3[normalize-space()='Please verify your mobile number']");
    // public static By objMobileNumber_errorPrompt=By.xpath("//p[@class=' text-xs mt-1 text-red-500']");
    // public static By objReturnOTP(int val){
    //     return By.xpath("(//div[@class=' px-4 h-[4rem] w-[4rem] 2sm:h-[2rem] 2sm:w-[2rem] 3sm:w-[1rem] 3sm:h-[2rem] border-rose-400 border flex justify-center items-center text-[#333333]'])["+val+"]");
    // }
    // public static By objOTP_PleaseEnter=By.xpath("//p[normalize-space()='Please enter the One Time Pin (OTP)']");
    // public static By objOTP_Result=By.xpath("//p[@class='text-center']");
    // public static By objConfirm_btn=By.xpath("//button[normalize-space()='Confirm']");
    // public static By objOkay_btn=By.xpath("//button[normalize-space()='Okay']");
    // public static By objCancel_btn=By.xpath("//button[normalize-space()='Cancel']");
    // public static By objProceed_btn=By.xpath("//button[normalize-space()='Proceed']");
    // public static By objAccNotFound=By.xpath("//p[contains(text(), \"Account not found\")]");
    // public static By objOTP_exit = By.xpath("//button[@class='p-1 border-0 hover:opacity-70 transition absolute left-9']");
    //[type='submit']

    public WebElement loginBtn(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }
    public WebElement mobileNumber_field(){
        return getDriver().findElement(By.id("OTP"));
    }
    public WebElement verifyMobileText(){
        return getDriver().findElement(By.xpath("//h3[normalize-space()='Please verify your mobile number']"));
    }
    public WebElement mobileNumber_errorPrompt(){
        return getDriver().findElement(By.cssSelector("[class=' text-xs mt-1 text-red-500']"));
    }


}