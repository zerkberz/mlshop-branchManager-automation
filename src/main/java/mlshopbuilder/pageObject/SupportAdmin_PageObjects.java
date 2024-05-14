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


   
}
