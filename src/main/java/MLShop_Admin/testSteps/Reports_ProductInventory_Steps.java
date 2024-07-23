package MLShop_Admin.testSteps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Reports_ProductInventory_Steps extends Base_Steps{
    //Methods
    public void loginByRole(String role) {
        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", reader.getEmailByRole(role));
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", reader.getPasswordByRole(role));
        click(adminLoginPageObjects.LoginButton_LoginPage(), "Login");
        LoggingUtils.info("Successful Logged In");
    }

    public void navigateToProductList(String role) {
        click(adminOrdersPageObjects.MLSHOPADMIN_Header(), "Header Logo Button");
        waitSleep(1000);
        click(adminReportsProductInventoryObjects.Reports_Sidebar(), "Reports Sidebar Button");
        waitSleep(1200);
        click(adminReportsProductInventoryObjects.ProductInventory_Sidebar(), "Product Inventorys Sidebar Button");
    }

    //For Log-In Only
    public void Admin_Login() {
        loginByRole("admin");

        if (isVisible(adminOrdersPageObjects.UserIcon_Header(), "User Icon") &&
                isVisible(adminOrdersPageObjects.Notification_Header(), "Notification Header") &&
                isVisible(adminOrdersPageObjects.MLSHOPADMIN_Header(), "ML Shop Admin Header") &&
                isVisible(adminOrdersPageObjects.MLHUILLIERSideBarLogo_Header(), "ML Logo") &&
                isVisible(adminOrdersPageObjects.TotalSales_Dashboard(), "Total Sales Graph") &&
                isVisible(adminOrdersPageObjects.ReturningCustomerRate_Dashboard(), "Returning Customer Rate Graph") &&
                isVisible(adminOrdersPageObjects.AverageOrderValue_Dashboard(), "Average Order Value Graph") &&
                isVisible(adminOrdersPageObjects.TotalOrders_Dashboard(), "Total Orders Graph") &&
                isVisible(adminOrdersPageObjects.TopProductsByUnitsSold_Dashboard(), "Top Products By Unit Sold Graph")) {
            ExtentReporter.logPass("Admin_Login", "Admin Log In: Successful");
            waitSleep(1000);
        } else {
            ExtentReporter.logFail("Admin_Login", "Admin Log In: Failed");
            Assert.fail("Failed Logging In.");
        }
    }
    //For Log-In Only


    //Test Cases

    //Search_001
    //API_001
    public void CategoryFilter_Search() {
        navigateToProductList("admin");

        //copy to all searches
        String CategoryFirstRow = getText(adminReportsProductInventoryObjects.Category_FirstRow());
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "" +CategoryFirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsProductInventoryObjects.Category_FirstRow()), CategoryFirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement categoryFilterList : adminReportsProductInventoryObjects.categoryList()){
            LoggingUtils.info("Category: " + getText(categoryFilterList));
            ctr++;
            if(ctr == 5){
                passTest("CategoryFilter_Search", "Category List is Visible");
                break;
            }
        }
        LoggingUtils.info("Category Search and Validation: Successful");
    }

    //API_002
    public void LotNumberFilter_Search() {
        navigateToProductList("admin");

        String LotNumber_FirstRow = getText(adminReportsProductInventoryObjects.LotNumber_FirstRow());
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "" +LotNumber_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsProductInventoryObjects.LotNumber_FirstRow()), LotNumber_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  lotNumberList : adminReportsProductInventoryObjects.lotnumberList()){
            LoggingUtils.info("Lot Number: " + getText(lotNumberList));
            ctr++;
            if(ctr == 5){
                passTest("LotNumberFilter_Search", "Lot Number List is Visible");
                break;
            }
        }
        LoggingUtils.info("Lot Number Search and Validation: Successful");
    }

    //API_003
    public void ProductTypeFilter_Search() {
        navigateToProductList("admin");

        String ProductType_FirstRow = getText(adminReportsProductInventoryObjects.ProductType_FirstRow());
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "" +ProductType_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsProductInventoryObjects.ProductType_FirstRow()), ProductType_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  productTypeList : adminReportsProductInventoryObjects.producttypeList()){
            LoggingUtils.info("Product Type: " + getText(productTypeList));
            ctr++;
            if(ctr == 5){
                passTest("ProductTypeFilter_Search", "Product Type List is Visible");
                break;
            }
        }
        LoggingUtils.info("Product Type Search and Validation: Successful");
    }

    //API_004
    public void SellerName_Search() {
        navigateToProductList("admin");

        String SellerName_FirstRow = getText(adminReportsProductInventoryObjects.SellerName_FirstRow());
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "" +SellerName_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsProductInventoryObjects.SellerName_FirstRow()), SellerName_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  sellerNameList : adminReportsProductInventoryObjects.sellerNameList()){
            LoggingUtils.info("Seller Name: " + getText(sellerNameList));
            ctr++;
            if(ctr == 5){
                passTest("SellerName_Search", "Seller Name List is Visible");
                break;
            }
        }
        LoggingUtils.info("Seller Name Search and Validation: Successful");
    }

    //API_005
    public void BarcodeSKU_Search() {
        navigateToProductList("admin");

        String BarcodeSKU_FirstRow = getText(adminReportsProductInventoryObjects.BarcodeSKU_FirstRow());
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "" +BarcodeSKU_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsProductInventoryObjects.BarcodeSKU_FirstRow()), BarcodeSKU_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  barcodeSKUList : adminReportsProductInventoryObjects.barcodeSKUList()){
            LoggingUtils.info("Barcode/SKU: " + getText(barcodeSKUList));
            ctr++;
            if(ctr == 5){
                passTest("BarcodeSKU_Search", "ALL Barcode/SKU List is Visible");
                break;
            }
        }
        LoggingUtils.info("ALL Barcode/SKU Search and Validation: Successful");
    }

    //API_006
    public void ProductID_Search() {
        navigateToProductList("admin");

        String ProductID_FirstRow = getText(adminReportsProductInventoryObjects.ProductID_FirstRow());
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "" +ProductID_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsProductInventoryObjects.ProductID_FirstRow()), ProductID_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  productIDList : adminReportsProductInventoryObjects.productIDList()){
            LoggingUtils.info("Product ID: " + getText(productIDList));
            ctr++;
            if(ctr == 5){
                passTest("ProductID_Search", "Product ID List is Visible");
                break;
            }
        }
        LoggingUtils.info("Product ID Search and Validation: Successful");
    }

    //API_007 //Not Applicable Yet
    public void Region_Search() {
        navigateToProductList("admin");

        String Region_FirstRow = getText(adminReportsProductInventoryObjects.Region_FirstRow());
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "" +Region_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsProductInventoryObjects.Region_FirstRow()), Region_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  regionList : adminReportsProductInventoryObjects.regionList()){
            LoggingUtils.info("Region: " + getText(regionList));
            ctr++;
            if(ctr == 5){
                passTest("Region_Search", "Region List is Visible");
                break;
            }
        }
        LoggingUtils.info("Region Search and Validation: Successful");
    }


    //Search_002
    //API_008
    public void InvalidCategoryFilter_Search() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "!@Watch@!MeNaeNae");
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "");
        waitSleep(4000);

        //List Validation
        int ctr = 0;
        for(WebElement  categoryFilterList : adminReportsProductInventoryObjects.categoryList()){
            LoggingUtils.info("Category: " + getText(categoryFilterList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidCategoryFilter_Search", "Category List is Visible");
                break;
            }
            else {
                passTest("InvalidCategoryFilter_Search", "Category List is not Visible");
            }
        }
        LoggingUtils.info("Invalid Category Search and Validation: Successful");
    }

    //API_009
    public void InvalidLotNumberFilter_Search() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "111110000@!");
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "");
        waitSleep(4000);

        //List Validation
        int ctr = 0;
        for(WebElement  lotNumberList : adminReportsProductInventoryObjects.lotnumberList()){
            LoggingUtils.info("Lot Number: " + getText(lotNumberList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidLotNumberFilter_Search", "Lot Number List is Visible");
                break;
            }
            else {
                passTest("InvalidLotNumberFilter_Search", "Lot Number List is not Visible");
            }
        }
        LoggingUtils.info("Invalid Lot Number Search and Validation: Successful");
    }

    //API_010
    public void InvalidProductTypeFilter_Search() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "!@R0lex@!21211");
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "");
        waitSleep(4000);

        //List Validation
        int ctr = 0;
        for(WebElement  productTypeList : adminReportsProductInventoryObjects.producttypeList()){
            LoggingUtils.info("Product Type: " + getText(productTypeList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidProductTypeFilter_Search", "Product Type List is Visible");
                break;
            }
            else {
                passTest("InvalidProductTypeFilter_Search", "Product Type List is not Visible");
            }
        }
        LoggingUtils.info("Invalid Product Type Search and Validation: Successful");
    }

    //API_011
    public void InvalidSellerName_Search() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "@!Francis@!");
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "");
        waitSleep(8000);

        //List Validation
        int ctr = 0;
        for(WebElement  sellerNameList : adminReportsProductInventoryObjects.sellerNameList()){
            LoggingUtils.info("Seller Name: " + getText(sellerNameList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidSellerName_Search", "Seller Name List is Visible");
                break;
            }
            else {
                passTest("InvalidSellerName_Search", "Seller Name List is not Visible");
            }
        }
        LoggingUtils.info("Invalid Seller Name Search and Validation: Successful");
    }

    //API_012
    public void InvalidBarcodeSKU_Search() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "413431235191@!");
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "");
        waitSleep(8000);

        //List Validation
        int ctr = 0;
        for(WebElement  barcodeSKUList : adminReportsProductInventoryObjects.barcodeSKUList()){
            LoggingUtils.info("Barcode/SKU: " + getText(barcodeSKUList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidBarcodeSKU_Search", "ALL Barcode/SKU List is Visible");
                break;
            }
            else {
                passTest("InvalidBarcodeSKU_Search", "ALL Barcode/SKU List is not Visible");
            }
        }
        LoggingUtils.info("Invalid ALL Barcode/SKU Search and Validation: Successful");
    }

    //API_013
    public void InvalidProductID_Search() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "@!P20240628164351890@!");
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "");
        waitSleep(4000);

        //List Validation
        int ctr = 0;
        for(WebElement  productIDList : adminReportsProductInventoryObjects.productIDList()){
            LoggingUtils.info("Product ID: " + getText(productIDList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidProductID_Search", "Product ID List is Visible");
                break;
            }
            else {
                passTest("InvalidProductID_Search", "Product ID List is not Visible");
            }
        }
        LoggingUtils.info("Invalid Product ID Search and Validation: Successful");
    }

    //API_014//Not Applicable Yet
    public void InvalidRegion_Search() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "HO@!");
        typeEnter(adminReportsProductInventoryObjects.Searchbar_ProductList(), "Searchbar", "");
        waitSleep(8000);

        //List Validation
        int ctr = 0;
        for(WebElement  regionList : adminReportsProductInventoryObjects.regionList()){
            LoggingUtils.info("Region: " + getText(regionList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidRegion_Search", "Region List is Visible");
                break;
            }
            else {
                passTest("InvalidRegion_Search", "Region List is not Visible");
            }
        }
        LoggingUtils.info("Invalid Region Search and Validation: Successful");
    }

    //Date_001
    // API_015
    public void Correct_DateRange() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Date_From(), "Date Picker: From", "2024-06-01");
        typeEnter(adminReportsProductInventoryObjects.Date_To(), "Date Picker: To", "2024-07-01");
        click(adminReportsProductInventoryObjects.Searchbar_ProductList(),"");
        waitSleep(4000);

        LoggingUtils.info("Date Range Testing");
        int ctr = 0;
        for(WebElement  dates : adminReportsProductInventoryObjects.dates()){
            LoggingUtils.info("Date: " + getText(dates));
            ctr++;
            if(ctr > 1){
                passTest("Correct_DateRange", "Date Range = Listed Dates");
                break;
            }
        }
    }

    //API_016
    public void Incorrect_DateRange() {
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Date_From(), "Date Picker: From", "1999-12-25");
        typeEnter(adminReportsProductInventoryObjects.Date_To(), "Date Picker: To", "2000-12-25");
        click(adminReportsProductInventoryObjects.Searchbar_ProductList(),"");
        waitSleep(4000);

        LoggingUtils.info("Date Range Testing");
        int ctr = 0;
        for(WebElement  dates : adminReportsProductInventoryObjects.dates()){
            LoggingUtils.info("Date: " + getText(dates));
            ctr++;
            if(ctr > 1){
                failTest("Incorrect_DateRange", "Date Range Has Listed Dates");
            }
            else {
                passTest("Incorrect_DateRange","Date Range Has No Listed Dates");
            }
        }
    }

    //Nav_001
    //API_017
    public void Pagination() {
        navigateToProductList("admin");

        scrollToBottomOfPageWEB();
        waitSleep(1000);
        click(adminReportsProductInventoryObjects.Next_Pagination(),"Next Page");
        waitSleep(1000);
//        scrollToBottomOfPageWEB();
//        click(adminReportsProductInventoryObjects.Next_Pagination(),"Next Page");
//        waitSleep(1000);
//        scrollToBottomOfPageWEB();
//        click(adminReportsProductInventoryObjects.Next_Pagination(),"Next Page");
//        waitSleep(1000);

        scrollToBottomOfPageWEB();
        click(adminReportsProductInventoryObjects.Previous_Pagination(),"Previous Page");
        waitSleep(1000);
        scrollToBottomOfPageWEB();
//        click(adminReportsProductInventoryObjects.Previous_Pagination(),"Previous Page");
//        waitSleep(1000);

        LoggingUtils.info("Pagination: Success");
    }

    //XPRT_001
    //API_018
    public void PDF_Export(){
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Date_From(), "Date Picker: From", "2024-06-01");
        typeEnter(adminReportsProductInventoryObjects.Date_To(), "Date Picker: To", "2024-07-01");
        click(adminReportsProductInventoryObjects.Searchbar_ProductList(),"");
        waitSleep(4000);

        click(adminReportsProductInventoryObjects.Export_PDF_Button(),"Export PDF button");
        waitSleep(4000);

        if (isFileExist("Product Inventory_7-16-2024 .pdf")){
            passTest("PDF_Export","PDF File Downloaded");
        }
    }

    //API_019
    public void Excel_Export(){
        navigateToProductList("admin");

        typeEnter(adminReportsProductInventoryObjects.Date_From(), "Date Picker: From", "2024-06-01");
        typeEnter(adminReportsProductInventoryObjects.Date_To(), "Date Picker: To", "2024-07-01");
        click(adminReportsProductInventoryObjects.Searchbar_ProductList(),"");
        waitSleep(4000);

        click(adminReportsProductInventoryObjects.Export_Excel_Button(),"Export PDF button");
        waitSleep(4000);

        if (isFileExist("Product Inventory_7-16-2024 .xlsx")){
            passTest("Excel_Export","PDF File Downloaded");
        }
    }

    //API_020
    public void YearlyExcel_Export(){
        navigateToProductList("admin");

        click(adminReportsProductInventoryObjects.Export_Button(),"Export: Yearly // Button");

        typeEnter(adminReportsProductInventoryObjects.Date_Year(), "Date Picker: From", "2024-06-01");
        typeEnter(adminReportsProductInventoryObjects.Date_Year2(), "Date Picker: To", "2024-07-01");
        click(adminReportsProductInventoryObjects.PopUp_Space(),"Empty Space");
        waitSleep(4000);

        click(adminReportsProductInventoryObjects.ExportALL_Button(),"Export Button");

        if (isFileExist("Product Inventory (Yearly)_7-16-2024 .xlsx")){
            passTest("YearlyExcel_Export","Excel File Downloaded");
        }
        waitSleep(4000);
    }
}