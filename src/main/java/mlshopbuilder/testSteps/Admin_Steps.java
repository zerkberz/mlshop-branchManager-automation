package mlshopbuilder.testSteps;

import mlshopbuilder.pageObject.SupportAdmin_PageObjects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.PropertyReader.propertyReader;
import utilities.Logger.LoggingUtils;

public class Admin_Steps extends Base_Steps {

    //Methods
    public void loginByRole(String role) {
        click(loginPageObjects.userIcon(), "Menu Icon");
        click(loginPageObjects.MLoginbtn(), "Login option");
        type(loginPageObjects.Email_add(), "Email Field", reader.getEmailByRole(role));
        type(loginPageObjects.Login_pass(), "Email Field", reader.getPasswordByRole(role));
        click(loginPageObjects.Continuebtn(), "Continue");
        LoggingUtils.info("Successful Logged In");
    }

    public void goToShopBuilder(String role){
        click(loginPageObjects.userIcon(), "User Avatar");
        click(adminPageObjects.shopbuilderbutton(), "Shopbuilder Button");
    }

    public void goingtoAddproductpage(String role){
        goToShopBuilder("admin");
        click(merchantObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(merchantObjects.Addproduct(), "Add product button");
    }

    public void goingtoViewproductpage(String role){
        goToShopBuilder("admin");
        click(merchantObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(merchantObjects.viewproductbtn(), "View products button");
    }

    public void goingtoViewDetailspage(String role){

        click(supportAdminPageObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(supportAdminPageObjects.viewproductbtn(), "View products button");
        click(supportAdminPageObjects.Editviewdetailsbtn(),"View Product Details");
    }

    public void dashboardnavigation (String role){
        click(supportAdminPageObjects.userIcon(), "Account Header");
        click(supportAdminPageObjects.dashboardbtn(),"Dashboard button");
    }

    public void merchantnavigation (String role){
        dashboardnavigation("supportadmin");
        click(supportAdminPageObjects.merchantsbtn(),"Merchant Button");
    }

    public void shopbuildernavigation (String role){
        click(supportAdminPageObjects.userIcon(), "Account Header");
        click(supportAdminPageObjects.shopbuilderbtn(),"Dashboard button");
    }

    public boolean isInStoreSearch() {
        if (isVisible(merchantObjects.StoreSearchWatches(),"Store Watches Search")) {
        }
        return true;
    }

    public boolean isInStorePage() {
        if (isVisible(merchantObjects.Addproduct(),"ML Shop Jewelry Store")) {
        }
        return true;
    }

    // Test Scripts
    public void SBA_TC_01_Login() {
        loginByRole("admin");

        LoggingUtils.info("SBA_TC_01_LogIn_as_Admin");
    }

    public void SBA_TC_02_ShopBuilderRedirection() {
        goToShopBuilder("admin");

        if(isDisplayed(adminPageObjects.totalstores())){
            passTest("SBA_TC_02", "Validated Navigation to ShopBuilder Page");
        }else{
            failTest("SBA_TC_02", "Failed to Navigate to ShopBuilder Page");
        }
    }

    public void SBA_TC_03_and_04_DashboardTotalStoreAndNewlyAddedStoreValidation() {
        dashboardnavigation("admin");

        isDisplayed(supportAdminPageObjects.newlyaddedstore());
        isDisplayed(supportAdminPageObjects.totalstorecount());
        waitSleep(1500);

        LoggingUtils.info("SBA TC 03 & 04: Total Store & Newly Added Store Validation: Success");
    }

    public void SBA_TC_05_and_06_ShopBuilderNavigation_TotalStoreCount() {
        goToShopBuilder("admin");

        if(isVisible(merchantObjects.TotalStore(), "Total Store")){
            passTest("SBA_TC_05", "Validated Navigation to ShopBuilder Page");
        }else{
            failTest("SBA_TC_05", "Failed to Navigate to ShopBuilder Page");
        }

        LoggingUtils.info("SBA TC 05 & 06: Total Store & Newly Added Store Validation: Success");
    }

    public void SBA_TC_07_InvalidSearches() {
        goToShopBuilder("admin");

        waitSleep(3000);
        typeEnter(supportAdminPageObjects.Searchtxtbox(), "Search Textbox", "watchzzz");
        waitSleep(1500);
        isDisplayed(supportAdminPageObjects.InvalidSearch());

        LoggingUtils.info("SBA TC 07: Invalid Store Search: Success");
    }

    public void SBA_TC_08_ValidSearches() {
        goToShopBuilder("admin");

        waitSleep(1500);
        typeEnter(supportAdminPageObjects.Searchtxtbox(), "Search Textbox", "watch");
        waitSleep(1500);
        isDisplayed(supportAdminPageObjects.StoreSearchWatches());

        LoggingUtils.info("SBA TC 07: Valid Store Search: Success");
    }

    public void SBA_TC_09_SelectedStoreRedirection() {
        goToShopBuilder("admin");

        waitSleep(2000);
        click(adminPageObjects.MLShopJewelryStore(),"ML Shop Jewelry Store" );
        waitSleep(2000);
        if(isInStorePage()){
            passTest("SBA_TC_09_SelectedStoreRedirection", "Redirection to Shop: Success");
        }
        else {
            failTest("SBA_TC_09_SelectedStoreRedirection", "Redirection: Failed");
        }

        LoggingUtils.info("SBA TC 09: Valid Store Search: Success");
    }

    //Remove Exit Btn if actual demo
    public void SBA_TC_10_AddStore() {
        goToShopBuilder("admin");

        click(adminPageObjects.addstorebtn(),"Add Store");
        type(adminPageObjects.storeName(),"Store Name","FranCheese and JustPear");
        type(adminPageObjects.descstore(),"Store Description","Cheesy diamond ang Pearfect Element");
//        click(adminPageObjects.submitbtn(),"Submit Button");
        click(adminPageObjects.exitbtn(),"Exit btn");

        LoggingUtils.info("SBA TC 10: Add Store: Success");
    }

    public void SBA_TC_11_AddCategory() {
        goToShopBuilder("admin");

        waitSleep(2000);
        click(adminPageObjects.Test(),"Test Store" );
        click(adminPageObjects.addcategory(),"Add Category Button" );
        type(adminPageObjects.categoryname(),"Category Name","L Boss");
        click(adminPageObjects.submitbtn(),"Submit Button");
        waitSleep(1500);
        isVisible(adminPageObjects.addedcategory(),"Added Store");

        LoggingUtils.info("SBA TC 11: Add Category: Success");
    }

    public void SBA_TC_12_HideShowCategories() {
        goToShopBuilder("admin");

        waitSleep(2000);
        click(adminPageObjects.Test(),"Test Store" );
        click(adminPageObjects.hideshowcategories(),"Hide/Show Category Button" );
        click(adminPageObjects.showone(),"Show button 1");
        click(adminPageObjects.showtwo(),"Show button 2");
        click(adminPageObjects.hideone(),"Hide button 1");
        click(adminPageObjects.hidetwo(),"Hide button 2");
        navigateBack();

        waitSleep(4000);
        click(adminPageObjects.hideshowcategories(),"Hide/Show Category Button" );
        click(adminPageObjects.showone(),"Show button 1");
        click(adminPageObjects.showtwo(),"Show button 2");
        click(adminPageObjects.hideone(),"Hide button 1");
        click(adminPageObjects.hidetwo(),"Hide button 2");

        LoggingUtils.info("SBA TC 12: Hide/Show Category: Success");
    }

    public void SBA_TC_13_AddType() {
        goToShopBuilder("admin");

        waitSleep(2000);
        click(adminPageObjects.Test(),"Test Store" );
        click(adminPageObjects.addtype(),"Add Type");
        type(adminPageObjects.typename(),"Type Name","You're My Type");
        click(adminPageObjects.submitbtn(),"Submit Button");
        waitSleep(3000);

        isDisplayed(adminPageObjects.yourmytype());

        LoggingUtils.info("SBA TC 13: Add Type: Success");
    }

    public void SBA_TC_14_SortPrice() {
        goToShopBuilder("admin");

        waitSleep(2000);
        click(adminPageObjects.Test(),"Test Store" );
        click(adminPageObjects.sortprice(),"Sort Price");
        type(adminPageObjects.sortname(),"Sort Name", "High to Low");
        click(adminPageObjects.submitbtn(),"Submit Button");

        waitSleep(3000);
        click(adminPageObjects.updatesortname(),"Update Sort Name");
        type(adminPageObjects.sortname(),"Sort Name", "Low to High");
        click(adminPageObjects.submitbtn(),"Submit Button");

        isVisible(adminPageObjects.hightolowvalidation(),"High to Low Validation");
        isVisible(adminPageObjects.lowtohighvalidation(),"Low to High Validation");

        LoggingUtils.info("SBA TC 14: Sort Price Functionalities: Success");
    }

    public void SBA_TC_15_Viewtoggling() {
        goToShopBuilder("admin");

        click(adminPageObjects.MLWatches(),"ML Watches Store" );
        waitSleep(3000);
        click(adminPageObjects.shoptoggle(),"View Logs toggle");
        waitSleep(3000);
        click(adminPageObjects.shoptogglev2(),"View Products toggle");

        LoggingUtils.info("SBA TC 15: View Toggling Functionalities: Success");
    }

    public void SBA_TC_16_ViewProduct() {
        goToShopBuilder("admin");

        click(adminPageObjects.MLWatches(),"ML Watches Store" );
        waitSleep(3000);
        click(adminPageObjects.display1(),"Item Select" );

        isDisplayed(adminPageObjects.modelname());
        isDisplayed(adminPageObjects.availablequanitity());
        isDisplayed(adminPageObjects.productnotes());
        isDisplayed(adminPageObjects.productsize());

        isDisplayed(adminPageObjects.allbarcode());
        isDisplayed(adminPageObjects.costofsales());
        isDisplayed(adminPageObjects.grossprice());
        isDisplayed(adminPageObjects.salesprice());

        LoggingUtils.info("SBA TC 16: View Product: Success");
    }

    public void SBA_TC_17_ViiewLogsFunctionalities() {
        goToShopBuilder("admin");

        click(adminPageObjects.MLWatches(),"ML Watches Store" );
        waitSleep(3000);
        click(adminPageObjects.shoptoggle(),"View Logs");

        selectByValue(adminPageObjects.dropdownLogs(),"added");
        selectByValue(adminPageObjects.dropdownLogs(),"updated");
        selectByValue(adminPageObjects.dropdownLogs(),"all");
        waitSleep(2500);

        click(adminPageObjects.idproductsearch(),"Search");
        type(adminPageObjects.idproductsearch(),"Search Textbox","P20230727163634354");
        isDisplayed(adminPageObjects.hypertextrolex());
        waitSleep(2500);
        adminPageObjects.idproductsearch().clear();
        waitSleep(2500);
        click(adminPageObjects.loadalllogs(),"Load All Logs Hypertext");

        LoggingUtils.info("SBA TC 17: View Logs Functionality: Success");
    }

//    public void SBA_TC_18_BannerFunctionality() {
//        goToShopBuilder("admin");
//
//
//        LoggingUtils.info("SBA TC 18: Banner Functionality: Success");
//    }

    public void SBA_TC_19_EditProfileFunctionalities() {
        goToShopBuilder("admin");

        click(adminPageObjects.MLWatches(), "ML Watches");
        click(supportAdminPageObjects.EditProfile(), "Edit Profile Button");
        waitSleep(2500);

        click(supportAdminPageObjects.Editname(), "Edit name Feature");
        waitSleep(2000);
        type(supportAdminPageObjects.Updatenametxtbox(),"Update Name textbox","Wow Nice");
        type(supportAdminPageObjects.Updatebiotextbox(),"Update Bio", "Nice it's working");
        click(supportAdminPageObjects.submitbutton(),"Submit Button");
        waitSleep(3000);
        isVisible(supportAdminPageObjects.changename(),"Changed Profile Name");

    //revert changes
        waitSleep(2000);
        click(supportAdminPageObjects.EditProfile(), "Edit Profile Button");
        type(supportAdminPageObjects.Updatenametxtbox(),"Update Name textbox","ML Watches");
        type(supportAdminPageObjects.Updatebiotextbox(),"Update Bio", "An intellectual is someone whose mind watches itself");
        click(supportAdminPageObjects.submitbutton(),"Submit Button");
        waitSleep(2100);
        isVisible(adminPageObjects.originalname(),"Original Name");
        LoggingUtils.info("Successfully Reverted Changes");


        LoggingUtils.info("SBA TC 19: Edit Profile Functionality: Success");
    }

    //change
//    public void SBA_TC_20() {
//        dashboardnavigation("admin");
//
//        //Add Sub Account
//        click(adminPageObjects.subacctbtn(),"Sub Accounts");
//        click(adminPageObjects.addaccountbtn(),"Add Sub Account");
//
//        waitSleep(2000);
//        type(adminPageObjects.namesub(),"Name","Jessie Mendiola");
//        type(adminPageObjects.emailsub(),"Email","esconomy.jessie6@mlhuillier.com");
//        type(adminPageObjects.passSub(),"Password","cadocoolboy");
//        type(adminPageObjects.repassSub(),"Re-enter Password","cadocoolboy");
//        waitSleep(2500);
//
//        click(adminPageObjects.mainaccttxtbox2(),"Dropdown");
//        waitSleep(2000);
//        arrowKeyDown(1);
//        waitSleep(2000);
//        arrowKeyUp(1);
//        waitSleep(2000);
//        click(adminPageObjects.submitbtn(),"Submit Button");
//        LoggingUtils.info("SBA TC 20: Sub Account Added: Success");
//        waitSleep(3500);
//
//        //Registering As merchant
//        click(adminPageObjects.registerasmerchantbtn(),"Edit Button");
//        waitSleep(1500);
//        click(adminPageObjects.registerAsmerchantbtn(),"Register Button");
//        LoggingUtils.info("Sub Account Added = Register As Merchant: Success");
//        waitSleep(3500);
//
//        //Deactivate and Activation of Merchant
//        click(adminPageObjects.deactivateacctSUBACCOUNT(),"Account to deactivate");
//        waitSleep(1500);
//        click(adminPageObjects.deactivatemerchant(),"Deactivate Merchant Button");
//        waitSleep(2000);
//        click(adminPageObjects.deactivateacctSUBACCOUNT(),"Account to deactivate");
//        waitSleep(1500);
//        click(adminPageObjects.activatemerchant(),"Activate Merchant Button");
//        LoggingUtils.info("Sub Account Added = Register As Merchant: Success");
//        waitSleep(3500);
//
//        //Edit Sub Acount
//        click(adminPageObjects.editbuttonSubacct3(),"Edit Button");
//        waitSleep(2000);
//        type(adminPageObjects.namesub(),"Name","Cadoodle");
//        type(adminPageObjects.emailsub(),"Email","francis.mercadudes@mlhuillier.com");
//        click(adminPageObjects.submitbtn(),"Submit Button");
//        //reverse
//        click(adminPageObjects.editbuttonSubacct3(),"Edit Button");
//        waitSleep(2000);
//        type(adminPageObjects.namesub(),"Name","RoginaTest");
//        type(adminPageObjects.emailsub(),"Email","rogina.rolloque@mlhuillier.com");
//        click(adminPageObjects.submitbtn(),"Submit Button");
//        LoggingUtils.info("SBA TC 22: Sub Account Added = Edit Sub Account Information: Success");
//
//
//        LoggingUtils.info("SBA TC 20: Edit Profile Functionality: Success");
//    }







}
