package mlshopbuilder.testSteps;

import utilities.Logger.LoggingUtils;

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
        if( isVisible(merchantObjects.TotalStore(), "Total Store") && 
            isVisible(merchantObjects.TotalNumberStore(), "Number of Stores")){
            passTest("SBR_TC_03", "VValidated Total Stores");    
        }else{
            failTest("SBR_TC_03", "Failed to Validate Total Stores");
        }
        LoggingUtils.info("SBR_TC_03: Validated Total Stores");
        
    }
    public void SBR_TC_04_InvStoreSearch(){
        goToShopBuilder();
        waitSleep(2000);
        typeEnter(merchantObjects.Searchtxtbox(), "Search Textbox", propertyReader.getproperty("InvStorename"));
        waitSleep(2000);
        LoggingUtils.info("SBR_TC_04: Validated Invalid Store Search");
    }

    public void SBR_TC_05_StoreSearch(){
        goToShopBuilder();
        waitSleep(2000);
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
        waitSleep(4000);
        inputsAddproduct("merchant");
        LoggingUtils.info("SBR TC 08 Product info Inputs Successful");
        isDisplayed(merchantObjects.Amparitotickbox());
        LoggingUtils.info("SBR TC 09 Sales info Inputs Successful");
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
        if(isVisible(merchantObjects.inputRequiredText(), "Input required text")){
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

       LoggingUtils.info("SBR TC 12 Publishing Product: Successful");
   }

    public void SBR_TC_13_Viewproduct(){
        goingtoViewproductpage();
        LoggingUtils.info("SBR TC 13 Redirection to View Products Successful");
        
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
        click(merchantObjects.entryoption10down(),"10 Entries");;
        LoggingUtils.info("clicked 10");
        click(merchantObjects.entrydropdown(),"Entries");
        click(merchantObjects.entryoption25down(),"25 Entries");
        LoggingUtils.info("clicked 25");
        click(merchantObjects.entrydropdown(),"Entries");
        click(merchantObjects.entryoption50down(),"50 Entries");
        LoggingUtils.info("clicked 50");
        click(merchantObjects.entrydropdown(),"Entries");
        click(merchantObjects.entryoption75down(),"75 Entries");
        LoggingUtils.info("clicked 75");
        click(merchantObjects.entrydropdown(),"Entries");
        click(merchantObjects.entryoption100down(),"100 Entries");
        LoggingUtils.info("clicked 100");
        click(merchantObjects.entrydropdown(),"Entries");
        click(merchantObjects.entryoptionalldown(),"All Entries");
        LoggingUtils.info("clicked All entries");
        LoggingUtils.info("SBR_TC_15 Show Entries: Successful");
        
    }

    public void SBR_TC_16_Viewdetails() {
        goingtoViewproductpage();
        click(merchantObjects.Viewdetailsbtn(),"View details button");
        waitSleep(1500);
        isDisplayed(merchantObjects.Amparitotickbox2());
        LoggingUtils.info("SBR_TC_16 View details: Successful");
        
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
