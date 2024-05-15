package mlshopbuilder.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class SupportAdmin_PageObjects {

    //user Avatar
    public WebElement userIcon() {return getDriver().findElement(By.xpath("//img[@alt='Avatar']"));}
    public WebElement dashboardbtn() {return getDriver().findElement(By.xpath("//div[normalize-space()='Dashboard']"));}
    public WebElement shopbuilderbtn() {return getDriver().findElement(By.xpath("//div[normalize-space()='Shop Builder']"));}
    public WebElement logoutbtn() {return getDriver().findElement(By.xpath("//div[normalize-space()='Logout']"));}

    //dashboard objects
    public WebElement totalstorecount() {return getDriver().findElement(By.xpath("//p[normalize-space()='Total Stores:']"));}
    public WebElement newlyaddedstore() {return getDriver().findElement(By.xpath("//p[normalize-space()='Newly added store:']"));}
    public WebElement dashboardpagebtn() {return getDriver().findElement(By.xpath("//a[normalize-space()='Dashboard']"));}
    public WebElement merchantsbtn() {return getDriver().findElement(By.xpath("//a[normalize-space()='Merchants']"));}

    //shopbuilder objects
    public WebElement InvalidSearch() {return getDriver().findElement(By.xpath("//div[contains(text(),'')]"));}
    public WebElement StoreSearchWatches() {return getDriver().findElement(By.xpath("//div[contains(text(),'Watch')]"));}
    public WebElement MLShopJewelryStore() {return getDriver().findElement(By.xpath("//div[contains(text(),'Jewelry')]"));}
    public WebElement TotalStore() {return getDriver().findElement(By.xpath("//div[@class='pt-3 sm:text-[16px] md:text-[20px]']"));}
    public WebElement TotalNumberStore() {return getDriver().findElement(By.xpath("//b[normalize-space()='3']"));}
    public WebElement Searchtxtbox() {return getDriver().findElement(By.xpath("//input[@placeholder='Search store']"));}
    public WebElement viewproductbtn(){return  getDriver().findElement(By.xpath("//p[normalize-space()='View Products']"));}
    public WebElement Addproduct() {return getDriver().findElement(By.xpath("//p[normalize-space()='Add Product']"));}
    public WebElement EditProfile() {return getDriver().findElement(By.xpath("//p[normalize-space()='Edit Profile']"));}
    public WebElement Editname() {return getDriver().findElement(By.xpath("//p[@class='text-sm text-blue-500 hover:bg-slate-200 pl-2 pr-2 cursor-pointer']"));}
    public WebElement Updatenametxtbox() {return getDriver().findElement(By.xpath("//input[@id='storeName']"));}
    public WebElement Updatebiotextbox() {return getDriver().findElement(By.xpath("//input[@id='storeDescription']"));}
    public WebElement submitbutton() {return getDriver().findElement(By.xpath("//button[contains(text(), 'Submit')]"));}
    public WebElement exitbutton() {return getDriver().findElement(By.xpath("//button[@class='p-1 border-0 hover:opacity-70 transition absolute left-9']//*[name()='svg']"));}
    public WebElement originalname() {return getDriver().findElement(By.xpath("//p[@class='font-medium text-2xl' and contains(text(), 'ML Shop Jewelry Store')]"));}
    public WebElement changename() {return getDriver().findElement(By.xpath("//p[@class='font-medium text-2xl' and contains(text(), 'Wow Nice')]"));}
    public WebElement editbanner() {return getDriver().findElement(By.xpath("//p[normalize-space()='Edit Banner']"));}
    public WebElement canceleditbanner() {return getDriver().findElement(By.xpath("//p[normalize-space()='Cancel Edit']"));}
    public WebElement addbannerbtn() {return getDriver().findElement(By.xpath("//p[normalize-space()='Add Banner']"));}
    public WebElement chooseBanner(){
        return getDriver().findElement(By.id("src"));
    }
    public WebElement bannerscreensize() {return getDriver().findElement(By.id("size"));}
    public WebElement bannerposition() {return getDriver().findElement(By.id("position"));}


    //Add Product page
    public WebElement Amparitotickbox() {return getDriver().findElement(By.cssSelector("[for='amparito']"));}
    public WebElement Savebtnadd() {return getDriver().findElement(By.xpath("//button[normalize-space()='Save']"));}
    public WebElement Publlishbtnadd() {return getDriver().findElement(By.xpath("//button[normalize-space()='Publish']"));}

    //Product Information
    public WebElement Quantitytxtbox(){return  getDriver().findElement(By.id("quantity"));}
    public WebElement errorQuantitytxtbox(){return  getDriver().findElement(By.xpath("//body/div[contains(@class,'pt-15')]/div[contains(@class,'max-w-[2520px] mx-auto xl:px-20 md:px-10 sm:px-2 px-4')]/div[contains(@class,'pt-16')]/div/div/div/div/div/div[contains(@class,'')]/div[contains(@class,'ps-8 mb-3 ml-5 text-gray-900 dark:text-black-950')]/form/div[contains(@class,'m-6')]/span[1]"));}
    public WebElement ItemWeighttxtbox(){return  getDriver().findElement(By.id("weight"));}
    public WebElement errorItemWeighttxtbox(){return  getDriver().findElement(By.xpath("//body/div[contains(@class,'pt-15')]/div[contains(@class,'max-w-[2520px] mx-auto xl:px-20 md:px-10 sm:px-2 px-4')]/div[contains(@class,'pt-16')]/div/div/div/div/div/div[contains(@class,'')]/div[contains(@class,'ps-8 mb-3 ml-5 text-gray-900 dark:text-black-950')]/form/div[contains(@class,'m-6')]/span[2]"));}

    public WebElement StyleNametxtbox(){return  getDriver().findElement(By.id("styleName"));}
    public WebElement errorStyleNametxtbox(){return  getDriver().findElement(By.xpath(""));}
    public WebElement Notetxtbox(){return  getDriver().findElement(By.id("productNotes"));}
    public WebElement errorNotetxtbox(){return  getDriver().findElement(By.xpath(""));}
    public WebElement ProductSize(){return  getDriver().findElement(By.xpath("//input[@id='productSize']"));}

    //sales Information
    public WebElement Barcodetxtbox(){return  getDriver().findElement(By.id("barcode"));}
    public WebElement errorBarcodetxtbox(){return  getDriver().findElement(By.xpath("//div[contains(@class,'ps-8 mb-3 ml-10 text-gray-500 dark:text-gray-400')]//span[1]"));}
    public WebElement Lotnumbertxtbox(){return  getDriver().findElement(By.id("lotNum"));}
    public WebElement Lotnumber2txtbox(){return  getDriver().findElement(By.xpath("//input[@id='lotnumber']"));}
    public WebElement errorLotnumbertxtbox(){return  getDriver().findElement(By.xpath("//div[contains(@class,'ps-8 mb-3 ml-10 text-gray-500 dark:text-gray-400')]//span[2]"));}
    public WebElement Costofsalestxtbox(){return  getDriver().findElement(By.id("costSales"));}
    public WebElement Costofsales2txtbox(){return  getDriver().findElement(By.xpath("//input[@id='costSales']"));}
    public WebElement errorCostofsalestxtbox(){return  getDriver().findElement(By.xpath("//div[contains(@class,'ps-8 mb-3 ml-10 text-gray-500 dark:text-gray-400')]//span[3]"));}
    public WebElement grosssalestxtbox(){return  getDriver().findElement(By.id("grossPrice"));}
    public WebElement grosssales2txtbox(){return  getDriver().findElement(By.xpath("//input[@id='grossPrice']"));}
    public WebElement errorgrosssalestxtbox(){return  getDriver().findElement(By.xpath("//div[contains(@class,'ps-8 mb-3 ml-10 text-gray-500 dark:text-gray-400')]//span[4]"));}
    public WebElement pricetxtbox(){return  getDriver().findElement(By.id("price"));}
    public WebElement price2txtbox(){return  getDriver().findElement(By.xpath("//input[@id='price']"));}
    public WebElement errorpricetxtbox(){return  getDriver().findElement(By.xpath("//div[contains(@class,'ps-8 mb-3 ml-10 text-gray-500 dark:text-gray-400')]//span[5]"));}


    //View Products
    public WebElement Searchtxtbx(){return  getDriver().findElement(By.xpath("//input[@placeholder='Search']"));}
    public WebElement entrydropdown(){return  getDriver().findElement(By.xpath("//select[@id='entries']"));}
    public WebElement entryoption10down(){return  getDriver().findElement(By.xpath("//option[@value='10']"));}
    public WebElement entryoption25down(){return  getDriver().findElement(By.xpath("//option[@value='25' ]"));}
    public WebElement entryoption50down(){return  getDriver().findElement(By.xpath("//option[@value='50']"));}
    public WebElement entryoption75down(){return  getDriver().findElement(By.xpath("//option[@value='75']"));}
    public WebElement entryoption100down(){return  getDriver().findElement(By.xpath("//option[@value='100']"));}
    public WebElement entryoptionalldown(){return  getDriver().findElement(By.xpath("//option[@value='All']"));}

    public WebElement Viewdetailsbtn(){return  getDriver().findElement(By.xpath("(//div[contains(@class, \"jsx-9ed979a19a0f8424\")])[3]"));}
    public WebElement Editviewdetailsbtn(){return  getDriver().findElement(By.xpath("(//div[contains(@class, \"jsx-9ed979a19a0f8424\")])[4]"));}
    public WebElement Amparitotickbox2(){return  getDriver().findElement(By.xpath("//label[@for='amparito']"));}
    public WebElement Viewdetailsbtn2(){return  getDriver().findElement(By.xpath("(//div[contains(@class, \"jsx-9ed979a19a0f8424\")])[1]"));}
    public WebElement Fromdateinput(){return  getDriver().findElement(By.xpath("(//input[@value=''])[2]"));}
    public WebElement Todateinput(){return  getDriver().findElement(By.xpath("//input[2]"));}

    public WebElement nextbtn(){return  getDriver().findElement(By.xpath("//button[normalize-space()='Next']"));}
    public WebElement previousbtn(){return  getDriver().findElement(By.xpath("//button[normalize-space()='Previous']"));}

    //View Details Object
    public WebElement editinfobtn(){return  getDriver().findElement(By.xpath("//button[normalize-space()='Edit Info']"));}
    public WebElement cancelbtn(){return  getDriver().findElement(By.xpath("//button[normalize-space()='Cancel']"));}
    public WebElement updateandsubmit(){return  getDriver().findElement(By.xpath("//button[normalize-space()='Update & Submit']"));}

    public WebElement successfulupdate(){return getDriver().findElement(By.xpath("//p[contains(text(),'Product Updated Successfully]"));}
    public WebElement availabilityforshop(){return getDriver().findElement(By.xpath("//label[@for='isAvailable']"));}

    //shipping details
    public WebElement sizedropdown(){return getDriver().findElement(By.xpath("//select[@id='size']"));}
    public WebElement sizesmall(){return getDriver().findElement(By.xpath("//option[@value='Small']"));}
    public WebElement sizemedium(){return getDriver().findElement(By.xpath("//option[@value='Medium']"));}
    public WebElement sizeslarge(){return getDriver().findElement(By.xpath("//option[@value='Large']"));}

    public WebElement packagingdropdown(){return getDriver().findElement(By.xpath("//select[@id='packaging']"));}
    public WebElement courierchoice(){return getDriver().findElement(By.xpath("//option[@value='airspeed']"));}
    public WebElement courierdropdown(){return getDriver().findElement(By.xpath("//select[@id='courier']"));}
    public WebElement packagingchoice(){return getDriver().findElement(By.xpath("//option[@value='pouch']"));}

    public WebElement typedropdown(){return getDriver().findElement(By.xpath("//input[@id='react-select-2-input']"));}
    public WebElement goldkaratsdropdown(){return getDriver().findElement(By.xpath("//input[@id='react-select-3-input']"));}
    public WebElement goldcolorsdropdown(){return getDriver().findElement(By.xpath("//input[@id='react-select-4-input']"));}
    public WebElement genderdropdown(){return getDriver().findElement(By.xpath("//input[@id='react-select-5-input']"));}
    public WebElement stonedropdown(){return getDriver().findElement(By.xpath("//input[@id='react-select-6-input']"));}
    public WebElement stonecolordropdown(){return getDriver().findElement(By.xpath("//input[@id='react-select-7-input']"));}
    public WebElement conditiondropdown(){return getDriver().findElement(By.xpath("//input[@id='react-select-8-input']"));}

    //merchant tab
    public WebElement viewmerchantbtn(){return getDriver().findElement(By.xpath("(//p[normalize-space()='View'])[1]"));}
    public WebElement editinfomerchant(){return getDriver().findElement(By.xpath("//p[@class=\"text-sm text-blue-500 hover:bg-slate-200 pl-2 pr-2 cursor-pointer\" and text()=\"Edit info\"]"));}
    public WebElement Statusdropdown(){return getDriver().findElement(By.xpath("(//input[@id='react-select-2-input'])[1]"));}
    public WebElement submitbtnmerchant(){return getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));}
    public WebElement editablemerchantbtn(){return getDriver().findElement(By.xpath("(//p[normalize-space()='View'])[8]"));}
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

    public WebElement mlshopjewleryconfirmation(){return getDriver().findElement(By.xpath("//div[contains(@class, 'border') and contains(@class, 'border-red-500') and contains(@class, 'bg-red-500') and contains(@class, 'text-white') and contains(@class, 'rounded-md') and contains(@class, 'p-3') and contains(@class, 'cursor-pointer') and contains(@class, 'text-center') and contains(@class, 'text-[14px]') and contains(@class, 'md:text-[12px]') and contains(text(), 'ML Shop Jewelry Store')]"));}
    public WebElement mercadodefrancisconfirmation(){return getDriver().findElement(By.xpath("//div[contains(@class, 'border') and contains(@class, 'border-red-500') and contains(@class, 'bg-red-500') and contains(@class, 'text-white') and contains(@class, 'rounded-md') and contains(@class, 'p-3') and contains(@class, 'cursor-pointer') and contains(@class, 'text-center') and contains(@class, 'text-[14px]') and contains(@class, 'md:text-[12px]') and contains(text(), 'Mercado de Francis')]"));}


        //image uploads
    public WebElement coverPhoto(){return  getDriver().findElement(By.id("cover-file"));}
    public WebElement imageContent(){return  getDriver().findElement(By.id("dropzone-file"));}
    public WebElement selectedCoverPhoto(){return getDriver().findElement(By.cssSelector("[alt='selectedCoverImage']"));}
    public WebElement inputRequiredText(){return getDriver().findElement(By.cssSelector("[class='inline-flex text-sm text-red-700 ml-3']"));}
    public WebElement selectedImageContent(){return getDriver().findElement(By.cssSelector("[class='flex flex-col items-center justify-center pt-2 pb-2 mx-3']"));}


    public WebElement Type(){return  getDriver().findElement(By.xpath("(//button[contains(., 'Necklace')])[1]"));}
    public WebElement eighteenk(){return  getDriver().findElement(By.xpath("//button[contains(., '18k')]"));}
    public WebElement whitegold(){return  getDriver().findElement(By.xpath("//button[contains(., 'White Gold')]"));}
    public WebElement mens(){return  getDriver().findElement(By.xpath("//button[contains(., 'Mens')]"));}
    public WebElement diamond(){return  getDriver().findElement(By.xpath("//button[contains(., 'Diamond')]"));}
    public WebElement red(){return  getDriver().findElement(By.xpath("//button[contains(., 'Red')]"));}
    public WebElement newcondition(){return  getDriver().findElement(By.xpath("//button[contains(., 'New')]"));}
    public WebElement Proceed(){return  getDriver().findElement(By.xpath("//button[contains(., 'Proceed')]"));}
    public WebElement Save(){return  getDriver().findElement(By.xpath("//button[contains(., 'Save')]"));}


   
}
