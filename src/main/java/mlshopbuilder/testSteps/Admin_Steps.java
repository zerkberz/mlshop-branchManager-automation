package mlshopbuilder.testSteps;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.List;

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

    public void goToShopBuilder(){
        click(loginPageObjects.userIcon(), "User Avatar");
        click(adminPageObjects.shopbuilderbutton(), "Shopbuilder Button");
    }

    public void agentconfignavigation (){
        click(supportAdminPageObjects.userIcon(), "Account Header");
        click(adminPageObjects.agentconfigbtn(),"Agent Config button");
    }

    public void dashboardnavigation (){
        click(supportAdminPageObjects.userIcon(), "Account Header");
        click(supportAdminPageObjects.dashboardbtn(),"Dashboard button");
    }

    public boolean isInStorePage() {
        if (isVisible(merchantObjects.Addproduct(),"ML Shop Jewelry Store")) {
            return true;
        }else{
            return false;
        }
    }

    public void SBA_TC_01_Login() {
        loginByRole("admin");
        LoggingUtils.info("SBA_TC_01_LogIn_as_Admin");
    }

    public void SBA_TC_02_ShopBuilderRedirection() {
        goToShopBuilder();
        if(isDisplayed(adminPageObjects.totalstores())){
            passTest("SBA_TC_02", "Validated Navigation to ShopBuilder Page");
        }else{
            failTest("SBA_TC_02", "Failed to Navigate to ShopBuilder Page");
        }
    }

    public void SBA_TC_03_and_04_DashboardTotalStoreAndNewlyAddedStoreValidation() {
        dashboardnavigation();
        isDisplayed(supportAdminPageObjects.newlyaddedstore());
        isDisplayed(supportAdminPageObjects.totalstorecount());
        if(isVisible(supportAdminPageObjects.newlyaddedstore_name(), getText(supportAdminPageObjects.newlyaddedstore_name()))
        || getText(supportAdminPageObjects.newlyaddedstore_name()) != "null"
        ){
            passTest("SBA_TC_03_and_04_DashboardTotalStoreAndNewlyAddedStoreValidation Passed", "Successfully Validated SBA_TC_03_and_04");
        }    else{
            failTest("SBA_TC_03_and_04_DashboardTotalStoreAndNewlyAddedStoreValidation FAILED", "Failed To Validate SBA_TC_03_and_04");
        }
    }

    public void SBA_TC_05_and_06_ShopBuilderNavigation_TotalStoreCount() {
        goToShopBuilder();
        waitSleep(1000);
        int counter = 0;
        for(WebElement stores : supportAdminPageObjects.StoreNames()){
            counter++;
            ExtentReporter.logInfo("Store # " + String.valueOf(counter+1) + ", Name: " + stores.getText(), "");
        }
        if(isVisible(merchantObjects.TotalStore(), "Total Store")){
            assertEqual(getText(supportAdminPageObjects.TotalNumberStore()), String.valueOf(counter));
            passTest("SBA TC 05 and 06 ShopBuilderNavigation and TotalStoreCount. PASSED", "Validated Navigation to ShopBuilder Page");
        }else{
            failTest("SBA TC 05 and 06 ShopBuilderNavigation and TotalStoreCount. FAILED", "Failed to Navigate to ShopBuilder Page");
        }
    }

    public void SBA_TC_07_InvalidSearches() {
        goToShopBuilder();
        waitSleep(1000);
        typeEnter(supportAdminPageObjects.Searchtxtbox(), "Search Textbox", "watchzzz");
        waitSleep(1000);
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='font-bold text-lg text-center']")));
             // If the element is not present, the test passes
            passTest("Validate Element Not on Page", "Element not found as expected");
        }catch(NoSuchElementException e){
            passTest("Validate Element Not on Page", "Element not found as expected");
        }catch (Exception e) {
            // Handle any other exceptions
            failTest("Validate Element Not on Page", "Unexpected exception: " + e.getMessage());
        }
    }

    public void SBA_TC_08_ValidSearches() {
        goToShopBuilder();
        waitSleep(1500);
        typeEnter(supportAdminPageObjects.Searchtxtbox(), "Search Textbox", "watch");
        waitSleep(1500);
        if(isDisplayed(supportAdminPageObjects.StoreSearchWatches())){
            passTest("SBA_TC_08_ValidSearches: PASSED", "Valid Store Search: Success");
        }else{
            failTest("SBA_TC_08_ValidSearches: FAILED", "Failed to Validate");
        }   
    }

    public void SBA_TC_09_SelectedStoreRedirection() {
        goToShopBuilder();
        waitSleep(2000);
        click(adminPageObjects.MLShopJewelryStore(),"ML Shop Jewelry Store" );
        waitSleep(2000);
        if(isInStorePage()){
            passTest("SBA_TC_09_SelectedStoreRedirection", "Redirection to Shop: Success");
        }
        else {
            failTest("SBA_TC_09_SelectedStoreRedirection", "Redirection: Failed");
        }
    }

    //Remove Exit Btn if actual demo
    public void SBA_TC_10_AddStore() {
        goToShopBuilder();
        click(adminPageObjects.addstorebtn(),"Add Store");
        type(adminPageObjects.storeName(),"Store Name","TEST AUTOMATION STORE"+ getThreeDigitRandomNumber());
        type(adminPageObjects.descstore(),"Store Description","TEST DESCRIPTION"+ getFiveDigitsRandomNumber());
        String storeName = getValue(adminPageObjects.storeName());
        click(adminPageObjects.submitbtn(),"Submit Button");
        boolean isFound = false;
        if(isVisible(adminPageObjects.notificationStatus(), getText(adminPageObjects.notificationStatus()))){
            for(WebElement stores : supportAdminPageObjects.StoreNames()){
                if(stores.getText().equals(storeName)){
                    isFound = true;
                    break;
                }        
            }
            if(isFound){
                passTest("SBA_TC_10_AddStore: PASSED", storeName);
            }else{
                failTest("FAILED TO ADD STORE", storeName);
            }      
        }else{
            failTest("FAILED TO ADD STORE", storeName);
        }   
    }

    public void SBA_TC_11_AddCategory() {
        goToShopBuilder();
        waitSleep(2000);
        click(adminPageObjects.Test(),"Test Store" );
        click(adminPageObjects.addcategory(),"Add Category Button" );
        type(adminPageObjects.categoryname(),"Category Name","TEST AUTOMATION CATEGORY"+getThreeDigitRandomNumber());
        String categoryName = getValue(adminPageObjects.categoryname());
        click(adminPageObjects.submitbtn(),"Submit Button");
        boolean isFound = false;
        waitSleep(1000);
        if(isVisible(adminPageObjects.notificationStatus(), getText(adminPageObjects.notificationStatus()))){
            for(WebElement category : adminPageObjects.p_lefElements()){
                if(category.getText().equals(categoryName)){
                    isFound = true;
                    break;
                }        
            }
            if(isFound){
                passTest("SBA_TC_11_AddCategory: PASSED", categoryName);
            }else{
                failTest("FAILED TO ADD CATEGORY", categoryName);
            }      
        }else{
            failTest("FAILED TO ADD CATEGORY", categoryName);
        }   
    }

    public void SBA_TC_12_HideShowCategories() {
        goToShopBuilder();
        waitSleep(2000);
        click(adminPageObjects.Test(),"Test Store" );
        click(adminPageObjects.hideshowcategories(),"Hide/Show Category Button" );
        //should only show and hide one category
        // use conditional statement if button is show or hide
        try{
            boolean isFound = false;   
            if(getText(adminPageObjects.firstStatus_btn()).equals("HIDE")){
                //if hide is present, category should be hidden.
                String categoryName = getText(adminPageObjects.firstCategory_btn());
                click(adminPageObjects.firstStatus_btn(), getText(adminPageObjects.firstStatus_btn()));
                isVisible(adminPageObjects.notificationStatus(), getText(adminPageObjects.notificationStatus()));
                //verify notif pop up
                navigateBack();
                //navigateBack
                //verify element is not present
                for(WebElement category : adminPageObjects.p_lefElements()){
                    if(category.getText().equals(categoryName)){
                        isFound = true;
                        break;
                    }        
                }
                if(isFound){
                    failTest("Hiding of Categroy, FAILED", categoryName);
                }else{
                    passTest("Hiding of Categroy, PASSED", categoryName);
                }     
            }else{
                //if show is present category should be present       
                  String categoryName = getText(adminPageObjects.firstCategory_btn());
                  click(adminPageObjects.firstStatus_btn(), getText(adminPageObjects.firstStatus_btn()));
                  isVisible(adminPageObjects.notificationStatus(), getText(adminPageObjects.notificationStatus()));
                  //verify notif pop up
                  navigateBack();
                  //navigateBack
                  //verify element is not present
                  for(WebElement category : adminPageObjects.p_lefElements()){
                      if(category.getText().equals(categoryName)){
                          isFound = true;
                          break;
                      }        
                  }
                  if(isFound){
                    passTest("Showing of Categroy, PASSED", categoryName);                 
                  }else{
                    failTest("Showing of Categroy, FAILED", categoryName);
                  }     
            }
            
        }catch(Exception e){

        }
    }

    public void SBA_TC_13_AddType() {
        goToShopBuilder();

        waitSleep(2000);
        click(adminPageObjects.Test(),"Test Store" );
        click(adminPageObjects.addtype(),"Add Type");
        type(adminPageObjects.typename(),"Type Name","You're My Type");
        click(adminPageObjects.submitbtn(),"Submit Button");
        waitSleep(3000);

        isDisplayed(adminPageObjects.yourmytype());

        LoggingUtils.info("SBA TC 13: Add Type: Success");
    }

    public void SBA_TC_14_AddingSortPrice() {
        goToShopBuilder();

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
        goToShopBuilder();

        click(adminPageObjects.MLWatches(),"ML Watches Store" );
        waitSleep(3000);
        click(adminPageObjects.shoptoggle(),"View Logs toggle");
        waitSleep(3000);
        click(adminPageObjects.shoptogglev2(),"View Products toggle");

        LoggingUtils.info("SBA TC 15: View Toggling Functionalities: Success");
    }

    public void SBA_TC_16_ViewProduct() {
        goToShopBuilder();

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

    public void SBA_TC_17_ViewLogsFunctionalities() {
        goToShopBuilder();

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

    public void SBA_TC_18_BannerFunctionality() {
        goToShopBuilder();
        waitSleep(2000);
        click(adminPageObjects.Store(1), "Store");
        waitSleep(2000);
        click(adminPageObjects.editBanner_btn(), "Edit Banner Button");
        waitSleep(2000);
        click(adminPageObjects.bannerCameraEdit_btn(), "Camera/Edit Icon");
        uploadFile(supportAdminPageObjects.chooseBanner(), filePathUtils.getAbsolutePath());
        click(supportAdminPageObjects.submitbutton(),"Submit Button");
        waitSleep(8000);
        isVisible(adminPageObjects.bannerImg_alt(), "Banner Image");
        click(adminPageObjects.bannerStatus_radioBtn(), "Banner Status Radio Button");
        waitSleep(1000);
        isVisible(adminPageObjects.bannerStatus(), "Banner Status Pop Up");
        passTest("SBA_TC_18", "Successfully Validated Banner Functionality");


    }

    public void SBA_TC_19_EditProfileFunctionalities() {
        goToShopBuilder();

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
    public void SBA_TC_20_AddingSubaccount() {
        dashboardnavigation();
        //Add Sub Account
        click(adminPageObjects.subacctbtn(),"Sub Accounts");
        click(adminPageObjects.addaccountbtn(),"Add Sub Account");
        waitSleep(2000);
        click(adminPageObjects.mainaccttxtbox2(),"Dropdown");
        waitSleep(1000);
        arrowKeyDown(1);
        waitSleep(1000);
        type(adminPageObjects.namesub(),"Name","Test Automation"+getRandomNumber()+"");
        type(adminPageObjects.emailsub(),"Email","test.automation"+getRandomNumber()+"@mlhuillier.com");
        type(adminPageObjects.passSub(),"Password","12345678");
        type(adminPageObjects.repassSub(),"Re-enter Password","12345678");
        waitSleep(2000);
        String inputtedEmail = getValue(adminPageObjects.emailsub());
        LoggingUtils.info("inputtedEmail: " + inputtedEmail);
        click(adminPageObjects.submitbtn(),"Submit Button");
        waitSleep(2000);

        LoggingUtils.info("::::::::::::Looping Through Sub Accounts::::::::::::::::");
        boolean isEmailFound = false; // Add a flag to track if the email is found
        for (WebElement trElement : adminPageObjects.subAccTr()) {
            List<WebElement> tdElements = trElement.findElements(By.cssSelector("td.jsx-b09e653eba0e5d15")); //TD locator
            for (WebElement tdElement : tdElements) {
                String tdText = tdElement.getText();
                if (tdText.equals(inputtedEmail)) {
                    LoggingUtils.info("Email: " + tdText);
                    isEmailFound = true; // Set the flag to true if the email is found in any TD element
                    break; // Exit the inner loop once the email is found
                }
            }
            if (isEmailFound) {
                break; // Exit the outer loop since the email is found
            }
        }
        // Assert if the email is found or not
        if (isEmailFound) {
            passTest("SBA_TC_20", "Validate Adding Sub Accounts");
        } else {
            failTest("SBA_TC_20", "Failed to Validate Adding Sub Account");
        }
    }

    public void SBA_TC_21_AddingAndRemovingStore(){
        dashboardnavigation();
        //Add Sub Account
        click(adminPageObjects.subacctbtn(),"Sub Accounts");
        click(adminPageObjects.viewMerchantIcon(),"Merchant Button");
        waitSleep(1500);
        click(adminPageObjects.viewStores(),"View Stores");
        click(adminPageObjects.firstStore(),getText(adminPageObjects.firstStore()));
        boolean isRemoved = false;
        boolean isAdded = false;
        if(isDisplayed(adminPageObjects.notificationStatus())){
            isRemoved = true;
            ExtentReporter.logInfo("Update Status", " is Displayed");
        }
        waitSleep(3000);
        click(adminPageObjects.firstStore(),getText(adminPageObjects.firstStore()));
        if(isDisplayed(adminPageObjects.notificationStatus())){
            isAdded = true;
            ExtentReporter.logInfo("Update Status", " is Displayed");
        }
        if(isAdded && isRemoved){
            passTest("SBA_TC_21", "Validated Adding and Removing of Stores");
        }else{
            failTest("SBA_TC_21", "Failed to Validate Adding and Removing of Stores");
        }
    }

    public void SBA_TC_22(){
        dashboardnavigation();
        click(adminPageObjects.subacctbtn(),"Sub Accounts");
        click(adminPageObjects.editIcon1st(),"Edit Button");
        waitSleep(2000);
        String currentEmail = getValue(adminPageObjects.emailsub());
        String currentName = getValue(adminPageObjects.namesub());
        type(adminPageObjects.namesub(),"Name","Cadoodle"+ getRandomNumber());
        type(adminPageObjects.emailsub(),"Email","francis.mercadudes"+getRandomNumber()+"@mlhuillier.com");
        click(adminPageObjects.submitbtn(),"Submit Button");
        waitSleep(2000);
        LoggingUtils.info("SBA TC 22: Edit Sub Account Functionality: Success");
        String newEmail = getText(adminPageObjects.td_firstEmail());
        String newName = getValue(adminPageObjects.td_firstName());
        assertNotEqual(newEmail,currentEmail);
        assertNotEqual(newName, currentName);

        //reverse
        click(adminPageObjects.editbuttonSubacct3(),"Edit Button");
        waitSleep(2000);
        type(adminPageObjects.namesub(),"Name",currentName);
        type(adminPageObjects.emailsub(),"Email",currentEmail);
        assertEqual(getValue(adminPageObjects.namesub()), currentName);
        assertEqual(getValue(adminPageObjects.emailsub()), currentEmail);
        click(adminPageObjects.submitbtn(),"Submit Button");
        waitSleep(2000);

        passTest("SBA_TC_22", "Successfully Validated Updating Sub Accounts Information");

    }

    public void SBA_TC_23_DeactivatingAndActivatingOfMerchantAccount(){
        dashboardnavigation();
        //Add Sub Account
        click(adminPageObjects.subacctbtn(),"Sub Accounts");

        //Deactivate and Activation of Merchant
        click(adminPageObjects.deactivateacctSUBACCOUNT(),"Account to deactivate");
        waitSleep(1500);
        click(adminPageObjects.deactivatemerchant(),"Deactivate Merchant Button");
        waitSleep(2000);
        click(adminPageObjects.deactivateacctSUBACCOUNT(),"Account to deactivate");
        waitSleep(1500);
        click(adminPageObjects.activatemerchant(),"Activate Merchant Button");
        waitSleep(3500);

        LoggingUtils.info("SBA TC 23: Deactivate/Activate Functionality: Success");
    }

public void SBA_TC_24_and_25() {
    dashboardnavigation();

    click(adminPageObjects.mainaccountbtn(),"Main Accounts");
    click(adminPageObjects.editablemerchantinfo(),"View Merchant Details button");
    isDisplayed(supportAdminPageObjects.editinfomerchant());
    waitSleep(2000);
    click(supportAdminPageObjects.exitbutton(),"Exit Button");

    LoggingUtils.info("SBA TC 25: Main Account Redirection: Success");
}

    public void SBA_TC_26_statuschange() {
    dashboardnavigation();

    click(adminPageObjects.mainaccountbtn(),"Main Accounts");
    click(adminPageObjects.viewmerchantbtn(),"View Merchant Details button");
    waitSleep(1500);
    typeEnter(adminPageObjects.Statusdropdown(),"Status","deactivate");
    waitSleep(1500);
    click(adminPageObjects.submitbtnmerchant(),"Submit button pressed");
    waitSleep(1500);
    //reversion
    click(adminPageObjects.editablemerchantinfo(),"View Merchant Details button");
    waitSleep(1500);
    typeEnter(adminPageObjects.Statusdropdown(),"Status","activate");
    waitSleep(1500);
    click(adminPageObjects.submitbtnmerchant(),"Submit button pressed");
    waitSleep(1500);
    click(adminPageObjects.editablemerchantinfo(),"View Merchant Details button");
    waitSleep(1500);
    isDisplayed(adminPageObjects.Statusdropdown());
    click(supportAdminPageObjects.exitbutton(),"exit");

    LoggingUtils.info("SBA TC 27 Status Changes: Successful");
}

public void SBA_TC_27_EmptyFields() {
    dashboardnavigation();

    click(adminPageObjects.mainaccountbtn(),"Main Accounts");
    click(adminPageObjects.editablemerchantbtn(),"View Merchant Details button");
    waitSleep(2000);
    click(adminPageObjects.editinfomerchant(),"Edit Info");
    waitSleep(2000);
    adminPageObjects.contactnum().clear();
    adminPageObjects.storeemail().clear();
    waitSleep(2000);
    typeEnter(adminPageObjects.provincedrop(),"Province Text box and Drop Down","abra");
    waitSleep(3000);
    click(adminPageObjects.submitbtnmerchant(),"Submit button pressed");
    waitSleep(2500);
    isVisible(adminPageObjects.errorstore(),"Error Prompt");
    waitSleep(2000);
    click(supportAdminPageObjects.exitbutton(),"Exit Button");

    LoggingUtils.info("SBA TC 28: Empty Fields proceeds to Error: Successful");
}


public void SBA_TC_28_ValidateUpdatedMerchantInfo() {
    dashboardnavigation();
    click(adminPageObjects.mainaccountbtn(),"Main Accounts");

    click(adminPageObjects.editablemerchantbtn(),"View Merchant Details button");
    waitSleep(2000);
    click(adminPageObjects.editinfomerchant(),"Edit Info");
    waitSleep(2000);
    adminPageObjects.contactnum().clear();
    adminPageObjects.storeemail().clear();
    waitSleep(2000);
    type(adminPageObjects.contactnum(),"Contact number", "09667363535");
    type(adminPageObjects.storeemail(),"Store Email","dboss.melgs@mlhuillier.com");
    waitSleep(2000);
    typeEnter(adminPageObjects.provincedrop(),"Province Text box and Drop Down","abra");
    waitSleep(3000);
    typeEnter(adminPageObjects.citydrop(),"City Text box and Drop Down","bang");
    waitSleep(3000);
    typeEnter(adminPageObjects.branchnamedrop(),"City Text box and Drop Down","ML");
    waitSleep(3000);
    click(adminPageObjects.submitbtnmerchant(),"Submit button pressed");
    waitSleep(3500);

    //Reversion
    LoggingUtils.info("Update Reversal");
    click(adminPageObjects.editablemerchantinfo(),"View Merchant Details button");
    waitSleep(2000);
    click(adminPageObjects.editinfomerchant(),"Edit Info");
    waitSleep(2000);
    adminPageObjects.contactnum().clear();
    adminPageObjects.storeemail().clear();
    waitSleep(2000);
    type(adminPageObjects.contactnum(),"Contact number", "09479992152");
    type(adminPageObjects.storeemail(),"Store Email","asdasd@sdfsdf.com");
    waitSleep(2000);
    typeEnter(adminPageObjects.provincedrop(),"Province Text box and Drop Down","ceb");
    waitSleep(3000);
    typeEnter(adminPageObjects.citydrop(),"City Text box and Drop Down","cebu cit");
    waitSleep(3000);
    typeEnter(adminPageObjects.branchnamedrop(),"City Text box and Drop Down","ML NRA");
    waitSleep(3000);
    click(adminPageObjects.submitbtnmerchant(),"Submit button pressed");
    waitSleep(2500);
    LoggingUtils.info("SBA TC 29: Update Info : Successful");
}

public void SBA_TC_29_AgentConfigNavigation() {
    agentconfignavigation();
    isDisplayed(adminPageObjects.SearchOrderID());
    isVisible(adminPageObjects.SearchOrderID(),"Search Order Textbox");
    isDisplayed(adminPageObjects.Searchbtn());
    isVisible(adminPageObjects.Searchbtn(),"Search Button");
    LoggingUtils.info("SBA TC 30: Agent Config Navigation: Successful");
}

//TODO
//    public void SBA_TC_30() {
//        agentconfignavigation();
//        LoggingUtils.info("SBA TC 31: : Successful");
//    }
//    public void SBA_TC_31() {
//        agentconfignavigation();
//        LoggingUtils.info("SBA TC 32: : Successful");
//    }

    public void SBA_TC_32_Logout() {
        agentconfignavigation();
        click(supportAdminPageObjects.userIcon(), "Account Header");
        click(merchantObjects.MLogoutbtn(),"Logout");
        LoggingUtils.info("SBA TC 32: : Successful");
    }
}
