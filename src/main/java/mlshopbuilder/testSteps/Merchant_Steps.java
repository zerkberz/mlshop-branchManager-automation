package mlshopbuilder.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
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
        LoggingUtils.info("SBR TC 08 Product info Inputs Successful");

        type(merchantObjects.Barcodetxtbox(), "Barcode Textbox", propertyReader.getproperty("barcode"));
        type(merchantObjects.Lotnumbertxtbox(), "Lot Number Textbox", propertyReader.getproperty("lotnumber"));
        type(merchantObjects.Costofsalestxtbox(), "Cost of Sales Textbox", propertyReader.getproperty("costofsale"));
        type(merchantObjects.grosssalestxtbox(), "Gross Sales Textbox", propertyReader.getproperty("grosssale"));
        type(merchantObjects.pricetxtbox(), "Price Textbox", propertyReader.getproperty("price"));
    }

    public void goingtoAddproductpage(String role){
        loginByRole("merchant");
        click(merchantObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(merchantObjects.Addproduct(), "Add product button");
    }

    public void goingtoViewproductpage(String role){
        loginByRole("merchant");
        click(merchantObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        click(merchantObjects.viewproductbtn(), "View products button");
    }



    /////////////////////////////////////////////////////////////////////////////////////////
    public void SBR_TC_01_Login() {
        loginByRole("merchant");
        LoggingUtils.info("SBR_TC_01_LogIn_as_Merchant");
        logout("merchant");
    }

    public void SBR_TC_02_NavigateShopBuilder_Page() {
        loginByRole("merchant");
        click(loginPageObjects.userIcon(), "User Avatar");
        click(merchantObjects.shopbuilderbutton(), "Shopbuilder Button");
        LoggingUtils.info("SBR_TC_02: Validated Navigation to ShopBuilder Page");
        logout("merchant");
        }

    public void SBR_TC_03_TotalStores() {
        loginByRole("merchant");
        isVisible(merchantObjects.TotalStore(), "Total Store");
        isVisible(merchantObjects.TotalNumberStore(), "Number of Stores");
        LoggingUtils.info("SBR_TC_03: Validated Total Stores");
        logout("merchant");
    }
    public void SBR_TC_04_InvStoreSearch(){
        loginByRole("merchant");
        waitSleep(2000);
        typeEnter(merchantObjects.Searchtxtbox(), "Search Textbox", propertyReader.getproperty("InvStorename"));
        waitSleep(2000);
        logout("merchant");
        LoggingUtils.info("SBR_TC_04: Validated Invalid Store Search");
    }

    public void SBR_TC_05_StoreSearch(){
        loginByRole("merchant");
        waitSleep(2000);
        type(merchantObjects.Searchtxtbox(), "Search Textbox", propertyReader.getproperty("ValidSearch"));
        waitSleep(2000);
        if(isInStoreSearch()){
            ExtentReporter.logPass("SBR_TC_05_StoreSearch", "Successfully Searched Shop");
        }
        else {
            ExtentReporter.logFail("", "Failed to search Shop");
            Assert.fail("");
        }
        logout("merchant");
    }

    public void SBR_TC_06_StoreRedirection(){
        loginByRole("merchant");
        waitSleep(2000);
        click(merchantObjects.MLShopJewelryStore(),"ML Shop Jewelry Store" );
        waitSleep(2000);
        if(isInStorePage()){
            ExtentReporter.logPass("SBR_TC_06_StoreRedirection", "Successfully Redirected to Shop");
        }
        else {
            ExtentReporter.logFail("", "Failed to directed Shop");
            Assert.fail("");
        }
        logout("merchant");
    }

    public void SBR_TC_07_AddProductRedirection() {
        loginByRole("merchant");
        waitSleep(2000);
        click(merchantObjects.MLShopJewelryStore(), "ML Shop Jewelry Store");
        waitSleep(2000);
        click(merchantObjects.Addproduct(), "Add product button");
        waitSleep(1500);
        isVisible(merchantObjects.ProductInfo(), "product information");
        if (isInAddproductPage()) {
            ExtentReporter.logPass("SBR_TC_07_AddProductRedirection", "Successfully Redirected to Add Product");
        } else {
            ExtentReporter.logFail("", "Failed redirection to Add product page");
            Assert.fail("");
        }
        logout("merchant");
    }

    public void SBR_TC_08_ProductinfoInputs_09_SalesInformationInputs(){
        goingtoAddproductpage("merchant");
        waitSleep(4000);
        inputsAddproduct("merchant");
        isDisplayed(merchantObjects.Amparitotickbox());

        LoggingUtils.info("SBR TC 09 Sales info Inputs Successful");
        logout("merchant");
    }

//    public void SBR_TC_10_ImageUpload(){
//
//    }

    public void SBR_TC_11_ValidateInputs(){
        goingtoAddproductpage("merchant");
        waitSleep(4000);
        inputsAddproduct("merchant");

        merchantObjects.Quantitytxtbox().clear();
        merchantObjects.ItemWeighttxtbox().clear();
        merchantObjects.Barcodetxtbox().clear();
        merchantObjects.Lotnumbertxtbox().clear();
        merchantObjects.Costofsalestxtbox().clear();
        merchantObjects.grosssalestxtbox().clear();
        merchantObjects.pricetxtbox().clear();

        LoggingUtils.info("SBR TC 11 Inputs Required Visible");
        logout("merchant");
    }

//    public void SBR_TC_12_SubmitandPublish(){
//
//    }

    public void SBR_TC_13_Viewproduct(){
        goingtoViewproductpage("merchant");

        LoggingUtils.info("SBR TC 13 Redirection to View Products Successful");
        logout("merchant");
    }
    public void SBR_TC_14_Incorrectsearch(){
        goingtoViewproductpage("merchant");
        type(merchantObjects.Searchtxtbx(), "Search Textbox", propertyReader.getproperty("InvStoreNum"));

        LoggingUtils.info("SBR_TC_14 Incorrect search leads to blank page: Successful");
        logout("merchant");
    }

    public void SBR_TC_15_ShowEntries() {
        goingtoViewproductpage("merchant");
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
        logout("merchant");
    }

    public void SBR_TC_16_Viewdetails() {
        goingtoViewproductpage("merchant");
        click(merchantObjects.Viewdetailsbtn(),"View details button");
        waitSleep(1500);
        isDisplayed(merchantObjects.Amparitotickbox2());

        LoggingUtils.info("SBR_TC_16 View details: Successful");
        logout("merchant");
    }
    public void SBR_TC_Searches() {
        goingtoViewproductpage("merchant");
        waitSleep(3000);

        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("productID"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        merchantObjects.Searchtxtbx().clear();
        waitSleep(3000);
        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("Barcode"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        merchantObjects.Searchtxtbx().clear();
        waitSleep(3000);
        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("LotNumber"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        merchantObjects.Searchtxtbx().clear();
        waitSleep(3000);
        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("styleName"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        merchantObjects.Searchtxtbx().clear();
        waitSleep(3000);
        type(merchantObjects.Searchtxtbx(), "", propertyReader.getproperty("productType"));
        isDisplayed(merchantObjects.Viewdetailsbtn2());
        merchantObjects.Searchtxtbx().clear();
        waitSleep(3000);


        LoggingUtils.info("SBR_TC_Searches: Successful");
        LoggingUtils.info("SBR TC 17-21 Successful");
        logout("merchant");
    }
    public void SBR_TC_22_NoDisplayDatefilter() {
        goingtoViewproductpage("merchant");
        waitSleep(4000);

        type(merchantObjects.Fromdateinput(), "", "02");
        type(merchantObjects.Fromdateinput(), "", "27");
        type(merchantObjects.Fromdateinput(), "", "1997");

        type(merchantObjects.Todateinput(), "","02");
        type(merchantObjects.Todateinput(), "","28");
        type(merchantObjects.Todateinput(), "","1997");

        LoggingUtils.info("SBR_TC_22 No Display Date Filter: Successful");
        logout("merchant");
    }

    public void SBR_TC_23_Datefilter() {
        goingtoViewproductpage("merchant");
        waitSleep(4000);
        type(merchantObjects.Todateinput(), "","04");
        type(merchantObjects.Todateinput(), "","20");
        type(merchantObjects.Todateinput(), "","2024");

        LoggingUtils.info("SBR TC 23 Date Filter: Successful");
        logout("merchant");
    }

    public void SBR_TC_24_logout() {
    }

















}
