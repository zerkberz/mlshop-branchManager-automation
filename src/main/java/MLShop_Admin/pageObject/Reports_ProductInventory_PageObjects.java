package MLShop_Admin.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Reports_ProductInventory_PageObjects {

    //Sidebar Navigation Buttons
    public WebElement Reports_Sidebar(){return getDriver().findElement(By.xpath("//a[normalize-space()='Reports']"));}
    public WebElement ProductInventory_Sidebar(){return getDriver().findElement(By.xpath("//a[normalize-space()='Product Inventory']"));}

    //Search Bar
    public WebElement Searchbar_ProductList(){return getDriver().findElement(By.xpath("//input[@id='txtSearch']"));}

    //Date Picker
    public WebElement Date_From(){return getDriver().findElement(By.xpath("//input[@id='datepicker_from']"));}
    public WebElement Date_To(){return getDriver().findElement(By.xpath("//input[@id='datepicker_to']"));}

    public WebElement Date_Year(){return getDriver().findElement(By.xpath("//input[@id='datepicker_fromyearly']"));}
    public WebElement Date_Year2(){return getDriver().findElement(By.xpath("//input[@id='datepicker_toyearly']"));}

    //First Row Data
    public WebElement Category_FirstRow(){return getDriver().findElement(By.xpath("(//tr[@class='odd' or @class='even']/td[4])[1]"));}
    public WebElement LotNumber_FirstRow(){return getDriver().findElement(By.xpath("(//tr[@class='odd' or @class='even']/td[6])[1]"));}
    public WebElement ProductType_FirstRow(){return getDriver().findElement(By.xpath("(//tr[@class='odd' or @class='even']/td[5])[1]"));}
    public WebElement SellerName_FirstRow(){return getDriver().findElement(By.xpath("(//tr[@class='odd' or @class='even']/td[13])[1]"));}
    public WebElement BarcodeSKU_FirstRow(){return getDriver().findElement(By.xpath("(//tr[@class='odd' or @class='even']/td[7])[1]"));}
    public WebElement ProductID_FirstRow(){return getDriver().findElement(By.xpath("(//tr[@class='odd' or @class='even']/td[2])[1]"));}
    public WebElement Region_FirstRow(){return getDriver().findElement(By.xpath("(//tr[@class='odd' or @class='even']/td[14])[1]"));}

    //Pagination
    public WebElement Next_Pagination(){return getDriver().findElement(By.xpath("//a[normalize-space()='»']"));}
    public WebElement Previous_Pagination(){return getDriver().findElement(By.xpath("//a[normalize-space()='«']"));}

    //List
    public List<WebElement> dates(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[1]"));}
    public List<WebElement> categoryList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[4]"));}
    public List<WebElement> lotnumberList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[6]"));}
    public List<WebElement> producttypeList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[5]"));}
    public List<WebElement> sellerNameList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[13]"));}
    public List<WebElement> barcodeSKUList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[7]"));}
    public List<WebElement> productIDList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[2]"));}
    public List<WebElement> regionList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[14]"));}

    //Export
    public WebElement Export_PDF_Button(){return getDriver().findElement(By.xpath("//button[normalize-space()='Export pdf']"));}
    public WebElement Export_Excel_Button(){return getDriver().findElement(By.xpath("//button[@class='dt-button buttons-excel buttons-html5 exportExcel']"));}
    public WebElement Export_Button(){return getDriver().findElement(By.xpath("//button[@id='myBtn']"));}
    public WebElement ExportALL_Button(){return getDriver().findElement(By.xpath("//button[@id='export']"));}
    public WebElement PopUp_Space(){return getDriver().findElement(By.xpath("//div[@class='yearly']"));}






}
