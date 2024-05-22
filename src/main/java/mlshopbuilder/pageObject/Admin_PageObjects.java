package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.DriverManager.getDriver;

public class Admin_PageObjects {

    // Avatar icon
    public WebElement shopbuilderbutton() {return getDriver().findElement(By.xpath("//div[normalize-space()='Shop Builder']"));}
    public WebElement userIcon() {return getDriver().findElement(By.xpath("//img[@alt='Avatar']"));}
    public WebElement dashboardbtn() {return getDriver().findElement(By.xpath("//div[normalize-space()='Dashboard']"));}
    public WebElement agentconfigbtn() {return getDriver().findElement(By.xpath("//div[normalize-space()='Agent Config']"));}
    public WebElement logoutbtn() {return getDriver().findElement(By.xpath("//div[normalize-space()='Logout']"));}

    // Dashboard Objects
    public WebElement totalstorecount() {return getDriver().findElement(By.xpath("//p[normalize-space()='Total Stores:']"));}
    public WebElement newlyaddedstore() {return getDriver().findElement(By.xpath("//p[normalize-space()='Newly added store:']"));}
    public WebElement dashboardpagebtn() {return getDriver().findElement(By.xpath("//a[normalize-space()='Dashboard']"));}
    public WebElement merchantsbtn() {return getDriver().findElement(By.xpath("//a[normalize-space()='Merchants']"));}

    // Shop Builder Objects
    public WebElement totalstores(){return  getDriver().findElement(By.xpath("//div[@class='pt-3 sm:text-[16px] md:text-[20px]' and contains(text(), 'Total Stores:')]"));}
    public WebElement StoreSearchWatches() {return getDriver().findElement(By.xpath("//div[contains(text(),'ML Shop Watch Store')]"));}
    public WebElement MLShopJewelryStore() {return getDriver().findElement(By.xpath("//div[contains(text(),'ML Shop Jewelry Store')]"));}
    public WebElement MLWatches() {return getDriver().findElement(By.xpath("//div[contains(text(),'ML Watches')]"));}
    public WebElement Test() {return getDriver().findElement(By.xpath("//div[contains(text(),'Test')]"));}
    // Add Store Pop Up elements
    public WebElement addstorebtn() {return getDriver().findElement(By.xpath("//button[contains(text(),'Add Store')]"));}
    public WebElement storeName() {return getDriver().findElement(By.xpath("//input[@id='storeName']"));}
    public WebElement descstore() {return getDriver().findElement(By.xpath("//input[@id='storeDescription']"));}
    public WebElement submitbtn() {return getDriver().findElement(By.xpath("//button[contains(text(),'Submit')]"));}
    public WebElement exitbtn() {return getDriver().findElement(By.xpath("(//*[name()='path'])[2]"));}
    // Test Store Objects
    public WebElement addcategory() {return getDriver().findElement(By.xpath("//div[contains(text(),'Add Category')]"));}
    public WebElement hideshowcategories() {return getDriver().findElement(By.xpath("//div[contains(text(),'Hide/Show Categories')]"));}

    public WebElement categoryname() {return getDriver().findElement(By.xpath("//input[@id='labelName']"));}
    //changename before test
    public WebElement addedcategory() {return getDriver().findElement(By.xpath("//p[normalize-space()='L Boss']"));}
    //categories
    public WebElement showone() {return getDriver().findElement(By.xpath("(//*[@class='jsx-d12142d8917979c2 text-white' and contains(text(),'SHOW')])[1]"));}
    public WebElement showtwo() {return getDriver().findElement(By.xpath("(//*[@class='jsx-d12142d8917979c2 text-white' and contains(text(),'SHOW')])[2]"));}

    public WebElement hideone() {return getDriver().findElement(By.xpath("(//*[@class='jsx-d12142d8917979c2 text-white' and contains(text(),'HIDE')])[1]"));}
    public WebElement hidetwo() {return getDriver().findElement(By.xpath("(//*[@class='jsx-d12142d8917979c2 text-white' and contains(text(),'HIDE')])[2]"));}

    // Type
    public WebElement addtype() {return getDriver().findElement(By.xpath("(//div[contains(text(),'+')])[1]"));}
    public WebElement typename() {return getDriver().findElement(By.xpath("//input[@id='typeName']"));}
    public WebElement yourmytype() {return getDriver().findElement(By.xpath("(//label[contains(text(), \"You're My Type\")])[1]"));}
    // Sort Price
    public WebElement sortprice() {return getDriver().findElement(By.xpath("(//div[contains(text(),'+')])[last()]"));}
    public WebElement sortprice2() {return getDriver().findElement(By.cssSelector("mt-1 ml-2 mr-2 mx-auto md:block text-center text-sm font-semibold py-1 px-4 rounded-md w-auto bg-slate-300 hover:bg-neutral-100 transition cursor-pointer text-gray-500"));}
    public WebElement sortname() {return getDriver().findElement(By.xpath("//input[@id='sortName']"));}
    public WebElement updatesortname() {return getDriver().findElement(By.xpath("(//div[@class=\"mr-2 pt-[5px] pl-1 pr-1 text-xs md:block text-center font-semibold rounded-md w-auto bg-blue-400 hover:bg-slate-300 transition cursor-pointer text-white\"])[last()]"));}
    public  WebElement hightolowvalidation() {return getDriver().findElement(By.xpath("(//*[contains(text(), \"High to Low\")])[1]"));}
    public  WebElement lowtohighvalidation() {return getDriver().findElement(By.xpath("(//*[contains(text(), \"Low to High\")])[1]"));}
    //toggle
    public WebElement shoptoggle() {return getDriver().findElement(By.xpath("//div[@class='cursor-pointer']"));}
    public WebElement shoptogglev2() {return getDriver().findElement(By.xpath("//div[@class='cursor-pointer']//*[name()='svg']"));}
    // view logs elements
    public WebElement idproductsearch() {return getDriver().findElement(By.xpath("//input[@placeholder='Search Product ID']"));}
    public WebElement dropdownLogs() {return getDriver().findElement(By.cssSelector("[class='mb-4 border border-black text-sm']"));}
    public WebElement hypertextrolex() {return getDriver().findElement(By.xpath("(//span[contains(text(), \"Rolex\")])[1]"));}
    public WebElement loadalllogs() {return getDriver().findElement(By.xpath("//p[@class='text-[14px] text-blue-500 hover:underline cursor-pointer' and text()='Load all logs']"));}

    public WebElement optionAllLogs() {return getDriver().findElement(By.xpath("//option[@value='all' and text()='All Logs']"));}
    public WebElement optionAddedLogs() {return getDriver().findElement(By.xpath("//option[@value='all' and text()='Added Logs']"));}
    public WebElement optionUpdatedLogs() {return getDriver().findElement(By.xpath("//option[@value='all' and text()='Updated Logs']"));}

    //view products elements
    public WebElement display1() {return getDriver().findElement(By.xpath("(//p[@title=\"Automatic 10K Yellow Gold\"])[1]"));}
    //Product Information
    public WebElement modelname() {return getDriver().findElement(By.xpath("//input[@id='modelName']"));}
    public WebElement availablequanitity() {return getDriver().findElement(By.xpath("//label[normalize-space()='Available Quantity']"));}
    public WebElement productnotes() {return getDriver().findElement(By.xpath("//input[@id='productNotes']"));}
    public WebElement productsize() {return getDriver().findElement(By.xpath("// select[@id='productSize']"));}
    //Sales Information
    public WebElement allbarcode() {return getDriver().findElement(By.xpath("//input[@id='barcode']"));}
    public WebElement costofsales() {return getDriver().findElement(By.xpath("//input[@id='costSales']"));}
    public WebElement grossprice() {return getDriver().findElement(By.xpath("// input[@id='grossPrice']"));}
    public WebElement salesprice() {return getDriver().findElement(By.xpath("//input[@id='price']"));}
    //Shipping Information
    public WebElement packaging() {return getDriver().findElement(By.xpath("//select[@id='packaging']"));}
    public WebElement shippingsize() {return getDriver().findElement(By.xpath("//select[@id='size']"));}
    public WebElement courier() {return getDriver().findElement(By.xpath("// select[@id='courier']"));}
    //availability on shop
    public WebElement availabilityshop() {return getDriver().findElement(By.xpath("//label[@for='isAvailable']"));}

    //editprofile
    public WebElement originalname() {return getDriver().findElement(By.xpath("//p[@class='font-medium text-2xl' and contains(text(), 'ML Watches')]"));}

    //sub account objects
    public WebElement subacctbtn() {return getDriver().findElement(By.xpath("//a[normalize-space()='Sub Accounts']"));}
    public WebElement addaccountbtn() {return getDriver().findElement(By.xpath("//p[@class='text-white' and contains(text(), 'Add')]"));}
    public WebElement mainaccttxtbox() {return getDriver().findElement(By.xpath("(//div[@class=' css-hlgwow'])[1]"));}
    public WebElement mainaccttxtbox2() {return getDriver().findElement(By.id("react-select-2-input"));}
    public WebElement namesub() {return getDriver().findElement(By.id("name"));}
    public WebElement emailsub() {return getDriver().findElement(By.id("email"));}
    public WebElement passSub() {return getDriver().findElement(By.id("initialPassword"));}
    public WebElement repassSub() {return getDriver().findElement(By.id("password"));}
    public WebElement registerAsmerchantbtn() {return getDriver().findElement(By.xpath("//button[normalize-space()='Register as merchant']"));}
    public WebElement editbuttonSubacct2() {return getDriver().findElement(By.xpath("//tbody/tr[last()]/td[6]/div[1]/div[1]//*[name()='svg']"));};
    public WebElement editbuttonSubacct3() {return getDriver().findElement(By.xpath("//tbody/tr[5]/td[6]/div[1]/div[1]//*[name()='svg']"));};
    public WebElement nametxt() {return getDriver().findElement(By.xpath("//input[@id='name']"));}
    public WebElement emailtxt() {return getDriver().findElement(By.xpath("//input[@id='email']"));}

    public WebElement deactivateacctSUBACCOUNT() {return getDriver().findElement(By.xpath("(//*[name()='svg'])[6]"));}
    public WebElement deactivatemerchant() {return getDriver().findElement(By.xpath("//button[normalize-space()='Deactivate Merchant']"));}
    public WebElement activatemerchant() {return getDriver().findElement(By.xpath("//button[normalize-space()='Activate Merchant']"));}
    public WebElement testshop() {return getDriver().findElement(By.xpath("(//div[normalize-space()='Test'])[1]"));};
    public WebElement mercadodefrancisshop() {return getDriver().findElement(By.xpath("(//div[normalize-space()='Mercado de Francis'])[1]"));};
    public WebElement shopbutton() {return getDriver().findElement(By.xpath("(//*[name()='svg']//*[name()='path' and contains(@d,'M480 448h-')]))[6]"));};

    //interchangeable Values
    // SBA 20
    public WebElement editbuttonSubacct() {return getDriver().findElement(By.xpath("(//*[name()='svg'])[20]"));}
    public WebElement registerasmerchantbtn() {return getDriver().findElement(By.xpath("(//*[name()='svg'])[24]"));}

    //tr
    public List<WebElement> subAccTr(){return getDriver().findElements(By.xpath("//tr[@class='jsx-b09e653eba0e5d15']"));}

    public WebElement notificationStatus(){
        return getDriver().findElement(By.cssSelector("[role='status']"));
    }
    public WebElement viewMerchantIcon(){
        return getDriver().findElement(By.xpath("//tr/td[6]/child::div/child::div[2]"));
    }
    public WebElement editIcon(){
        return getDriver().findElement(By.xpath("//tr/td[6]/child::div/child::div"));
    }
    public WebElement viewStores(){
        return getDriver().findElement(By.xpath("//p[text()='View Stores']"));
    }
    public WebElement firstStore(){
        return getDriver().findElement(By.xpath("(//div[@class='mt-3 grid grid-cols-2 sm:grid-cols-3 md:grid-cols-3 lg:grid-cols-3 gap-2'])[1]/child::div[1]"));
    }

    //main account
    public WebElement mainaccountbtn() {return getDriver().findElement(By.xpath("//a[normalize-space()='Main Accounts']"));}
    public WebElement editablemerchantinfo() {return getDriver().findElement(By.xpath("(//p[normalize-space()='View'])[1]"));}

    //merchant tab
    public WebElement viewmerchantbtn(){return getDriver().findElement(By.xpath("(//p[normalize-space()='View'])[1]"));}
    public WebElement editinfomerchant(){return getDriver().findElement(By.xpath("//p[@class=\"text-sm text-blue-500 hover:bg-slate-200 pl-2 pr-2 cursor-pointer\" and text()=\"Edit info\"]"));}
    public WebElement Statusdropdown(){return getDriver().findElement(By.xpath("(//input[@id='react-select-2-input'])[1]"));}
    public WebElement submitbtnmerchant(){return getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));}
    public WebElement editablemerchantbtn(){return getDriver().findElement(By.xpath("(//p[normalize-space()='View'])[1]"));}
    //edit placing per text cases
    public WebElement editablemerchant2btn(){return getDriver().findElement(By.xpath("(//p[normalize-space()='View'])[10]"));}

    //update merchant info
    public WebElement contactnum(){return getDriver().findElement(By.xpath("//input[@id='storeNumber']"));}
    public WebElement storeemail(){return getDriver().findElement(By.xpath("//input[@id='storeEmail']"));}
    public WebElement provincedrop(){return getDriver().findElement(By.xpath("//input[@id='react-select-3-input']"));}
    public WebElement citydrop(){return getDriver().findElement(By.xpath("//input[@id='react-select-4-input']"));}
    public WebElement zonecodedrop(){return getDriver().findElement(By.xpath("//input[@id='react-select-5-input']"));}
    public WebElement branchnamedrop(){return getDriver().findElement(By.xpath("//input[@id='react-select-6-input']"));}
    public WebElement errorstore(){return getDriver().findElement(By.xpath("//*[contains(text(), 'The email address is invalid and incorrect')]"));}
    public WebElement viewstores(){return getDriver().findElement(By.xpath("//p[@class='text-[12px]' and contains(text(), 'View Stores')]"));}
    public WebElement hidestores(){return getDriver().findElement(By.xpath("//p[@class='text-[12px]' and contains(text(), 'Hide Stores')]"));}
    public WebElement mercadodefrancis(){return getDriver().findElement(By.xpath("//div[contains(text(),'Mercado de Francis')]"));}
    public WebElement mlshopjewlery(){return getDriver().findElement(By.xpath("//div[contains(text(),'ML Shop Jewelry Store')]"));}
    public WebElement statustextboxmerchant(){return getDriver().findElement(By.xpath("//div[@class=' css-19bb58m']"));}


    // Agent Config
    public WebElement SearchOrderID(){return getDriver().findElement(By.xpath("//input[@placeholder='Enter Order ID']"));}
    public WebElement Searchbtn(){return getDriver().findElement(By.xpath("//p[normalize-space()='Search']"));}










}

