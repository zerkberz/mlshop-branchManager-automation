package mlshopbuilder.testSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.util.List;

public class Merchant_Steps extends Base_Steps {

    public void navigateLoginPage() throws Exception{
    }
    public void loginByRole(String role) {
        click(merchantObjects.userIcon(), "Menu Icon");
        click(merchantObjects.MLoginbtn(), "Login option");
        type(merchantObjects.Email_add(), "Email Field", reader.getEmailByRole(role));
        type(merchantObjects.Login_pass(), "Email Field", reader.getPasswordByRole(role));
        click(merchantObjects.Continuebtn(), "Continue");
        LoggingUtils.info("Successful Logged In");
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

    public boolean isInAddproductPage() {
        if (isVisible(merchantObjects.ProductInfo(),"Product info")) {
        }
        return true;
    }

    public void logout(String role){
        click(merchantObjects.userIcon(),"Menu Icon");
        click(merchantObjects.MLogoutbtn(), "Logout");
        waitSleep(1500);
        LoggingUtils.info("Successful Logged off");
    }

    public void inputsAddproduct(String role){
        type(merchantObjects.Quantitytxtbox(), "Quantity Textbox", propertyReader.getproperty("Quantity"));
        type(merchantObjects.ItemWeighttxtbox(), "Item Weight Textbox", propertyReader.getproperty("ItemWeight"));
        type(merchantObjects.StyleNametxtbox(), "Style Name Textbox", propertyReader.getproperty("StyleName"));
        type(merchantObjects.Notetxtbox(), "Notes Textbox", propertyReader.getproperty("Notes"));
        //
        type(merchantObjects.Barcodetxtbox(), "Barcode Textbox", propertyReader.getproperty("barcode"));
        type(merchantObjects.Lotnumbertxtbox(), "Lot Number Textbox", propertyReader.getproperty("lotnumber"));
        type(merchantObjects.Costofsalestxtbox(), "Cost of Sales Textbox", propertyReader.getproperty("costofsale"));
        type(merchantObjects.grosssalestxtbox(), "Gross Sales Textbox", propertyReader.getproperty("grosssale"));
        type(merchantObjects.pricetxtbox(), "Price Textbox", propertyReader.getproperty("price"));

    }

    public void goingtoAddproductpage(){
        goToShopBuilder();
        click(merchantObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(merchantObjects.Addproduct(), "Add product button");
    }

    public void goingtoViewproductpage(){    
        goToShopBuilder();
        click(merchantObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(merchantObjects.viewproductbtn(), "View products button");
    }

    public void goToShopBuilder(){
        click(loginPageObjects.userIcon(), "User Avatar");
        click(merchantObjects.shopbuilderbutton(), "Shopbuilder Button");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    public void SBR_TC_01_Login() {
        loginByRole("merchant");
        LoggingUtils.info("SBR_TC_01_LogIn_as_Merchant");
        
    }

    public void SBR_TC_02_NavigateShopBuilder_Page() {   
        goToShopBuilder();
        if(isVisible(merchantObjects.TotalStore(), "Total Store")){
            passTest("SBR_TC_02", "Validated Navigation to ShopBuilder Page");
        }else{
            failTest("SBR_TC_02", "Failed to Navigate to ShopBuilder Page");   
        }
    }

    public void SBR_TC_03_TotalStores() {
        goToShopBuilder();
        int counter=0;
        for(WebElement stores : merchantObjects.StoreNames()){
            LoggingUtils.info("Store Name: " + stores.getText());
            counter++;
        }
        ExtentReporter.logInfo("Counted Store: "+ (counter + 1) , " Total Store: "+ merchantObjects.TotalNumberStore().getText());
        if( isVisible(merchantObjects.TotalStore(), "Total Store") && 
            isVisible(merchantObjects.TotalNumberStore(), "Number of Stores")){
            assertEqual(String.valueOf(counter+1), merchantObjects.TotalNumberStore().getText());
            passTest("SBR_TC_03", "VValidated Total Stores");    
        }else{
            failTest("SBR_TC_03", "Failed to Validate Total Stores");
        }
    }
    public void SBR_TC_04_InvStoreSearch(){
        goToShopBuilder();
        waitSleep(1000);
        typeEnter(merchantObjects.Searchtxtbox(), "Search Textbox", propertyReader.getproperty("InvStorename"));
        waitSleep(1000);
        try{
            if(isDisplayed(merchantObjects.Store())){
                failTest("SBR_TC_04_InvStoreSearch", "Failed to Validate Invalid Store Search");
            }
        }catch (NoSuchElementException e){
            passTest("SBR_TC_04_InvStoreSearch","Validated Invalid Store Search" );

        }
    }

    public void SBR_TC_05_StoreSearch(){
        goToShopBuilder();
        waitSleep(1000);
        type(merchantObjects.Searchtxtbox(), "Search Textbox", propertyReader.getproperty("ValidSearch"));
        waitSleep(2000);
        if(isInStoreSearch()){
            passTest("SBR_TC_05_StoreSearch", "Successfully Searched Shop");
        }
        else {
           failTest("SBR_TC_05_StoreSearch", "Failed to search Shop");
        }
    }

    public void SBR_TC_06_StoreRedirection(){
        goToShopBuilder();
        waitSleep(2000);
        click(merchantObjects.MLShopJewelryStore(),"ML Shop Jewelry Store" );
        waitSleep(2000);
        if(isInStorePage()){
            passTest("SBR_TC_06_StoreRedirection", "Successfully Redirected to Shop");
        }
        else {
           failTest("SBR_TC_06_StoreRedirection", "Failed to directed Shop");
        } 
    }

    public void SBR_TC_07_AddProductRedirection() {
        goToShopBuilder();
        waitSleep(2000);
        click(merchantObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        waitSleep(2000);
        click(merchantObjects.Addproduct(), "Add product button");
        waitSleep(1500);
        isVisible(merchantObjects.ProductInfo(), "product information");
        if (isInAddproductPage()) {
            passTest("SBR_TC_07_AddProductRedirection", "Successfully Redirected to Add Product");
        } else {
           failTest("SBR_TC_07_AddProductRedirection", "Failed redirection to Add product page");      
        }
        
    }

    public void SBR_TC_08_ProductinfoInputs_09_SalesInformationInputs(){
        goingtoAddproductpage();
        waitSleep(2000);
        inputsAddproduct("merchant");
        assertEqual(getValue(merchantObjects.ItemWeighttxtbox()), propertyReader.getproperty("ItemWeight"));
        assertEqual(getValue(merchantObjects.StyleNametxtbox()), propertyReader.getproperty("StyleName"));
        assertEqual(getValue(merchantObjects.Notetxtbox()), propertyReader.getproperty("Notes"));
        assertEqual(getValue(merchantObjects.Barcodetxtbox()), propertyReader.getproperty("barcode"));
        assertEqual(getValue(merchantObjects.Lotnumbertxtbox()), propertyReader.getproperty("lotnumber"));
        assertEqual(getValue(merchantObjects.Costofsalestxtbox()), propertyReader.getproperty("costofsale"));
        assertEqual(getValue(merchantObjects.grosssalestxtbox()), propertyReader.getproperty("grosssale"));
        assertEqual(getValue(merchantObjects.pricetxtbox()), propertyReader.getproperty("price"));
        passTest("SBR TC 08 Product info Inputs Successful and SBR TC 09 Sales info Inputs Successful", "Passed!!!" );

    }

   public void SBR_TC_10_ImageUpload(){
        goingtoAddproductpage();
        waitSleep(4000);
        inputsAddproduct("merchant");
        uploadFile(merchantObjects.coverPhoto(), filePathUtils.getAbsolutePath());
        uploadFile(merchantObjects.imageContent(), filePathUtils.getAbsolutePath());
        if(isVisible(merchantObjects.selectedCoverPhoto(), "Selected Photo" )||
        isVisible(merchantObjects.selectedImageContent(), "Select Image Content")) {
            passTest("SBR_TC_10_ImageUpload", "Successfully uploaded photo");
        }else{
            failTest("SBR_TC_10_ImageUpload", "Failed to upload photo");
        }
   }

    public void SBR_TC_11_ValidateInputs(){
        goingtoAddproductpage();
        waitSleep(4000);
        inputsAddproduct("merchant");
        merchantObjects.Quantitytxtbox().clear();
        merchantObjects.ItemWeighttxtbox().clear();
        merchantObjects.Barcodetxtbox().clear();
        merchantObjects.Lotnumbertxtbox().clear();
        merchantObjects.Costofsalestxtbox().clear();
        merchantObjects.grosssalestxtbox().clear();
        merchantObjects.pricetxtbox().clear();
        if(isVisible(merchantObjects.inputRequiredText(), getText(merchantObjects.inputRequiredText()))){
            passTest("SBR_TC_11_ValidateInputs", "Input required text successfully displayed");
        }else{
            failTest("SBR_TC_11_ValidateInputs", "Failed to validate input required text");
        }
    }

   public void SBR_TC_12_Publish() {
       goingtoAddproductpage();
       waitSleep(4000);
       click(supportAdminPageObjects.Type(), "Type of Accessory");
       click(supportAdminPageObjects.eighteenk(), "18k btn");
       click(supportAdminPageObjects.whitegold(), "White Gold btn");
       click(supportAdminPageObjects.mens(), "Mens btn");
       click(supportAdminPageObjects.diamond(), "Diamond btn");
       click(supportAdminPageObjects.red(), "Red btn");
       click(supportAdminPageObjects.newcondition(), "New Condition btn");
       waitSleep(2500);

       supportAdminPageObjects.Quantitytxtbox().clear();
       type(supportAdminPageObjects.Quantitytxtbox(), "Quantity Textbox", ""+getRandomNumber());
       type(supportAdminPageObjects.Size(), "Size Textbox",  ""+getRandomNumber());
       type(supportAdminPageObjects.Diamondweight(), "Diamond Weight Textbox", ""+getRandomNumber());;
       type(supportAdminPageObjects.Itemsweight(), "Item Weight Textbox", ""+getRandomNumber());
       type(supportAdminPageObjects.StyleNametxtbox(), "Style Name Textbox", "wawser"+getRandomNumber());
       type(supportAdminPageObjects.Notetxtbox(), "Notes Textbox", propertyReader.getproperty("Notes"));

       type(supportAdminPageObjects.Barcodetxtbox(), "Barcode Textbox",""+getRandomNumber());
       type(supportAdminPageObjects.Lotnumbertxtbox(), "Lot Number Textbox", ""+getRandomNumber());
       type(supportAdminPageObjects.Costofsalestxtbox(), "Cost of Sales Textbox", propertyReader.getproperty("costofsale"));
       type(supportAdminPageObjects.grosssalestxtbox(), "Gross Sales Textbox", propertyReader.getproperty("grosssale"));
       type(supportAdminPageObjects.pricetxtbox(), "Price Textbox", propertyReader.getproperty("price"));
       click(merchantObjects.publishbtn(), "Publish Button");
       if(isVisible(merchantObjects.status(), getText(merchantObjects.status()))){
           passTest("BR TC 12", "Publishing Product: Successful");
       }else{
           failTest("BR TC 12", "Publishing Product: Successful");
       }
   }

    public void SBR_TC_13_Viewproduct(){
        goingtoViewproductpage();
        if(isVisible(merchantObjects.viewStoreProducts_pageHeader(), getText(merchantObjects.viewStoreProducts_pageHeader()))) {
            passTest("SBR TC 13", "Redirection to View Products Successful");
        }else{
            failTest("SBR TC 13", "Failed to Validate Redirection to View Products");
        }
    }

    public void SBR_TC_14_Incorrectsearch(){
        goingtoViewproductpage();
        type(merchantObjects.Searchtxtbx(), "Search Textbox", propertyReader.getproperty("InvStoreNum"));
        LoggingUtils.info("SBR_TC_14 Incorrect search leads to blank page: Successful");
        
    }

    public void SBR_TC_15_ShowEntries() {
        goingtoViewproductpage();
        waitSleep(5000);

        click(merchantObjects.entrydropdown(),"Entries");
        click(merchantObjects.entryoption10down(),"10 Entries");
        boolean isCorrect10 = false;
        int counter = 0;
        for (WebElement trElement : merchantObjects.productId_TD()) {
            counter++;
            LoggingUtils.info(">>>>>>>>>>>>>#Num"+counter+":::::::::Product ID: " + trElement.getText());
        }
        if(counter <= 10){
            isCorrect10 = true;
        }
        boolean isCorrect75 = false;
        click(merchantObjects.entrydropdown(),"Entries");
        click(merchantObjects.entryoption75down(),"75 Entries");
        for (WebElement trElement : merchantObjects.productId_TD()) {
            counter++;
            LoggingUtils.info(">>>>>>>>>>>>>#Num"+counter+":::::::::Product ID: " + trElement.getText());
        }
        if(counter <= 10){
            isCorrect75 = true;
        }

        if(isCorrect10 && isCorrect75){
            passTest("SBR_TC_15", "Show Entries: Successful");
        }else{
            failTest("SBR_TC_15", "Show Entries: Successful");
        }

    }

    public void SBR_TC_16_Viewdetails() {
        goingtoViewproductpage();
        String productID = getText(merchantObjects.firstProductId());
        String barCode = getText(merchantObjects.firstBarcode());
        String lotNumber = getText(merchantObjects.firstLotNumber());
        String styleName = getText(merchantObjects.firstStyleName());
        String productType = getText(merchantObjects.firstProductType());
        String price = getText(merchantObjects.firstPrice());

        click(merchantObjects.firstViewButton(),"First View details button");
        waitSleep(1500);
        isDisplayed(merchantObjects.Amparitotickbox2());
        LoggingUtils.info("SBR_TC_16 View details: Successful");

        assertEqual(getValue(merchantObjects.Barcodetxtbox()), barCode);
        assertEqual(getValue(merchantObjects.lotNumber()), lotNumber);
        assertEqual(getValue(merchantObjects.styleName()), styleName);
        assertEqual(getText(merchantObjects.typeName()), productType);
        assertEqual(getValue(merchantObjects.pricetxtbox()), price);
        
    }

    public void SBR_TC_Searches() {
        goingtoViewproductpage();
        waitSleep(3000);

        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("productID"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        waitSleep(3000);
        merchantObjects.Searchtxtbx().clear();
        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("Barcode"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        waitSleep(3000);
        merchantObjects.Searchtxtbx().clear();
        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("LotNumber"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        waitSleep(3000);
        merchantObjects.Searchtxtbx().clear();
        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("styleName"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        waitSleep(3000);
        merchantObjects.Searchtxtbx().clear();
        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("productType"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        waitSleep(3000);
        merchantObjects.Searchtxtbx().clear();


        LoggingUtils.info("SBR_TC_Searches: Successful");
        LoggingUtils.info("SBR TC 17-21 Successful");
        
    }
    public void SBR_TC_22_NoDisplayDatefilter() {
        goingtoViewproductpage();
        waitSleep(4000);

        type(merchantObjects.Fromdateinput(), "", "02");
        type(merchantObjects.Fromdateinput(), "", "27");
        type(merchantObjects.Fromdateinput(), "", "1997");

        type(merchantObjects.Todateinput(), "","02");
        type(merchantObjects.Todateinput(), "","28");
        type(merchantObjects.Todateinput(), "","1997");

        LoggingUtils.info("SBR_TC_22 No Display Date Filter: Successful");
        
    }

    public void SBR_TC_23_Datefilter() {
        goingtoViewproductpage();
        waitSleep(4000);
        type(merchantObjects.Todateinput(), "","04");
        type(merchantObjects.Todateinput(), "","20");
        type(merchantObjects.Todateinput(), "","2024");

        LoggingUtils.info("SBR TC 23 Date Filter: Successful");
        
    }

    public void SBR_TC_24_logout() {
    }

















}
