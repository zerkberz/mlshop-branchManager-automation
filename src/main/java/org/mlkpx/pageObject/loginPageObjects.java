package org.mlkpx.pageObject;

import org.openqa.selenium.By;


public class loginPageObjects {
    public static By login_btn=By.cssSelector("button[type='submit']"); 
    public static By mobileNumber_field=By.id("OTP"); 
    public static By objMobileNumber_errorPrompt=By.xpath("//p[@class=' text-xs mt-1 text-red-500']");
    public static By objReturnOTP(int val){
        return By.xpath("(//div[@class=' px-4 h-[4rem] w-[4rem] 2sm:h-[2rem] 2sm:w-[2rem] 3sm:w-[1rem] 3sm:h-[2rem] border-rose-400 border flex justify-center items-center text-[#333333]'])["+val+"]");
    }
    public static By objOTP_PleaseEnter=By.xpath("//p[normalize-space()='Please enter the One Time Pin (OTP)']");
    public static By objOTP_Result=By.xpath("//p[@class='text-center']");
    public static By objConfirm_btn=By.xpath("//button[normalize-space()='Confirm']");
    public static By objOkay_btn=By.xpath("//button[normalize-space()='Okay']");
    public static By objCancel_btn=By.xpath("//button[normalize-space()='Cancel']");
    public static By objProceed_btn=By.xpath("//button[normalize-space()='Proceed']");
    public static By objAccNotFound=By.xpath("//p[contains(text(), \"Account not found\")]");
    public static By objOTP_exit = By.xpath("//button[@class='p-1 border-0 hover:opacity-70 transition absolute left-9']");
    public static By objUser_icon= By.xpath("(//*[name()='svg'][contains(@class,'w-6 h-6')])[3]/parent::div");
}
