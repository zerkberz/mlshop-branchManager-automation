package MLShop_Admin.testSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Reports_SalesReport_Steps extends Base_Steps{

    //Methods
    public void loginByRole(String role) {
        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", reader.getEmailByRole(role));
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", reader.getPasswordByRole(role));
        click(adminLoginPageObjects.LoginButton_LoginPage(), "Login");
        LoggingUtils.info("Successful Logged In");
    }

    public void navigateToSalesReport(String role) {
        click(adminOrdersPageObjects.MLSHOPADMIN_Header(), "Header Logo Button");
        waitSleep(1000);
        click(adminReportsSalesReportObjects.Reports_Sidebar(), "Reports Sidebar Button");
        waitSleep(1200);
        click(adminReportsSalesReportObjects.SalesReport_Sidebar(), "Product Lists Sidebar Button");
    }

    //For Log-In Only
    public void Admin_Login() {
        loginByRole("admin");

        if (isVisible(adminLoginPageObjects.UserIcon_Header(), "User Icon") &&
                isVisible(adminLoginPageObjects.Notification_Header(), "Notification Header") &&
                isVisible(adminLoginPageObjects.MLSHOPADMIN_Header(), "ML Shop Admin Header") &&
                isVisible(adminLoginPageObjects.MLHUILLIERSideBarLogo_Header(), "ML Logo") &&
                isVisible(adminLoginPageObjects.TotalSales_Dashboard(), "Total Sales Graph") &&
                isVisible(adminLoginPageObjects.ReturningCustomerRate_Dashboard(), "Returning Customer Rate Graph") &&
                isVisible(adminLoginPageObjects.AverageOrderValue_Dashboard(), "Average Order Value Graph") &&
                isVisible(adminLoginPageObjects.TotalOrders_Dashboard(), "Total Orders Graph") &&
                isVisible(adminLoginPageObjects.TopProductsByUnitsSold_Dashboard(), "Top Products By Unit Sold Graph")) {
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
    //ASR_001
    public void SellerName_Search() {
        navigateToSalesReport("admin");

        String SellerName_FirstRow = getText(adminReportsSalesReportObjects.SellerName_FirstRow());
        typeEnter(adminReportsSalesReportObjects.Searchbar_ProductList(), "Searchbar", "" +SellerName_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsSalesReportObjects.SellerName_FirstRow()), SellerName_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement sellerNameList : adminReportsSalesReportObjects.sellerNameList()){
            LoggingUtils.info("Seller Name: " + getText(sellerNameList));
            ctr++;
            if(ctr == 5){
                passTest("SellerName_Search", "Seller Name List is Visible");
                break;
            }
        }
        LoggingUtils.info("Seller Name Search and Validation: Successful");
    }

    //ASR_002
    public void BarcodeSKU_Search() {
        navigateToSalesReport("admin");

        String BarcodeSKU_FirstRow = getText(adminReportsSalesReportObjects.BarcodeSKU_FirstRow());
        typeEnter(adminReportsSalesReportObjects.Searchbar_ProductList(), "Searchbar", "" +BarcodeSKU_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsSalesReportObjects.BarcodeSKU_FirstRow()), BarcodeSKU_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  barcodeSKUList : adminReportsSalesReportObjects.barcodeSKUList()){
            LoggingUtils.info("Barcode/SKU: " + getText(barcodeSKUList));
            ctr++;
            if(ctr == 5){
                passTest("BarcodeSKU_Search", "ALL Barcode/SKU List is Visible");
                break;
            }
        }
        LoggingUtils.info("ALL Barcode/SKU Search and Validation: Successful");
    }

    //ASR_003
    public void ProductID_Search() {
        navigateToSalesReport("admin");

        String ProductID_FirstRow = getText(adminReportsSalesReportObjects.ProductID_FirstRow());
        typeEnter(adminReportsSalesReportObjects.Searchbar_ProductList(), "Searchbar", "" +ProductID_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsSalesReportObjects.ProductID_FirstRow()), ProductID_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  productIDList : adminReportsSalesReportObjects.productIDList()){
            LoggingUtils.info("Product ID: " + getText(productIDList));
            ctr++;
            if(ctr == 5){
                passTest("ProductID_Search", "Product ID List is Visible");
                break;
            }
        }
        LoggingUtils.info("Product ID Search and Validation: Successful");
    }

    //ASR_004
    public void PaymentMethod_Search() {
        navigateToSalesReport("admin");

        String ModeOfPayment_FirstRow = getText(adminReportsSalesReportObjects.ModeOfPayment_FirstRow());
        typeEnter(adminReportsSalesReportObjects.Searchbar_ProductList(), "Searchbar", "" +ModeOfPayment_FirstRow);
        waitSleep(5000);
        assertEqual(getText(adminReportsSalesReportObjects.ModeOfPayment_FirstRow()), ModeOfPayment_FirstRow);

        //List Validation
        int ctr = 0;
        for(WebElement  modeofpaymentList : adminReportsSalesReportObjects.modeofpaymentList()){
            LoggingUtils.info("Payment Method: " + getText(modeofpaymentList));
            ctr++;
            if(ctr == 5){
                passTest("PaymentMethod_Search", "Payment Method List is Visible");
                break;
            }
        }
        LoggingUtils.info("Payment Method Search and Validation: Successful");
    }

    //ASR_005
    public void InvalidSellerName_Search() {
        navigateToSalesReport("admin");

        String SellerName_FirstRow = getText(adminReportsSalesReportObjects.SellerName_FirstRow());
        typeEnter(adminReportsSalesReportObjects.Searchbar_ProductList(), "Searchbar", "@!@!" +SellerName_FirstRow);
        waitSleep(5000);


        //List Validation
        int ctr = 0;
        for(WebElement  sellerNameList : adminReportsSalesReportObjects.sellerNameList()){
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

    //ASR_006
    public void InvalidBarcodeSKU_Search() {
        navigateToSalesReport("admin");

        String BarcodeSKU_FirstRow = getText(adminReportsSalesReportObjects.BarcodeSKU_FirstRow());
        typeEnter(adminReportsSalesReportObjects.Searchbar_ProductList(), "Searchbar", "@!@!" +BarcodeSKU_FirstRow);
        waitSleep(5000);

        //List Validation
        int ctr = 0;
        for(WebElement  barcodeSKUList : adminReportsSalesReportObjects.barcodeSKUList()){
            LoggingUtils.info("Barcode/SKU: " + getText(barcodeSKUList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidBarcodeSKU_Search", "Barcode/SKU List is Visible");
                break;
            }
            else {
                passTest("InvalidBarcodeSKU_Search", "Barcode/SKU List is not Visible");
            }
        }
        LoggingUtils.info("Invalid Barcode/SKU Search and Validation: Successful");
    }

    //ASR_007
    public void InvalidProductID_Search() {
        navigateToSalesReport("admin");

        String ProductID_FirstRow = getText(adminReportsSalesReportObjects.ProductID_FirstRow());
        typeEnter(adminReportsSalesReportObjects.Searchbar_ProductList(), "Searchbar", "@!@!" +ProductID_FirstRow);
        waitSleep(5000);

        //List Validation
        int ctr = 0;
        for(WebElement  productIDList : adminReportsSalesReportObjects.productIDList()){
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

    //ASR_008
    public void InvalidPaymentMethod_Search() {
        navigateToSalesReport("admin");

        String ModeOfPayment_FirstRow = getText(adminReportsSalesReportObjects.ModeOfPayment_FirstRow());
        typeEnter(adminReportsSalesReportObjects.Searchbar_ProductList(), "Searchbar", "@!@!" +ModeOfPayment_FirstRow);
        waitSleep(5000);

        //List Validation
        int ctr = 0;
        for(WebElement  modeofpaymentList : adminReportsSalesReportObjects.modeofpaymentList()){
            LoggingUtils.info("Product ID: " + getText(modeofpaymentList));
            ctr++;
            if(ctr > 1){
                failTest("InvalidPaymentMethod_Search", "Payment Method List is Visible");
                break;
            }
            else {
                passTest("InvalidPaymentMethod_Search", "Payment Method List is not Visible");
            }
        }
        LoggingUtils.info("Invalid Product ID Search and Validation: Successful");
    }

    //Date_001
    //ASR_009
    public void Correct_DateRange() {
        navigateToSalesReport("admin");

        typeEnter(adminReportsSalesReportObjects.Date_From(), "Date Picker: From", "2024-06-01");
        typeEnter(adminReportsSalesReportObjects.Date_To(), "Date Picker: To", "2024-07-01");
        click(adminReportsSalesReportObjects.Searchbar_ProductList(),"");
        waitSleep(4000);

        LoggingUtils.info("Date Range Testing");
        int ctr = 0;
        for(WebElement  dates : adminReportsSalesReportObjects.dates()){
            LoggingUtils.info("Date: " + getText(dates));
            ctr++;
            if(ctr > 1){
                passTest("Correct_DateRange", "Date Range = Listed Dates");
                break;
            }
        }
    }

    //ASR_010
    public void Incorrect_DateRange() {
        navigateToSalesReport("admin");

        typeEnter(adminReportsSalesReportObjects.Date_From(), "Date Picker: From", "1999-12-25");
        typeEnter(adminReportsSalesReportObjects.Date_To(), "Date Picker: To", "2000-12-25");
        click(adminReportsSalesReportObjects.Searchbar_ProductList(),"");
        waitSleep(4000);

        LoggingUtils.info("Date Range Testing");
        int ctr = 0;
        for(WebElement  orderNo : adminReportsSalesReportObjects.dates()){
            LoggingUtils.info("Date: " + getText(orderNo));
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
    //ASR_011
    public void Pagination() {
        navigateToSalesReport("admin");

        scrollToBottomOfPageWEB();
        waitSleep(1000);
        click(adminReportsSalesReportObjects.Next_Pagination(),"Next Page");
        waitSleep(1000);
//        scrollToBottomOfPageWEB();
//        click(adminReportsSalesReportObjects.Next_Pagination(),"Next Page");
//        waitSleep(1000);
//        scrollToBottomOfPageWEB();
//        click(adminReportsSalesReportObjects.Next_Pagination(),"Next Page");
//        waitSleep(1000);

        scrollToBottomOfPageWEB();
        click(adminReportsSalesReportObjects.Previous_Pagination(),"Previous Page");
        waitSleep(1000);
        scrollToBottomOfPageWEB();
//        click(adminReportsSalesReportObjects.Previous_Pagination(),"Previous Page");
//        waitSleep(1000);

        LoggingUtils.info("Pagination: Success");
    }

    //XPRT_001
    //ASR_012
    public void PDF_Export(){
        navigateToSalesReport("admin");

        typeEnter(adminReportsSalesReportObjects.Date_From(), "Date Picker: From", "2024-06-01");
        typeEnter(adminReportsSalesReportObjects.Date_To(), "Date Picker: To", "2024-07-01");
        click(adminReportsSalesReportObjects.Searchbar_ProductList(),"");
        waitSleep(4000);

        click(adminReportsSalesReportObjects.Export_PDF_Button(),"Export PDF button");
        waitSleep(4000);

        if (isFileExist("Sales Report_7-23-2024 .pdf")){
            passTest("PDF_Export","PDF File Downloaded");
        }
    }

    //ASR_013
    public void Excel_Export(){
        navigateToSalesReport("admin");

        typeEnter(adminReportsSalesReportObjects.Date_From(), "Date Picker: From", "2024-06-01");
        typeEnter(adminReportsSalesReportObjects.Date_To(), "Date Picker: To", "2024-07-01");
        click(adminReportsSalesReportObjects.Searchbar_ProductList(),"");
        waitSleep(4000);

        click(adminReportsSalesReportObjects.Export_Excel_Button(),"Export PDF button");
        waitSleep(4000);

        if (isFileExist("Sales Report_7-23-2024 .xlsx")){
            passTest("Excel_Export","PDF File Downloaded");
        }
    }

    //ASR_014
    public void YearlyExcel_Export(){
        navigateToSalesReport("admin");

        click(adminReportsSalesReportObjects.Export_Button(),"Export: Yearly // Button");

        typeEnter(adminReportsSalesReportObjects.Date_Year(), "Date Picker: From", "2024-06-01");
        typeEnter(adminReportsSalesReportObjects.Date_Year2(), "Date Picker: To", "2024-07-01");
        click(adminReportsSalesReportObjects.PopUp_Space(),"Empty Space");
        waitSleep(4000);

        click(adminReportsSalesReportObjects.ExportALL_Button(),"Export Button");

        if (isFileExist("Sales Report (Yearly)_7-23-2024 .xlsx")){
            passTest("YearlyExcel_Export","Excel File Downloaded");
        }
        waitSleep(4000);
    }





}
