package MLShop.testStepsAdmin;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Orders_Steps extends MLShop.testStepsAdmin.Base_Steps {

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
            ExtentReporter.logPass("Admin_Login", "Admin Log In: Successful");
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
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");

        waitSleep(800);
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
        waitSleep(1500);
        String firstOrderSellerName = getText(adminOrdersPageObjects.firstOrderSellerName());
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "" +firstOrderSellerName);
        waitSleep(5000);
        assertEqual(getText(adminOrdersPageObjects.firstOrderSellerName()), firstOrderSellerName);

        //List Validation
        int ctr = 0;
        for(WebElement  sellerList : adminOrdersPageObjects.sellerList()){
            LoggingUtils.info("Seller: " + getText(sellerList));
            ctr++;
            if(ctr == 10){
                passTest("Seller_Search", "Seller List is Visible");
                break;
            }
        }
        LoggingUtils.info("Seller Search and Validation: Successful");
    }

    //AO_009
    public void PaymentMethod_Search() {
        navigateToOrders("admin");

        //Payment Method Search
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(1500);
        String firstOrderModeOfPayment = getText(adminOrdersPageObjects.firstOrderModeOfPayment());
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "" +firstOrderModeOfPayment);
        waitSleep(5000);
        assertEqual(getText(adminOrdersPageObjects.firstOrderModeOfPayment()), firstOrderModeOfPayment);

        //List Validation
        int ctr = 0;
        for(WebElement  paymentMethodList : adminOrdersPageObjects.paymentMethodList()){
            LoggingUtils.info("Payment Method: " + getText(paymentMethodList));
            ctr++;
            if(ctr == 10){
                passTest("PaymentMethod_Search", "Payment Method List is Visible");
                break;
            }
        }
        LoggingUtils.info("Mode of Payment Search and Validation: Successful");
    }

    //AO_010
    public void OrderStatus_Search() {
        navigateToOrders("admin");

        //Order Status Search
        selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
        waitSleep(1500);
        String firstOrderStatus = getText(adminOrdersPageObjects.firstOrderStatus());
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "" +firstOrderStatus);
        waitSleep(2500);
        assertEqual(getText(adminOrdersPageObjects.firstOrderStatus()), firstOrderStatus);

        //List Validation
        int ctr = 0;
        for(WebElement  orderStatusList : adminOrdersPageObjects.orderStatusList()){
            LoggingUtils.info("Order Status: " + getText(orderStatusList));
            ctr++;
            if(ctr == 10){
                passTest("PaymentMethod_Search", "Payment Method List is Visible");
                break;
            }
        }
        LoggingUtils.info("Order Status Search and Validation: Successful");
    }

        //Search_002 > AO_011
        public void IncorrectSeller_Search() {
            navigateToOrders("admin");

            //Seller Search
            selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
            waitSleep(1500);
            String firstOrderSellerName = getText(adminOrdersPageObjects.firstOrderSellerName());
            typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "@!@!" +firstOrderSellerName);
            waitSleep(2500);

            //List Validation
            int ctr = 0;
            for(WebElement  sellerList : adminOrdersPageObjects.sellerList()){
            LoggingUtils.info("Seller: " + getText(sellerList));
            ctr++;
            if(ctr > 1){
                failTest("IncorrectSeller_Search", "Seller List is Visible");
                break;
            }
            else {
                passTest("IncorrectSeller_Search", "Seller List is Empty");
            }
        }
         LoggingUtils.info("Incorrect Seller Search and Validation: Successful");
    }


    //AO_012
    public void IncorrectPaymentMethod_Search() {
    navigateToOrders("admin");

    //Payment Method Search
    selectByValue(adminOrdersPageObjects.Entry_DropDown(),"10");
    waitSleep(1500);
    String firstOrderModeOfPayment = getText(adminOrdersPageObjects.firstOrderModeOfPayment());
    typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "@!@!" +firstOrderModeOfPayment);
    waitSleep(2500);

    //List Validation
    int ctr = 0;
            for(WebElement  paymentMethodList : adminOrdersPageObjects.paymentMethodList()){
        LoggingUtils.info("Payment Method: " + getText(paymentMethodList));
        ctr++;
        if(ctr > 1){
            failTest("IncorrectPaymentMethod_Search", "Payment Method is Visible");
            break;
        }
        else {
            passTest("IncorrectPaymentMethod_Search", "Payment Method is Empty");
        }
    }
         LoggingUtils.info("Incorrect Seller Search and Validation: Successful");
}

    //AO_013
    public void IncorrectOrderStatus_Search() {
        navigateToOrders("admin");

        //Payment Method Search
        selectByValue(adminOrdersPageObjects.Entry_DropDown(), "10");
        waitSleep(1500);
        String firstOrderStatus = getText(adminOrdersPageObjects.firstOrderStatus());
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "@!@!" + firstOrderStatus);
        waitSleep(2500);

        //List Validation
        int ctr = 0;
        for (WebElement orderStatusList : adminOrdersPageObjects.orderStatusList()) {
            LoggingUtils.info("Order Status: " + getText(orderStatusList));
            ctr++;
            if (ctr > 1) {
                failTest("IncorrectOrderStatus_Search", "Order Status is Visible");
                break;
            } else {
                passTest("IncorrectOrderStatus_Search", "Order Status is Empty");
            }
        }
        LoggingUtils.info("Incorrect Order Status Search and Validation: Successful");
    }
}
























