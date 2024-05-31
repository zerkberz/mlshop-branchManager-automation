package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

import java.util.List;

public class Login_PageObjects {

    
    public WebElement login_Btn(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }
    public WebElement mobileNumber_field(){
        return getDriver().findElement(By.id("OTP"));
    }
    public WebElement verifyMobile_Text(){
        return getDriver().findElement(By.xpath("//h3[normalize-space()='Please verify your mobile number']"));
    }
    public WebElement mobileNumber_errorPrompt(){
        return getDriver().findElement(By.cssSelector("[class=' text-xs mt-1 text-red-500']"));
    }
    // public List <WebElement> otpField(){
    //     return getDriver().findElements(By.cssSelector("[class='false px-4 3sm:px-2 h-[4rem] w-[4rem] 2sm:h-[2rem] 2sm:w-[2rem] 3sm:w-[2rem] 3sm:h-[2rem] border-[#C09F53] border flex justify-center items-center text-[#504949]']"));
    // }
    public WebElement otpField(int index){
        return getDriver().findElement(By.xpath("(//div[@class='false px-4 3sm:px-2 h-[4rem] w-[4rem] 2sm:h-[2rem] 2sm:w-[2rem] 3sm:w-[2rem] 3sm:h-[2rem] border-[#C09F53] border flex justify-center items-center text-[#504949]'])["+index+"]"));
    }
    public WebElement otpMessage(){
        return getDriver().findElement(By.xpath("//p[normalize-space()='Please enter the One Time Pin (OTP)']"));
    }
    public WebElement sucessLogin_text(){
        return getDriver().findElement(By.xpath("//p[@class='text-center']"));
    }
    public WebElement okay_Btn(){
        return getDriver().findElement(By.xpath("//button[normalize-space()='Okay']"));
    }


}