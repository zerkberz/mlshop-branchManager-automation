package MLShop_Admin.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class Orders_PageObjects {

    //    Header
    public WebElement UserIcon_Header(){return getDriver().findElement(By.xpath("//*[@class='nav-dropdown']"));}
    public WebElement Profile_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Profile']"));}
    public WebElement Messages_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Messages']"));}
    public WebElement Settings_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Settings']"));}
    public WebElement Logout_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Logout']"));}

    public WebElement Notification_Header(){return getDriver().findElement(By.cssSelector( "[class='notification fa fa-bell']"));}
    public WebElement MLSHOPADMIN_Header(){return getDriver().findElement(By.xpath("//span[contains(.,'ML Shop Admin')]"));}
    public WebElement MLHUILLIERSideBarLogo_Header(){return getDriver().findElement(By.xpath("//i[@class='fas fa-chevron-right sidebarLogo']"));}

    //Sidebar Navigation Buttons
    public WebElement Orders_Sidebar(){return getDriver().findElement(By.xpath("//a[normalize-space()='Orders']"));}

    //Search Bar
    public WebElement Searchbar_Orders(){return getDriver().findElement(By.xpath("//input[@id='txtSearch']"));}

    //Order Row
    public WebElement firstOrderNumber(){return getDriver().findElement(By.xpath("(//tr[@class=\"odd\"]//td/text())[1]"));}
    public WebElement firstOrderDate(){return getDriver().findElement(By.xpath("(//tr[@class=\"odd\"]//td/text())[2]"));}
    public WebElement firstOrderCustomerName(){return getDriver().findElement(By.xpath("(//tr[@class=\"odd\"]//td/text())[3]"));}
    public WebElement firstOrderQuantity(){return getDriver().findElement(By.xpath("(//tr[@class=\"odd\"]//td/text())[4]"));}
    public WebElement firstOrderTotalAmountPaid(){return getDriver().findElement(By.xpath("(//tr[@class=\"odd\"]//td/text())[5]"));}
    public WebElement firstOrderSellerName(){return getDriver().findElement(By.xpath("(//td[@class= 'sellerName'])[1]"));}
    public WebElement firstOrderModeOfPayment(){return getDriver().findElement(By.xpath("(//tr[@class=\"odd\"]//td/text())[7]"));}
    public WebElement firstOrderStatus(){return getDriver().findElement(By.xpath("(//tr[@class=\"odd\"]//td/text())[8]"));}

}
