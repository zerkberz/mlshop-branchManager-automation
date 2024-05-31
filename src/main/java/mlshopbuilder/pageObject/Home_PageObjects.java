package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Driver.DriverManager.getDriver;

import java.util.List;

public class Home_PageObjects {
  
    public WebElement userIcon() {
        return getDriver().findElement(By.cssSelector("[class='px-[10px] cursor-pointer 2sm:hidden 3sm:hidden relative']"));
    }
    public WebElement shoppingCartItemNumber() {
        return getDriver().findElement(By.xpath("(//a[@href='/cart'])[1]/child::p"));
    }
    public WebElement shoppingCartIcon() {
        return getDriver().findElement(By.xpath("(//a[@href='/cart'])[1]"));
    }
    public WebElement watchesTab() {
        return getDriver().findElement(By.xpath("(//p[contains(text(),'Watches')])[1]"));
    }
    public WebElement jewelryTab() {
        return getDriver().findElement(By.xpath("(//p[contains(text(),'Jewelry')])[1]"));
    }
    public WebElement amparitoCollectionsTab() {
        return getDriver().findElement(By.xpath("(//p[contains(text(),'Amparito')])[1]"));
    }

    public List<WebElement> itemNames(){
        return getDriver().findElements(By.cssSelector("[class=' text-md text-[#444444]  text-center truncate overflow-hidden font-bold 2sm:text-[12px]']"));
    }
    public List<WebElement> itemDescriptions(){
        return getDriver().findElements(By.cssSelector("[class=' text-[#444444] text-xs text-center 2sm:text-[9px] truncate overflow-hidden']"));
    }
    public List<WebElement> itemPrices(){
        return getDriver().findElements(By.cssSelector("[class=' text-[#444444] text-xs text-center 2sm:text-[9px] truncate overflow-hidden']"));
    }
   
   

}
