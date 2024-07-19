package MLShop_Admin.testSteps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Orders_Steps extends Base_Steps {

    //Methods
    public void loginByRole(String role) {
        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", reader.getEmailByRole(role));
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", reader.getPasswordByRole(role));
        click(adminLoginPageObjects.LoginButton_LoginPage(), "Login");
        LoggingUtils.info("Successful Logged In");
    }

    public void navigateToOrders(String role) {
        click(adminOrdersPageObjects.MLSHOPADMIN_Header(), "Header Logo Button");
        waitSleep(1000);
        click(adminOrdersPageObjects.Orders_Sidebar(), "Orders Sidebar Button");
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
            ExtentReporter.logPass("", "Admin Log In: Successful");
            waitSleep(1000);
        } else {
            ExtentReporter.logFail("", "Admin Log In: Failed");
            Assert.fail("Failed Logging In.");
        }
    }
    //For Log-In Only



    //Test Cases
    //Ent_001 > AO_001
    public void NumberOfEntries() {
        navigateToOrders("admin");

        waitSleep(2000);
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"5");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"25");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"50");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"75");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"100");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"-1");

        //Parallel Testing
        LoggingUtils.info("Initiating Parallel Testing");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"25");
        int ctr = 0;
        for(WebElement  orderNo : adminOrdersPageObjects.orderNumbers()){
            LoggingUtils.info("Order Number: " + getText(orderNo));
            ctr++;
            if(ctr == 25){
                passTest("Number Of Entries", "Parallel Test to Entry and Count: Passed");
                break;
            }
        }
    }

    //Comp_001 > AO_002
    public void DataComparison_Orders() {
        navigateToOrders("admin");

        //Data Gathering
        //First Row Data
        getText(adminOrdersPageObjects.firstOrderNumber());
        getText(adminOrdersPageObjects.firstOrderDate());
        getText(adminOrdersPageObjects.firstOrderCustomerName());
        getText(adminOrdersPageObjects.firstOrderQuantity());
        getText(adminOrdersPageObjects.firstOrderTotalAmountPaid());
//        getValue(adminOrdersPageObjects.firstOrderSellerName());
        getText(adminOrdersPageObjects.firstOrderModeOfPayment());
        getText(adminOrdersPageObjects.firstOrderStatus());

        //Place into String
        String firstOrderNumber = getText(adminOrdersPageObjects.firstOrderNumber());
        String firstOrderDate = getText(adminOrdersPageObjects.firstOrderDate());
        String firstOrderCustomerName = getText(adminOrdersPageObjects.firstOrderCustomerName());
        String firstOrderQuantity = getText(adminOrdersPageObjects.firstOrderQuantity());
        String firstOrderTotalAmountPaid = getText(adminOrdersPageObjects.firstOrderTotalAmountPaid());
        String firstOrderModeOfPayment = getText(adminOrdersPageObjects.firstOrderModeOfPayment());
        String firstOrderStatus = getText(adminOrdersPageObjects.firstOrderStatus());

        //Navigate to View Order Page
        click(adminOrdersPageObjects.ViewDetailsFirstRow_Button(),"First Row View Order Details");
        getText(adminOrdersPageObjects.OrderNumber_ViewDetails());
        getText(adminOrdersPageObjects.OrderDate_ViewDetails());
        getText(adminOrdersPageObjects.CustomerName_ViewDetails());
        getText(adminOrdersPageObjects.TotalAmountPaid_ViewDetails());
        getText(adminOrdersPageObjects.Quantity_ViewDetails());
//        getValue(adminOrdersPageObjects.SellerName_ViewDetails());
        getText(adminOrdersPageObjects.ModeOfPayment_ViewDetails());
        getText(adminOrdersPageObjects.OrderStatus_ViewDetails());

        //Check If equal
        assertEqual(getText(adminOrdersPageObjects.OrderNumber_ViewDetails()), firstOrderNumber);
        assertEqual(getText(adminOrdersPageObjects.OrderDate_ViewDetails()), firstOrderDate);
        assertEqual(getText(adminOrdersPageObjects.CustomerName_ViewDetails()), firstOrderCustomerName);
        assertEqual(getText(adminOrdersPageObjects.Quantity_ViewDetails()), firstOrderQuantity);
        assertEqual(getText(adminOrdersPageObjects.TotalAmountPaid_ViewDetails()), firstOrderTotalAmountPaid);
        assertEqual(getText(adminOrdersPageObjects.ModeOfPayment_ViewDetails()), firstOrderModeOfPayment);
        assertEqual(getText(adminOrdersPageObjects.OrderStatus_ViewDetails()), firstOrderStatus);

        LoggingUtils.info("Data Comparison Test: Success");
    }


    //Nav_001 > AO_003
    public void Pagination() {
        navigateToOrders("admin");

        waitSleep(1000);
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"25");

        waitSleep(1300);
        click(adminOrdersPageObjects.Next_Pagination(),"Next Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Next_Pagination(),"Next Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Next_Pagination(),"Next Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Next_Pagination(),"Next Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Next_Pagination(),"Next Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Next_Pagination(),"Next Page");
        waitSleep(400);

        click(adminOrdersPageObjects.Previous_Pagination(),"Previous Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Previous_Pagination(),"Previous Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Previous_Pagination(),"Previous Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Previous_Pagination(),"Previous Page");
        waitSleep(400);
        click(adminOrdersPageObjects.Previous_Pagination(),"Previous Page");
        waitSleep(400);

        LoggingUtils.info("Pagination: Success");
    }

    //Dtls_001 > AO_004
    public void ViewDetails_Check() {
        navigateToOrders("admin");

        click(adminOrdersPageObjects.ViewDetailsFirstRow_Button(),"View Order Details");

       if (isVisible(adminOrdersPageObjects.OrderNumber_ViewDetails(),"Order Number")&&
        isVisible(adminOrdersPageObjects.OrderDate_ViewDetails(),"Order Date")&&
        isVisible(adminOrdersPageObjects.CustomerName_ViewDetails(),"Customer Name")&&
        isVisible(adminOrdersPageObjects.TotalAmountPaid_ViewDetails(),"Total Amount Paid")&&
        isVisible(adminOrdersPageObjects.Quantity_ViewDetails(),"Quantity")&&
        isVisible(adminOrdersPageObjects.ModeOfPayment_ViewDetails(),"Mode of Payment")&&
        isVisible(adminOrdersPageObjects.OrderStatus_ViewDetails(),"Order Status")){
            ExtentReporter.logPass("AO_004", "View Details: Successful");
        }
       else {
           ExtentReporter.logFail("AO_004", "View Details: Failed");
           Assert.fail("Failed Viewing Details.");
       }
    }

    //Print_001 > AO_005
    public void PrintInvoice_ViewDetails() {
        navigateToOrders("admin");

        click(adminOrdersPageObjects.ViewDetailsFirstRow_Button(),"View Order Details");
        isVisible(adminOrdersPageObjects.PrintInvoice(),"Print Invoice Button");
        click(adminOrdersPageObjects.PrintInvoice(),"Print Invoice");

        waitSleep(3000);
        isFileExist("Order Details.pdf");
    }

    //Print_001 > AO_006
    public void Correct_DateRange() {
        navigateToOrders("admin");

        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(1000);
        typeEnter(adminOrdersPageObjects.Date_From(), "Date Picker: From", "2024-06-01");
        typeEnter(adminOrdersPageObjects.Date_To(), "Date Picker: To", "2024-07-01");
        waitSleep(1000);

        LoggingUtils.info("Date Range Testing");
        int ctr = 0;
        for(WebElement  orderNo : adminOrdersPageObjects.dates()){
            LoggingUtils.info("Date: " + getText(orderNo));
            ctr++;
            if(ctr == 10){
                passTest("Correct_DateRange", "Date Range = Listed Dates");
                break;
            }
        }
    }

    //Date_001 > AO_007
    public void Incorrect_DateRange() {
        navigateToOrders("admin");

        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(1000);
        type(adminOrdersPageObjects.Date_From(), "Date Picker: From", "1999-12-25");
        typeEnter(adminOrdersPageObjects.Date_To(), "Date Picker: To", "2000-12-25");
        waitSleep(1000);

        LoggingUtils.info("Date Range Testing");
        int ctr = 0;
        for(WebElement  orderNo : adminOrdersPageObjects.dates()){
            LoggingUtils.info("Date: " + getText(orderNo));
            ctr++;
            if(ctr == 0){
                passTest("Correct_DateRange", "Date Range = Listed Dates");
                break;
            }
        }
    }


    //Search_001 > AO_008
    public void Seller_Search() {
        navigateToOrders("admin");

        //Seller Search
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        type(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "ML TG QA TEAM");
        waitSleep(8000);
        String SellerInput = getValue(adminOrdersPageObjects.Searchbar_Orders());
        waitSleep(2000);

        getValue(adminOrdersPageObjects.firstOrderSellerName());
        assertEqual(getText(adminOrdersPageObjects.firstOrderSellerName()), SellerInput);

        LoggingUtils.info("Seller Search and Validation: Successful");
    }

    //AO_009
    public void PaymentMethod_Search() {
        navigateToOrders("admin");

        //Payment Method Search
        type(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "ML WALLET");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(8000);
        String SellerInput = getValue(adminOrdersPageObjects.Searchbar_Orders());
        waitSleep(2000);

        getValue(adminOrdersPageObjects.firstOrderModeOfPayment());
        assertEqual(getText(adminOrdersPageObjects.firstOrderModeOfPayment()), SellerInput);

        //Check View Details
        click(adminOrdersPageObjects.ViewDetailsFirstRow_Button(),"View Details");
        waitSleep(2000);
        getValue(adminOrdersPageObjects.ModeOfPayment_ViewDetails());
        assertEqual(getText(adminOrdersPageObjects.ModeOfPayment_ViewDetails()), SellerInput);

        LoggingUtils.info("Mode of Payment Search and Validation: Successful");
    }

    //AO_010
    public void OrderStatus_Search() {
        navigateToOrders("admin");

        //Order Status Search
        type(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "PENDING");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(8000);
        String SellerInput = getValue(adminOrdersPageObjects.Searchbar_Orders());
        waitSleep(2000);

        getValue(adminOrdersPageObjects.firstOrderStatus());
        assertEqual(getText(adminOrdersPageObjects.firstOrderStatus()), SellerInput);

        //Check View Details
        click(adminOrdersPageObjects.ViewDetailsFirstRow_Button(),"View Details");
        waitSleep(2000);
        getValue(adminOrdersPageObjects.OrderStatus_ViewDetails());
        assertEqual(getText(adminOrdersPageObjects.OrderStatus_ViewDetails()), SellerInput);

        LoggingUtils.info("Order Status Search and Validation: Successful");
    }

    //Search_002 > AO_011
    public void IncorrectSeller_Search() {
        navigateToOrders("admin");

        type(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "Jasper QT");
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(3000);

        int ctr = 0;
        for(WebElement  sellerList : adminOrdersPageObjects.sellerList()){
            LoggingUtils.info("Seller: " + getText(sellerList));
            ctr++;
            if(ctr == 0){
                passTest("IncorrectSeller_Search", "Seller List is Empty");
                break;
            }
        }
        LoggingUtils.info("Incorrect Seller Search and Validation: Successful");
    }


    //AO_012
    public void IncorrectPaymentMethod_Search() {
        navigateToOrders("admin");

        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(3000);
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "MELGO DE BANKO");
        waitSleep(4000);

        int ctr = 0;
        for(WebElement  paymentMethod : adminOrdersPageObjects.paymentMethodList()){
            LoggingUtils.info("Payment Method: " + getText(paymentMethod));
            ctr++;
            if(ctr == 0){
                passTest("IncorrectPaymentMethod_Search", "Payment Method List is Empty");
                break;
            }
        }
        LoggingUtils.info("Incorrect Payment Method Search and Validation: Successful");
    }

    //AO_013
    public void IncorrectOrderStatus_Search() {
        navigateToOrders("admin");

        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(3000);
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "ZESTY");
        waitSleep(4000);

        int ctr = 0;
        for(WebElement  orderStatus : adminOrdersPageObjects.orderStatusList()){
            LoggingUtils.info("Payment Method: " + getText(orderStatus));
            ctr++;
            if(ctr == 0){
                passTest("IncorrectOrderStatus_Search", "Order Status List is Empty");
                break;
            }
        }
        LoggingUtils.info("Incorrect Order Status Search and Validation: Successful");
    }
}
























