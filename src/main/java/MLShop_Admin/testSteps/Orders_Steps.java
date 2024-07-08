package MLShop_Admin.testSteps;

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


    //Test Cases

    public void Admin_Search() {
        loginByRole("admin");
//        waitSleep(2500);
        navigateToOrders("admin");

        //Seller Search
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "Francis");
        String SellerInput = getValue(adminOrdersPageObjects.Searchbar_Orders());
        getText(adminOrdersPageObjects.firstOrderSellerName());
        waitSleep(1000);
        assertEqual(getText(adminOrdersPageObjects.firstOrderSellerName()), SellerInput);
        LoggingUtils.info("Seller Search: Successful");
        adminOrdersPageObjects.Searchbar_Orders().clear();
        waitSleep(1500);

        //Mode of Payment Search
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "GRAB PAY");
        
        String ModeOfPaymentInput = getValue(adminOrdersPageObjects.Searchbar_Orders());
        getText(adminOrdersPageObjects.firstOrderModeOfPayment());
        waitSleep(1000);
        assertEqual(getValue(adminOrdersPageObjects.firstOrderModeOfPayment()), ModeOfPaymentInput);
        LoggingUtils.info("Mode of Payment Search: Successful");
        adminOrdersPageObjects.Searchbar_Orders().clear();
        waitSleep(1500);

        //Order Status Search
        typeEnter(adminOrdersPageObjects.Searchbar_Orders(), "Searchbar", "PENDING");
        String OrderStatusInput = getValue(adminOrdersPageObjects.Searchbar_Orders());
        getText(adminOrdersPageObjects.firstOrderStatus());
        waitSleep(1000);
        assertEqual(getValue(adminOrdersPageObjects.firstOrderStatus()), OrderStatusInput);
        LoggingUtils.info("Order Status Search: Successful");
        adminOrdersPageObjects.Searchbar_Orders().clear();
        waitSleep(1500);

        LoggingUtils.info("Searches: Successful");
    }





























}
























