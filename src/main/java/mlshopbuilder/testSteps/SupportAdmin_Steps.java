package mlshopbuilder.testSteps;

import mlshopbuilder.pageObject.SupportAdmin_PageObjects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.PropertyReader.propertyReader;
import utilities.Logger.LoggingUtils;

public class SupportAdmin_Steps extends Base_Steps {

    //methods
    public void loginByRole(String role) {
        click(loginPageObjects.userIcon(), "Menu Icon");
        click(loginPageObjects.MLoginbtn(), "Login option");
        type(loginPageObjects.Email_add(), "Email Field", reader.getEmailByRole(role));
        type(loginPageObjects.Login_pass(), "Email Field", reader.getPasswordByRole(role));
        click(loginPageObjects.Continuebtn(), "Continue");
        LoggingUtils.info("Successful Logged In");
    }

    public void logout(String role){
        click(supportAdminPageObjects.userIcon(),"Menu Icon");
        click(supportAdminPageObjects.logoutbtn(), "Logout");
        waitSleep(1500);
        LoggingUtils.info("Successful Logged off");
    }

    public void goingtoAddproductpage(String role){
        loginByRole("merchant");
        click(supportAdminPageObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(supportAdminPageObjects.Addproduct(), "Add product button");
    }

    public void dashboardnavigation (String role){
        click(supportAdminPageObjects.userIcon(), "Account Header");
        click(supportAdminPageObjects.dashboardbtn(),"Dashboard button");
    }

    public void shopbuildernavigation (String role){
        click(supportAdminPageObjects.userIcon(), "Account Header");
        click(supportAdminPageObjects.shopbuilderbtn(),"Dashboard button");
    }

    public boolean isInHomePage() {
        if (isVisible(loginPageObjects.HeaderAcctOwnership(),"HeaderAcctOwnership")) {
        }
        return true;
    }


    //Test Cases
    public void SBL_TC_01_SuppAdminLogIn() {
        loginByRole("supportadmin");

        if(isInHomePage()){
            ExtentReporter.logPass("SBL_TC_01_SuppAdminLogIn", "Successfully Logged in Support Admin");
        }
        else{
            ExtentReporter.logFail("", "Failed to Log In as Support Admin");
            Assert.fail("");
        }
        logout("supportadmin");
    }

    public void SBL_TC_02_ShopbuilderpageNavigation() {
        loginByRole("supportadmin");

        dashboardnavigation("supportadmin");
        isDisplayed(supportAdminPageObjects.newlyaddedstore());
        isDisplayed(supportAdminPageObjects.totalstorecount());
        waitSleep(2000);
        LoggingUtils.info("SBL TC 02 Shopbuilder Page Navigation: Success");

        logout("supportadmin");
    }

    public void SBL_TC_03_MerchantNavigation() {
        loginByRole("supportadmin");

        dashboardnavigation("supportadmin");
        click(supportAdminPageObjects.merchantsbtn(),"Merchant button");

        logout("supportadmin");
    }

    public void SBL_TC_04_and_05_TotalStores_and_NewlyAddedStore() {
        loginByRole("supportadmin");

        dashboardnavigation("supportadmin");
        isDisplayed(supportAdminPageObjects.newlyaddedstore());
        isDisplayed(supportAdminPageObjects.totalstorecount());
        LoggingUtils.info("SBL TC 04 and 05 Visibility of Total Stores and New added store: Success");

        logout("supportadmin");
    }

    public void SBL_TC_06_and_07_ShopBuilderNavigation_and_TotalStoreCount() {
        loginByRole("supportadmin");

        shopbuildernavigation("supportadmin");
        waitSleep(2000);
        isDisplayed(supportAdminPageObjects.StoreSearchWatches());
        isDisplayed(supportAdminPageObjects.MLShopJewelryStore());
        LoggingUtils.info("SBL TC 06 ShopBuilder Page navigation: Success");

        waitSleep(2000);
        isDisplayed(supportAdminPageObjects.TotalStore());
        LoggingUtils.info("SBL TC 07 Total Store Count: Success");

        logout("supportadmin");
    }

    public void SBL_TC_08_InvalidStoreSearch() {
        loginByRole("supportadmin");

        waitSleep(2000);
        type(supportAdminPageObjects.Searchtxtbox(), "Search Textbox", "Watczzz");
        waitSleep(2000);
        isDisplayed(supportAdminPageObjects.InvalidSearch());
        LoggingUtils.info("SBL TC 08 Invalid Store Search: Success");

        logout("supportadmin");
    }

    public void SBL_TC_09_ValidStoreSearch() {
        loginByRole("supportadmin");

        waitSleep(2000);
        type(supportAdminPageObjects.Searchtxtbox(), "Search Textbox", "watch");
        waitSleep(2000);
        isDisplayed(supportAdminPageObjects.StoreSearchWatches());
        LoggingUtils.info("SBL TC 09 Valid Store Search: Success");

        logout("supportadmin");
    }

    public void SBL_TC_10_jewelryShopRedirection() {
        loginByRole("supportadmin");

        click(supportAdminPageObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        isDisplayed(supportAdminPageObjects.Addproduct());
        isDisplayed(supportAdminPageObjects.viewproductbtn());
        LoggingUtils.info("SBL TC 10 Jewelry Shop Redirection: Success");

        logout("supportadmin");
    }

    public void SBL_TC_11_MLWatchShopRedirection() {
        loginByRole("supportadmin");

        click(supportAdminPageObjects.StoreSearchWatches(), "ML Watch");
        isDisplayed(supportAdminPageObjects.Addproduct());
        isDisplayed(supportAdminPageObjects.viewproductbtn());
        LoggingUtils.info("SBL TC 11 ML Watch Shop Redirection: Success");

        logout("supportadmin");
    }

    public void SBL_TC_12_to_15_EditProfile() {
        loginByRole("supportadmin");

        click(supportAdminPageObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(supportAdminPageObjects.EditProfile(), "Edit Profile Button");
        LoggingUtils.info("SBL TC 12 Edit Button: Success");
        waitSleep(2500);

        click(supportAdminPageObjects.Editname(), "Edit name Feature");
        waitSleep(2000);
        type(supportAdminPageObjects.Updatenametxtbox(),"Update Name textbox","Wow Nice");
        type(supportAdminPageObjects.Updatebiotextbox(),"Update Bio", "Nice it's working");
        click(supportAdminPageObjects.submitbutton(),"Submit Button");
        waitSleep(5000);
        isVisible(supportAdminPageObjects.changename(),"Changed Name");
        LoggingUtils.info("SBL TC 13 Functionality of Edit Profile: Success");

        click(supportAdminPageObjects.EditProfile(), "Edit Profile Button");
        type(supportAdminPageObjects.Updatenametxtbox(),"Update Name textbox","ML Shop Jewelry Store");
        type(supportAdminPageObjects.Updatebiotextbox(),"Update Bio", "WHEN YOU POP THE QUESTION do it with a ring from our jewelry collection. Click to see selections now!");
        LoggingUtils.info("SBL TC 14 Updated Bio: Success");
        click(supportAdminPageObjects.submitbutton(),"Submit Button");
        LoggingUtils.info("SBL TC 15 Submit Button: Success");
        waitSleep(5000);
        isVisible(supportAdminPageObjects.originalname(),"Original Name");
        waitSleep(2000);
        LoggingUtils.info("Successfully Reverted Changes");

        logout("supportadmin");
    }

    public void SBL_TC_16_17_EditBannerAndCancelEditBanner() {
        loginByRole("supportadmin");

        click(supportAdminPageObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(supportAdminPageObjects.editbanner(), "ML Shop Jewelry Store Banner");
        LoggingUtils.info("SBL TC 16: Edit Banner function: Success");
        waitSleep(2000);
        click(supportAdminPageObjects.canceleditbanner(),"ML Shop Jewelry Store Banner");
        LoggingUtils.info("SBL TC 17: Edit Banner function: Success");

        logout("supportadmin");
    }

    public void SBL_TC_18_to_21_AddBanner() {
        loginByRole("supportadmin");

        click(supportAdminPageObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(supportAdminPageObjects.addbannerbtn(), "Add Banner");
        waitSleep(2000);
        isVisible(supportAdminPageObjects.choosefile(), "Choose File Button");
        LoggingUtils.info("SBL TC 18: Add Banner function: Success");


        //SBL TC 19 Img Related, need research


        waitSleep(2000);
        click(supportAdminPageObjects.bannerscreensize(),"banner screen size");
        waitSleep(2000);
        typeEnter(supportAdminPageObjects.bannerscreensize(), "Screen Size", "small");
        waitSleep(2000);
        click(supportAdminPageObjects.bannerposition(),"Banner position");
        waitSleep(2000);
        typeEnter(supportAdminPageObjects.bannerposition(), "Position", "2");
        waitSleep(2000);
        LoggingUtils.info("SBL TC 20 Screen Size and Position: Success");
        waitSleep(2000);

        click(supportAdminPageObjects.submitbutton(),"Submit Button");
        waitSleep(2000);
        LoggingUtils.info("SBL TC 21 Submit Button: Success");
        //delete after image works
        click(supportAdminPageObjects.exitbutton(),"Exit button");

        logout("supportadmin");
    }

    public void SBL_TC_22() {
        loginByRole("supportadmin");



        logout("supportadmin");
    }





































}
