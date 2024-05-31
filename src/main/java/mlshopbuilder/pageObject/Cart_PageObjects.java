package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

public class Cart_PageObjects {

    //View item Objects
    public WebElement itemName_p(){
        return getDriver().findElement(By.cssSelector("[class=' text-2xl text-[#555555] uppercase font-bold']"));
    }
    public WebElement itemPrice_p(){
        return getDriver().findElement(By.cssSelector("[class=' text-[#333333] text-[24px] md:text-[24px] sm:text-[24px] 2sm:text-[24px] 3sm:text-[24px] font-bold md:flex-col sm:flex-col 2sm:flex-col 3sm:flex-col']"));
    }
    public WebElement addToCart_btn(){
        return getDriver().findElement(By.cssSelector("[class=' bg-[#845f00] px-5 py-1  flex mt-2 rounded-lg hover:bg-gray-300 text-[#FFFFFF] place-items-center justify-center font-medium lg:w-[175px] md:w-[175px] sm:w-[175px] 2sm:w-full 3sm:w-full']"));
    }
    public WebElement confirm_btn(){
        return getDriver().findElement(By.cssSelector("[class='mr-0 py-[15px] px-[30px] 2sm:px-[20px] 3sm:px-[20px] font-[900] text-[20px] 2sm:text-[16px] 3sm:text-[16px] text-white w-[150px] 2sm:w-[100px] 3sm:w-[100px]  flex justify-center rounded-md']"));
    }
    public WebElement itemAddedtoCart_msg(){
        return getDriver().findElement(By.xpath("//p[@class='text-center']"));
    }

    




    //Shopping Cart Objects

    public WebElement checkOut_btn(){
        return getDriver().findElement(By.cssSelector("[type='button']"));
    }   
}