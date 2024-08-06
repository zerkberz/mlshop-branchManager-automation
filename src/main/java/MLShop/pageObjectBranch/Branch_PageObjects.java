package MLShop.pageObjectBranch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Branch_PageObjects {
    //Dashboard
    public WebElement EmailField_LoginPage(){return getDriver().findElement(By.xpath("//input[@id='email']"));}
    public WebElement PasswordField_LoginPage(){return getDriver().findElement(By.xpath("//input[@id='password']"));}
    public WebElement LoginButton_LoginPage(){return getDriver().findElement(By.xpath("//button[@id='btnLogin']"));}

    //Home Page Objects
    public WebElement ReceiveItemFromMerchant_HomePage(){return getDriver().findElement(By.xpath("//a[contains(.,'Receive Item from Merchant')]"));}
    public WebElement PickUpItembyCargo_HomePage(){return getDriver().findElement(By.xpath("//a[contains(.,'Pick-up Item by Cargo')]"));}
    public WebElement ReceiveItemFromCargo_HomePage(){return getDriver().findElement(By.xpath("//a[contains(.,'Receive Item from Cargo')]"));}
    public WebElement ForCustomerPickUp_HomePage(){return getDriver().findElement(By.xpath("//a[contains(.,'For Customer Pick-up')]"));}

    //Entry Dropdown
    public WebElement EntryMerchant_DropDown(){return getDriver().findElement(By.xpath("//select[@name='recMerchant_length']"));}
    public WebElement EntryPCargo_DropDown(){return getDriver().findElement(By.xpath("//select[@name='PickupByCargoTable_length']"));}
    public WebElement EntryRCargo_DropDown(){return getDriver().findElement(By.xpath("//select[@name='receiveitemfromcargotable_length']"));}
    public WebElement EntryCustomerPickUp_DropDown(){return getDriver().findElement(By.xpath("//select[@name='customerpickuptable_length']"));}

    //Searchbars
    public WebElement ReceiveItemFromMerchant_Searchbar(){return getDriver().findElement(By.xpath("//input[@id='txtSearch']"));}
    public WebElement PickUpItemByCargo_Searchbar(){return getDriver().findElement(By.xpath("//input[@id='txtSearchPickUpByCargo']"));}
    public WebElement PickUpItemByCargo_Courier(){return getDriver().findElement(By.xpath("//select[@id='provider']"));}
    public WebElement ReceiveItemFromCargo_Searchbar(){return getDriver().findElement(By.xpath("//input[@id='orderfromcargo']"));}
    public WebElement ForCustomerPickUp_Searchbar(){return getDriver().findElement(By.xpath("//input[@id='ordercustomer']"));}

    //Modal
    public WebElement Modal_Failed(){return getDriver().findElement(By.id("modalfailedmsg"));}
    public WebElement Modal_Close(){return getDriver().findElement(By.cssSelector("#modalfailed .btn"));}
    public WebElement Modal_Text(){return getDriver().findElement(By.xpath("//label[@id='modalfailedmsg']"));}


    //ML SHOP Objects
    public WebElement MobileNumber_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//input[@id='OTP']"));}
    public WebElement Login_Button_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//button[@type='submit']"));}
    public WebElement OkayButton_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//button[normalize-space()='Okay']"));}
    public WebElement AmparitoCollections_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//p[contains(@class,'px-[20px] text-[16px]')][normalize-space()='Amparito Collections']"));}
    public WebElement FirstItemAmparito_MLSHOPBUYER(){return getDriver().findElement(By.xpath("(//h1[.])[1]"));}
    public WebElement AddToCard_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//button[normalize-space()='Add To Cart']"));}
    public WebElement ConfirmButtonCart_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//button[contains(@class,'flex justify-center rounded-md')]"));}
    public WebElement Cart_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//*[name()='path' and contains(@d,'M2.25 2.25')]"));}
    public WebElement Checkout_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//button[@type='button']"));}
    public WebElement ProvinceState_MLSHOPBUYER(){return getDriver().findElement(By.xpath("(//select[@name='Province State'])[2]"));}
    public WebElement CityTown_MLSHOPBUYER(){return getDriver().findElement(By.xpath("(//select[@name='City/State'])[2]"));}
    public WebElement Branch_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//select[@name='Branch Name']"));}
    public WebElement MLWallet_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//input[@value='ML WALLET']"));}
    public WebElement PlaceOrder_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//button[normalize-space()='Place Order']"));}
    public WebElement ProceedButton_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//button[normalize-space()='Proceed']"));}
    public WebElement OkayButton_Checkout_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//button[contains(@class,'flex justify-center rounded-md')]"));}
    public WebElement PurchaseHistory_FirstOrderNumber_MLSHOPBUYER(){return getDriver().findElement(By.xpath("(//span[contains(@class,' font-semibold')])[1]"));}
    public WebElement ProductName_MLSHOPBUYER(){return getDriver().findElement(By.xpath("(//h1[.])[1]"));}
    public WebElement ShopStatus_MLSHOPBUYER(){return getDriver().findElement(By.xpath("(//span[contains(@class, 'text-red-600 font-semibold')])[1]"));}

    public WebElement AvatarIcon_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//p[@class='text-[#333333] text-[14px] pl-[5px]']"));}
    public WebElement ProfileAvatar_MLSHOPBUYER(){return getDriver().findElement(By.xpath("//p[.='Profile']"));}
    public WebElement UserFullName_MLSHOPBUYER(){return getDriver().findElement(By.xpath("(//p[.])[16]"));}
    public WebElement BranchName_MLSHOPBUYER(){return getDriver().findElement(By.cssSelector("select[name='Branch Name']"));}

    public List<WebElement> orderNumberListTr(){return getDriver().findElements(By.xpath("//span[@class=' font-semibold' or @class='even']"));}
    public List<WebElement> orderStatusListTr(){return getDriver().findElements(By.xpath("//span[@class='text-red-600 font-semibold' or @class='even']"));}


    //Buttons
    public WebElement SelectButton(){return getDriver().findElement(By.xpath("//button[contains(.,'Select')]"));}
    public WebElement ReceiveItemButton_RIFM(){return getDriver().findElement(By.xpath("//button[normalize-space()='Receive Item']"));}
    public WebElement ReprintButton_RIFM(){return getDriver().findElement(By.xpath("(//button[normalize-space()='Reprint'])[1]"));}
    public WebElement CloseButton_RIFM(){return getDriver().findElement(By.xpath("//div[@id='receivedmerchantmodalsuccess']//button[normalize-space()='Close']"));}
    public WebElement PickUpItemButton(){return getDriver().findElement(By.xpath("//button[@id='pickupItembtn']"));}
    public WebElement DispatchButton_PUIBC(){return getDriver().findElement(By.xpath("(//button[@class='btn btn-warning font-white'])[2]"));}
    public WebElement SubmitButton_PUIBC(){return getDriver().findElement(By.xpath("//button[@class='btn btn-success btn']"));}
    public WebElement FormDispatchButton_PUIBC(){return getDriver().findElement(By.cssSelector("#autodispatch"));}
    public WebElement ExitFormButton_PUIBC(){return getDriver().findElement(By.xpath("//button[.='×']"));}
    public WebElement OrderReceived_FCPU(){return getDriver().findElement(By.xpath("//button[normalize-space()='Order Received']"));}
    public WebElement PlainDispatchButton_PUIBC(){return getDriver().findElement(By.xpath("//div[@class='btn-dispatch-group']/button[@class='btn btn-warning font-white']"));}


    //Receive Item From Merchant Information
    public WebElement OrderNumberPOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='order-number']"));}
    public WebElement ProvincePOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='province']"));}
    public WebElement OrderDatePOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='order-date']"));}
    public WebElement LastNamePOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='lastname']"));}
    public WebElement FirstNamePOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='firstname']"));}
    public WebElement DestinationPOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='destination']"));}
    public WebElement DetailsPOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='details']"));}
    public WebElement PricePOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='price']"));}
    public WebElement ProductNamePOPUP_RIFM(){return getDriver().findElement(By.xpath("//input[@id='details']"));}


    //Pick up Item by Cargo
    public WebElement Courier_PUIBC(){return getDriver().findElement(By.xpath("//input[@id='order-provider']"));}
    public WebElement CustomerFullNamePOPUP_PIUBC(){return getDriver().findElement(By.xpath(" //input[@id='order-customer']"));}
    public WebElement ProductName_PUIBC(){return getDriver().findElement(By.xpath("//input[@id='order-itemdetail']"));}
    public WebElement CloseButton_PUIBC(){return getDriver().findElement(By.xpath("//input[@id='order-itemdetail']"));}

    //Receive Item From Cargo
    public WebElement ProductName_RIFC(){return getDriver().findElement(By.xpath("//input[@id='order-itemdetail']"));}

    //For Customer Pick-up


    //Pop Up
    public WebElement ConfirmationMessage_RIFM(){return getDriver().findElement(By.xpath("//label[@id='receivedmerchantmodalsuccessmsg']\n"));}
    public WebElement ConfirmationMessage_PUIBC(){return getDriver().findElement(By.xpath("//label[@id='pickupcargomodalsuccessmsg']"));}
    public WebElement ConfirmationMessage_RIFC(){return getDriver().findElement(By.xpath("//label[@id='receivecargomodalsuccessmsg']"));}
    public WebElement ConfirmationMessage_FCPU(){return getDriver().findElement(By.xpath("//label[@id='customerpickupmodalsuccessmsg']"));}

    //FirstRow
    public WebElement OrderNumberFirstRow(){return (WebElement) getDriver().findElement(By.xpath("(//tr[@class='odd']/td[1])[1]"));}
    public WebElement ProductNameFirstRow(){return (WebElement) getDriver().findElement(By.xpath("(//tr[@class='odd']/td[3])[1]"));}
    public WebElement StatusFirstRow(){return getDriver().findElement(By.xpath("(//tr[@class='odd']/td[7])[1]"));}
    public WebElement DestinationAddressFirstRow(){return (WebElement) getDriver().findElement(By.xpath("(//tr[@class='odd']/td[6])[1]"));}
    public WebElement CustomerNameFirstRow(){return (WebElement) getDriver().findElement(By.xpath("(//tr[@class='odd']/td[5])[1]"));}

    //List
    public List<WebElement> orderNumberList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[1]"));}
    public List<WebElement> quantityList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[2]"));}
    public List<WebElement> productNameList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[3]"));}
    public List<WebElement> orderDateList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[4]"));}
    public List<WebElement> customerNameList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[5]"));}
    public List<WebElement> destinationAddressList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[6]"));}
    public List<WebElement> statusList(){return getDriver().findElements(By.xpath("//tr[@class='odd' or @class='even']/td[7]"));}

}
