package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

public class Shipping_PageObjects {
    public WebElement mobileNumber_Field(){
        return getDriver().findElement(By.cssSelector("[name='mobileNo']"));
    }
    public WebElement province_dropDown(){
        return getDriver().findElement(By.xpath("(//select[@name='Province State'])[2]"));
    }
    public WebElement city_dropDown(){
        return getDriver().findElement(By.xpath("(//select[@name='City/State'])[2]"));
    }
    public WebElement branch_dropDown(){
        return getDriver().findElement(By.cssSelector("[name='Branch Name']"));
    }


    //payment options
    public WebElement mlwallet_radioButton(){
        return getDriver().findElement(By.cssSelector("[name='ML']"));
    }
}
