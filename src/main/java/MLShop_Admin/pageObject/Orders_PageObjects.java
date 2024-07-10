package MLShop_Admin.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Orders_PageObjects {

    //      Overview Dashboard
    public WebElement TotalSales_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Total Sales')]"));}
    public WebElement ReturningCustomerRate_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Returning Customer Rate')]"));}
    public WebElement AverageOrderValue_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Average Order Value')]"));}
    public WebElement TotalOrders_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Total Orders')]"));}
    public WebElement TopProductsByUnitsSold_Dashboard(){return getDriver().findElement(By.xpath("//div[contains(text(),'Top Products by Units Sold')]"));}

    //    Header
    public WebElement UserIcon_Header(){return getDriver().findElement(By.xpath("//*[@class='nav-dropdown']"));}
    public WebElement Profile_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Profile']"));}
    public WebElement Messages_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Messages']"));}
    public WebElement Settings_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Settings']"));}
    public WebElement Logout_UserIcon(){return getDriver().findElement(By.xpath("//a[normalize-space()='Logout']"));}

    public WebElement Notification_Header(){return getDriver().findElement(By.cssSelector( "[class='notification fa fa-bell']"));}
    public WebElement MLSHOPADMIN_Header(){return getDriver().findElement(By.id("sidebarCollapse"));}
    public WebElement MLHUILLIERSideBarLogo_Header(){return getDriver().findElement(By.xpath("//i[@class='fas fa-chevron-right sidebarLogo']"));}

    //Sidebar Navigation Buttons
    public WebElement Orders_Sidebar(){return getDriver().findElement(By.xpath("//a[normalize-space()='Orders']"));}

    //Search Bar
    public WebElement Searchbar_Orders(){return getDriver().findElement(By.xpath("//input[@id='txtSearch']"));}

    //Entries
    public WebElement Entry_DropDown(){return getDriver().findElement(By.xpath("//select[@name='dataTables-example_length']"));}

//    public WebElement Entry_5(){return getDriver().findElement(By.xpath("//option[@value='5']"));}
//    public WebElement Entry_10(){return getDriver().findElement(By.xpath("//option[@value='10']"));}
//    public WebElement Entry_25(){return getDriver().findElement(By.xpath("//option[@value='25']"));}
//    public WebElement Entry_50(){return getDriver().findElement(By.xpath("//option[@value='50']"));}
//    public WebElement Entry_75(){return getDriver().findElement(By.xpath("//option[@value='75']"));}
//    public WebElement Entry_100(){return getDriver().findElement(By.xpath("//option[@value='100']"));}
//    public WebElement Entry_All(){return getDriver().findElement(By.xpath("//option[@value='-1']"));}

    //Order Row
    public WebElement firstOrderNumber(){return getDriver().findElement(By.xpath("(//td[@class='orderNo'])[1]"));}
    public WebElement firstOrderDate(){return getDriver().findElement(By.xpath("(//table/tbody/tr[1]/td[2])[2]"));}
    public WebElement firstOrderCustomerName(){return getDriver().findElement(By.xpath("(//td[@class='status'])[1]"));}
    public WebElement firstOrderQuantity(){return getDriver().findElement(By.xpath("(//td[@class='orderquantity'])[1]"));}
    public WebElement firstOrderTotalAmountPaid(){return getDriver().findElement(By.xpath("(//td[@class='ordertotalspent'])[1]"));}
    public WebElement firstOrderSellerName(){return getDriver().findElement(By.xpath("(//td[@class='sellerName'])[1]"));}
    public WebElement firstOrderModeOfPayment(){return getDriver().findElement(By.xpath("(//td[@class='status'])[2]"));}
    public WebElement firstOrderStatus(){return getDriver().findElement(By.xpath("(//td[@class='status'])[3]"));}

    //View Details
    public WebElement ViewDetailsFirstRow_Button(){return getDriver().findElement(By.xpath("(//button[contains(@class, 'btn btn-sm btn-outline-danger viewDetails') and contains(text(), 'View Details')])[1]"));}

    public WebElement OrderNumber_ViewDetails(){return getDriver().findElement(By.xpath("//h4[@class='orderno']/span[contains(text(), '')]"));}
    public WebElement OrderDate_ViewDetails(){return getDriver().findElement(By.xpath("(//td[@class='statusdata'])[1]"));}
    public WebElement CustomerName_ViewDetails(){return getDriver().findElement(By.xpath("(//td[@class='billingdata'])[2]"));}
    public WebElement TotalAmountPaid_ViewDetails(){return getDriver().findElement(By.xpath("(//td[@class='totaldataAmountPaid'])[1]"));}
    public WebElement Quantity_ViewDetails(){return getDriver().findElement(By.xpath("(//td[@style='text-align: center'])[4]"));}
//    public WebElement SellerName_ViewDetails(){return getDriver().findElement(By.xpath("(//td[@style='text-align: center'])[4]"));}
    public WebElement ModeOfPayment_ViewDetails(){return getDriver().findElement(By.xpath("(//td[@class='statusdata'])[4]"));}
    public WebElement OrderStatus_ViewDetails(){return getDriver().findElement(By.xpath("//span[@class='orderStatusHighlight']"));}

    // Page Navigation
    public WebElement Next_Pagination(){return getDriver().findElement(By.xpath("//a[@id='dataTables-example_next']"));}
    public WebElement Previous_Pagination(){return getDriver().findElement(By.xpath("//a[@id='dataTables-example_previous']"));}

    //Print Invoice
    public WebElement PrintInvoice(){return getDriver().findElement(By.xpath("//button[@id='printOrderDetailsInvoice']"));}


    //
    public List<WebElement> orderNumbers(){return getDriver().findElements(By.cssSelector("[class='orderNo']"));}
}
