package MLShop_Admin.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class Dashboard_PageObjects {

//    Header
    public WebElement UserIcon_Header(){return getDriver().findElement(By.xpath("//*[@class='nav-dropdown']"));}
        public WebElement Profile_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Profile']"));}
        public WebElement Messages_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Messages']"));}
        public WebElement Settings_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Settings']"));}
        public WebElement Logout_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Logout']"));}

    public WebElement Notification_Header(){return getDriver().findElement(By.cssSelector( "[class='notification fa fa-bell']"));}
    public WebElement MLSHOPADMIN_Header(){return getDriver().findElement(By.xpath("//span[contains(.,'ML Shop Admin')]"));}
    public WebElement MLHUILLIERSideBarLogo_Header(){return getDriver().findElement(By.xpath("//i[@class='fas fa-chevron-right sidebarLogo']"));}

//      Overview Dashboard
    public WebElement TotalSales_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Total Sales')]"));}
    public WebElement ReturningCustomerRate_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Returning Customer Rate')]"));}
    public WebElement AverageOrderValue_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Average Order Value')]"));}
    public WebElement TotalOrders_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Total Orders')]"));}
    public WebElement TopProductsByUnitsSold_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Top Products by Units Sold')]"));}

}
