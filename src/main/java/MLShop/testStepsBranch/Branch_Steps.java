package MLShop.testStepsBranch;

import MLShop.pageObjectBranch.Branch_PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.util.List;

public class Branch_Steps extends Base_Steps{

    //Methods
    public void loginByRole(String role) {
        type(branchLoginPageObjects.EmailField_LoginPage(), "Email Field", reader.getEmailByRole(role));
        type(branchLoginPageObjects.PasswordField_LoginPage(), "Email Field", reader.getPasswordByRole(role));
        click(branchLoginPageObjects.LoginButton_LoginPage(), "Login");
        LoggingUtils.info("Successful Logged In");
    }

    public void logoutByRole(String role) {
//      waitSleep(3000);
//        click(branchLoginPageObjects.UserAvatar_Icon_HomePage(),"User Avatar");
        click(branchLoginPageObjects.UserIcon_Header(),"User Avatar");
        click(branchLoginPageObjects.UserIcon_Header(),"User Avatar");
        waitSleep(1000);
        click(branchLoginPageObjects.UserAvatar_LogoutButton_HomePage(),"User Log Out");
        waitSleep(1000);
    }

    public void OTP_Buyer(){
            for(int i = 1; i <= 6 ; i++){
                typeActiveElement(String.valueOf(i));
            }
    }

//    public void ValidateStatusChange(String OrderNumber){
//        openNewTabWithUrl("https://mlshoppreprod.mlhuillier.com/purchasehistory");
//
//        LoggingUtils.info("::::::::::::Looping Through Sub Accounts::::::::::::::::");
//        boolean isOrderNumberFound = false; // Add a flag to track if the email is found
//        for (WebElement trElement : branchPageObjects.orderNumberListTr()) {
//            List<WebElement> tdElements = trElement.findElements(By.cssSelector("div:nth-of-type(378) div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(1)")); //TD locator
//            for (WebElement tdElement : tdElements) {
//                String tdOrderNumber = tdElement.getText();
//                if (tdOrderNumber.equals(OrderNumber)) {
//                    LoggingUtils.info("Order Number: " + OrderNumber);
//                    isOrderNumberFound = true; // Set the flag to true if the email is found in any TD element
//                    break; // Exit the inner loop once the email is found
//                }
//            }
//            if (isOrderNumberFound) {
//                break; // Exit the outer loop since the email is found
//            }
//        }
//        // Assert if the email is found or not
//        if (isOrderNumberFound) {
//            passTest("ValidateStatusChange", "Validate Status Change");
//        } else {
//            failTest("ValidateStatusChange", "Failed to Validate Status Change");
//        }
//
//    }

//    public void MLSHOPBUYER_GetOrderNumber(){
//        //LOG IN: Buyer
//        openNewTabWithUrl("https://mlshoppreprod.mlhuillier.com/authlogin");
//        click(branchPageObjects.MobileNumber_MLSHOPBUYER(),"Login Button");
//        type(branchPageObjects.MobileNumber_MLSHOPBUYER(),"Number Field","09999999998");
//        click(branchPageObjects.Login_Button_MLSHOPBUYER(),"Login Button");
//        waitSleep(3000);
//        OTP_Buyer();
//        click(branchPageObjects.OkayButton_MLSHOPBUYER(),"Okay Modal Button");
//
//        //Selecting Product
//        click(branchPageObjects.AmparitoCollections_MLSHOPBUYER(),"Amparito Collections");
//        waitSleep(1500);
//        click(branchPageObjects.FirstItemAmparito_MLSHOPBUYER(),"First Item in Amparito");
//        //Add to Cart
//        waitSleep(2000);
//        click(branchPageObjects.AddToCard_MLSHOPBUYER(),"Add To Cart Button");
//        click(branchPageObjects.ConfirmButtonCart_MLSHOPBUYER(),"Confirm Button");
//        click(branchPageObjects.Cart_MLSHOPBUYER(),"Cart Button");
//        waitSleep(2000);
//        //Shopping Cart
//        click(branchPageObjects.Checkout_MLSHOPBUYER(),"Checkout Button");
//        waitSleep(6000);
//        //Shipping Details
//        scrollToElement(branchPageObjects.ProvinceState_MLSHOPBUYER());
//        waitSleep(800);
//        selectByVisibleText(branchPageObjects.ProvinceState_MLSHOPBUYER(), "CEBU");
//        waitSleep(1500);
//        selectByVisibleText(branchPageObjects.CityTown_MLSHOPBUYER(), "CEBU CITY");
//        waitSleep(1500);
//        selectByVisibleText(branchPageObjects.Branch_MLSHOPBUYER(), "MLTG DIVISION 1");
//        String DestinationAddress = getText(branchPageObjects.Branch_MLSHOPBUYER());
//        LoggingUtils.info("Done Gathering Branch Status = " +DestinationAddress);
//        waitSleep(2000);
//
//        click(branchPageObjects.MLWallet_MLSHOPBUYER(),"ML Wallet Radio Button");
//        waitSleep(500);
//        click(branchPageObjects.PlaceOrder_MLSHOPBUYER(),"Place Order");
//        waitSleep(500);
//        click(branchPageObjects.ProceedButton_MLSHOPBUYER(),"Proceed Button");
//        waitSleep(5000);
//        OTP_Buyer();
//        waitSleep(2000);
//        click(branchPageObjects.OkayButton_Checkout_MLSHOPBUYER(),"Okay Button");
//        //Purchase History
//        waitSleep(4000);
//        String OrderNumber = getText(branchPageObjects.PurchaseHistory_FirstOrderNumber_MLSHOPBUYER());
//
//        waitSleep(5000);
////        passTest("ML_Shop","Passed");
//        LoggingUtils.info("Done Gathering Order Number = " +OrderNumber);
//        Search_via_Sidebars(OrderNumber);
//    }

    //For login only
    public void Branch_Login() {
        loginByRole("branch");

        if (isVisible(branchPageObjects.ReceiveItemFromMerchant_HomePage(), "Receive Item By Merchant") &&
                isVisible(branchPageObjects.PickUpItembyCargo_HomePage(), "Pick Up Item From Cargo") &&
                isVisible(branchPageObjects.ReceiveItemFromCargo_HomePage(), "Receive Item From Cargo") &&
                isVisible(branchPageObjects.ForCustomerPickUp_HomePage(), "For Customer Pick Up")){
//            &&
//                isVisible(branchPageObjects.Reports_HomePage(), "Reports")) {
            ExtentReporter.logPass("Branch_Login", "Branch Log In: Successful");
            waitSleep(1000);
        } else {
            ExtentReporter.logFail("Branch_Login", "Branch Log In: Failed");
            Assert.fail("Failed Logging In.");
        }
        LoggingUtils.info("Branch Log-In: Successful");
    }
    //For login only

    //Test Cases
    //Nav_001 > B_001
    public void Sidebar_Navigation(){

        click(branchPageObjects.PickUpItembyCargo_HomePage(),"Pick-up Item by Cargo");
        waitSleep(1300);
        click(branchPageObjects.ReceiveItemFromCargo_HomePage(),"Receive Item from Cargo");
        waitSleep(1300);
        click(branchPageObjects.ForCustomerPickUp_HomePage(),"For Customer Pick-up");
        waitSleep(1300);
        click(branchPageObjects.ReceiveItemFromMerchant_HomePage(),"Receive Item from Merchant");

        LoggingUtils.info("Navigation: Successful");
    }

    //Entry_001 > B_002
    public void Entries(){

        //Receive Item from Merchant
        click(branchPageObjects.ReceiveItemFromMerchant_HomePage(),"Receive Item from Merchant");
        waitSleep(1300);
        selectByValue(branchPageObjects.EntryMerchant_DropDown(),"5");
        selectByValue(branchPageObjects.EntryMerchant_DropDown(),"10");
        selectByValue(branchPageObjects.EntryMerchant_DropDown(),"25");
        selectByValue(branchPageObjects.EntryMerchant_DropDown(),"50");
        selectByValue(branchPageObjects.EntryMerchant_DropDown(),"75");
        selectByValue(branchPageObjects.EntryMerchant_DropDown(),"100");
        waitSleep(1300);

        //Pick-up Item by Cargo
        click(branchPageObjects.PickUpItembyCargo_HomePage(),"Pick-up Item by Cargo");
        waitSleep(1300);
        selectByValue(branchPageObjects.EntryPCargo_DropDown(),"5");
        selectByValue(branchPageObjects.EntryPCargo_DropDown(),"10");
        selectByValue(branchPageObjects.EntryPCargo_DropDown(),"25");
        selectByValue(branchPageObjects.EntryPCargo_DropDown(),"50");
        selectByValue(branchPageObjects.EntryPCargo_DropDown(),"75");
        selectByValue(branchPageObjects.EntryPCargo_DropDown(),"100");
        waitSleep(1300);

        //Receive Item from Cargo
        click(branchPageObjects.ReceiveItemFromCargo_HomePage(),"Receive Item from Cargo");
        waitSleep(1300);
        selectByValue(branchPageObjects.EntryRCargo_DropDown(),"5");
        selectByValue(branchPageObjects.EntryRCargo_DropDown(),"10");
        selectByValue(branchPageObjects.EntryRCargo_DropDown(),"25");
        selectByValue(branchPageObjects.EntryRCargo_DropDown(),"50");
        selectByValue(branchPageObjects.EntryRCargo_DropDown(),"75");
        selectByValue(branchPageObjects.EntryRCargo_DropDown(),"100");
        waitSleep(1300);

        //For Customer Pick-up
        click(branchPageObjects.ForCustomerPickUp_HomePage(),"For Customer Pick-up");
        waitSleep(1300);
        selectByValue(branchPageObjects.EntryCustomerPickUp_DropDown(),"5");
        selectByValue(branchPageObjects.EntryCustomerPickUp_DropDown(),"10");
        selectByValue(branchPageObjects.EntryCustomerPickUp_DropDown(),"25");
        selectByValue(branchPageObjects.EntryCustomerPickUp_DropDown(),"50");
        selectByValue(branchPageObjects.EntryCustomerPickUp_DropDown(),"75");
        selectByValue(branchPageObjects.EntryCustomerPickUp_DropDown(),"100");
        waitSleep(1300);

        LoggingUtils.info("Entry Selection: Successful");
    }

    //Search_001 > B_003
//    public void Search_via_Sidebars(String OrderNumber) {
// ----------------------------------------------------------------------------------------------------------------------------
    public void Search_via_Sidebars() {
                                                                                                                                                                                /* ML Shop Buyer*/
        //LOG IN: Buyer
        openNewTabWithUrl("https://mlshoppreprod.mlhuillier.com/authlogin");
        click(branchPageObjects.MobileNumber_MLSHOPBUYER(),"Login Button");
        type(branchPageObjects.MobileNumber_MLSHOPBUYER(),"Number Field","09999999998");
        click(branchPageObjects.Login_Button_MLSHOPBUYER(),"Login Button");
        waitSleep(6000);
        OTP_Buyer();
        click(branchPageObjects.OkayButton_MLSHOPBUYER(),"Okay Modal Button");

        //Gathering Customer Name
        waitSleep(2000);
        click(branchPageObjects.AvatarIcon_MLSHOPBUYER(),"Avatar Icon");
        click(branchPageObjects.ProfileAvatar_MLSHOPBUYER(),"Profile Button in Avatar");
        waitSleep(1500);
        String UserFullName = getText(branchPageObjects.UserFullName_MLSHOPBUYER());
        LoggingUtils.info("Done Gathering Branch Status = " +UserFullName);
        waitSleep(1500);

        //Selecting Product
        click(branchPageObjects.AmparitoCollections_MLSHOPBUYER(),"Amparito Collections");
        waitSleep(3000);
        click(branchPageObjects.SortBy_MLSHOPBUYER(),"Sort By");
        click(branchPageObjects.LowToHigh_MLSHOPBUYER(),"Selected Low to High");
        waitSleep(2000);
        String ProductName = getText(branchPageObjects.ProductName_MLSHOPBUYER());
        LoggingUtils.info("Done Gathering Product Name = " +ProductName);
        click(branchPageObjects.FirstItemAmparito_MLSHOPBUYER(),"First Item in Amparito");

        //Add to Cart
        waitSleep(3000);
        click(branchPageObjects.AddToCard_MLSHOPBUYER(),"Add To Cart Button");
        click(branchPageObjects.ConfirmButtonCart_MLSHOPBUYER(),"Confirm Button");
        click(branchPageObjects.Cart_MLSHOPBUYER(),"Cart Button");
        waitSleep(3000);

        //Shopping Cart
        click(branchPageObjects.Checkout_MLSHOPBUYER(),"Checkout Button");
        waitSleep(6000);

        //Shipping Details
        scrollToElement(branchPageObjects.ProvinceState_MLSHOPBUYER());
        waitSleep(800);
        selectByVisibleText(branchPageObjects.ProvinceState_MLSHOPBUYER(), "CEBU");
        waitSleep(1500);
        selectByVisibleText(branchPageObjects.CityTown_MLSHOPBUYER(), "CEBU CITY");
        waitSleep(1500);
        selectByVisibleText(branchPageObjects.Branch_MLSHOPBUYER(), "MLTG DIVISION 1");
        waitSleep(2000);

        click(branchPageObjects.MLWallet_MLSHOPBUYER(),"ML Wallet Radio Button");
        waitSleep(500);
        click(branchPageObjects.PlaceOrder_MLSHOPBUYER(),"Place Order");
        waitSleep(500);
        click(branchPageObjects.ProceedButton_MLSHOPBUYER(),"Proceed Button");
        waitSleep(5000);
    /* ---------------------------------------------------------------------------------------------------------------- */
        OTP_Buyer();
    /* ---------------------------------------------------------------------------------------------------------------- */
        waitSleep(4000);
        click(branchPageObjects.OkayButton_Checkout_MLSHOPBUYER(),"Okay Button");
        //Purchase History
        waitSleep(4000);
        String OrderNumber = getText(branchPageObjects.PurchaseHistory_FirstOrderNumber_MLSHOPBUYER());

        //Gathers Order Status
        String OrderStatus = getText(branchPageObjects.ShopStatus_MLSHOPBUYER());
        LoggingUtils.info("Done Gathering Order Number = " +OrderNumber);
        LoggingUtils.info("Done Gathering Order Status = " +OrderStatus);
//     /* ---------------------------------------------------------------------------------------------------------------- */
        waitSleep(5000);
//        /* Redirects Back to ML Shop Branch */
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Gathered ProductName
        //Gathered OrderNumber
        //Gathered OrderStatus
        //Gathered DestinationAddress
        //Gathered UserFullName
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
/* ML Shop Branch */
        switchToPreviousTab();
/*Receive Item from Merchant*/
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        click(branchPageObjects.ReceiveItemFromMerchant_HomePage(),"Receive Item from Merchant");
        typeEnter(branchPageObjects.ReceiveItemFromMerchant_Searchbar(),"Receive Item From Merchant Search Bar",""+ OrderNumber);
        waitSleep(3000);

        String BranchOrderNumber = getText(branchPageObjects.OrderNumberFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchOrderNumber);
        String BranchProductName = getText(branchPageObjects.ProductNameFirstRow());
        LoggingUtils.info("Done Gathering Branch Product Name = " +BranchProductName);
        String BranchCustomerName = getText(branchPageObjects.CustomerNameFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchCustomerName);
        String BranchDestinationAddress = getText(branchPageObjects.DestinationAddressFirstRow());
        LoggingUtils.info("Done Gathering Branch Destination Address = " +BranchDestinationAddress);
        String BranchStatus = getText(branchPageObjects.StatusFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchStatus);

        assertEqual(OrderNumber, BranchOrderNumber);
        assertEqual(ProductName, BranchProductName);
        assertEqual(UserFullName, BranchCustomerName);
//        assertEqual(DestinationAddress, BranchDestinationAddress);
        assertEqual(OrderStatus, BranchStatus);

        click(branchPageObjects.SelectButton(),"Select Row Button");

        String BranchOrderNumberPopUp = getValue(branchPageObjects.OrderNumberPOPUP_RIFM());
        LoggingUtils.info("Done Gathering Branch Order Number on Pop Up Detail = " +BranchOrderNumberPopUp);
        String BranchProductNamePopUp = getValue(branchPageObjects.ProductNamePOPUP_RIFM());
        LoggingUtils.info("Done Gathering Branch Product Name on Pop Up Detail = " +BranchProductNamePopUp);

        assertEqual(OrderNumber, BranchOrderNumberPopUp);
        assertEqual(ProductName, BranchProductNamePopUp);

        //Modal Message
        waitSleep(2000);
        click(branchPageObjects.ReprintButton_RIFM(),"Reprint Button");
        waitSleep(1500);
        click(branchPageObjects.ReceiveItemButton_RIFM(),"Receive Item Button");
        waitSleep(1000);
        String ModalMesssage = getText(branchPageObjects.ConfirmationMessage_RIFM());
        LoggingUtils.info("Pop-up Message: " + ModalMesssage);
        waitSleep(1200);
        click(branchPageObjects.CloseButton_RIFM(),"Close Button");
//        ------------------------------------------------------------------------------------------------------
        //Validate Delivery Status for "Pick-up Item by Cargo"
        switchToNextTab();
        driver.navigate().refresh();
        waitSleep(5000);
        String OrderStatus2 = getText(branchPageObjects.ShopStatus_MLSHOPBUYER());
        LoggingUtils.info("Done Gathering Updated Order Status = " +OrderStatus2);
        switchToPreviousTab();
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /*Pick-up Item by Cargo*/
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        click(branchPageObjects.PickUpItembyCargo_HomePage(),"Pick-up Item by Cargo");
        typeEnter(branchPageObjects.PickUpItemByCargo_Searchbar(),"Pick Up Item by Cargo Search Bar",""+ OrderNumber);
        selectByVisibleText(branchPageObjects.PickUpItemByCargo_Courier(),"3PL");
        waitSleep(3000);

        String BranchOrderNumber_PUIBC = getText(branchPageObjects.OrderNumberFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchOrderNumber_PUIBC);
        String BranchProductName_PUIBC = getText(branchPageObjects.ProductNameFirstRow());
        LoggingUtils.info("Done Gathering Branch Product Name = " +BranchProductName_PUIBC);
        String BranchCustomerName_PUIBC = getText(branchPageObjects.CustomerNameFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchCustomerName_PUIBC);
        String BranchDestinationAddress_PUIBC = getText(branchPageObjects.DestinationAddressFirstRow());
        LoggingUtils.info("Done Gathering Branch Destination Address = " +BranchDestinationAddress_PUIBC);
        String BranchStatus_PUIBC = getText(branchPageObjects.StatusFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchStatus);

        assertEqual(OrderNumber, BranchOrderNumber_PUIBC);
        assertEqual(ProductName, BranchProductName_PUIBC);
        assertEqual(UserFullName, BranchCustomerName_PUIBC);
        assertEqual(BranchDestinationAddress, BranchDestinationAddress_PUIBC);
        assertEqual(OrderStatus2, BranchStatus_PUIBC);

        click(branchPageObjects.SelectButton(),"Select Row Button");

        String BranchCustomerNamePopUP_PUIBC = getValue(branchPageObjects.CustomerFullNamePOPUP_PIUBC());
        LoggingUtils.info("Done Gathering Branch Customer Name on Pop Up Detail = " +BranchCustomerNamePopUP_PUIBC);
        String BranchProductNamePopUp2 = getValue(branchPageObjects.ProductName_PUIBC());
        LoggingUtils.info("Done Gathering Branch Product Name on Pop Up Detail = " +BranchProductNamePopUp2);

        assertEqual(UserFullName, BranchCustomerNamePopUP_PUIBC);
        assertEqual(ProductName, BranchProductNamePopUp2);

        //Modal Message
        waitSleep(2000);
        click(branchPageObjects.ReprintButton_RIFM(),"Reprint Button");
        waitSleep(1500);
        click(branchPageObjects.PickUpItemButton(),"Pick-up Item Button");
        waitSleep(3000);
        String ModalMesssage2 = getText(branchPageObjects.ConfirmationMessage_PUIBC());
        LoggingUtils.info("Pop-up Message: " + ModalMesssage2);
        waitSleep(1200);
        click(branchPageObjects.CloseButton_PUIBC(),"Close Button");

        //Dispatch
        driver.navigate().refresh();
        waitSleep(3000);
        selectByVisibleText(branchPageObjects.PickUpItemByCargo_Courier(),"3PL");
        click(branchPageObjects.PlainDispatchButton_PUIBC(),"Dispatch Button");
        waitSleep(3000);
        click(branchPageObjects.SubmitButton_PUIBC(),"Submit Button");
        waitSleep(3000);
        click(branchPageObjects.FormDispatchButton_PUIBC(),"Form Dispatch Button");
        waitSleep(1000);
        click(branchPageObjects.ExitFormButton_PUIBC(),"Exit Form Button");
        waitSleep(1000);
//        ------------------------------------------------------------------------------------------------------
        //Validate Delivery Status for "Receive Item from Cargo"
        switchToNextTab();
        driver.navigate().refresh();
        waitSleep(5000);
        String OrderStatus3 = getText(branchPageObjects.ShopStatus_MLSHOPBUYER());
        LoggingUtils.info("Done Gathering Updated Order Status = " +OrderStatus3);
        switchToPreviousTab();
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /*Receive Item from Cargo*/
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        click(branchPageObjects.ReceiveItemFromCargo_HomePage(),"Receive Item from Cargo");
        typeEnter(branchPageObjects.ReceiveItemFromCargo_Searchbar(), "Receive Item from Cargo Search Bar", "" +OrderNumber);
        waitSleep(1200);

        String BranchOrderNumber_RIFC = getText(branchPageObjects.OrderNumberFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchOrderNumber_RIFC);
        String BranchProductName_RIFC = getText(branchPageObjects.ProductNameFirstRow());
        LoggingUtils.info("Done Gathering Branch Product Name = " +BranchProductName_RIFC);
        String BranchCustomerName_RIFC = getText(branchPageObjects.CustomerNameFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchCustomerName_RIFC);
        String BranchDestinationAddress_RIFC = getText(branchPageObjects.DestinationAddressFirstRow());
        LoggingUtils.info("Done Gathering Branch Destination Address = " +BranchDestinationAddress_RIFC);
        String BranchStatus_RIFC = getText(branchPageObjects.StatusFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchStatus_RIFC);

        assertEqual(OrderNumber, BranchOrderNumber_RIFC);
        assertEqual(ProductName, BranchProductName_RIFC);
        assertEqual(UserFullName, BranchCustomerName_RIFC);
        assertEqual(BranchDestinationAddress, BranchDestinationAddress_RIFC);
        assertEqual(OrderStatus3, BranchStatus_RIFC);

        click(branchPageObjects.SelectButton(),"Select Row Button");

        String BranchCustomerNamePopUP_RIFC = getValue(branchPageObjects.CustomerFullNamePOPUP_PIUBC());
        LoggingUtils.info("Done Gathering Branch Customer Name on Pop Up Detail = " +BranchCustomerNamePopUP_RIFC);
        String BranchProductNamePopUp_RIFC = getValue(branchPageObjects.ProductName_PUIBC());
        LoggingUtils.info("Done Gathering Branch Product Name on Pop Up Detail = " +BranchProductNamePopUp_RIFC);

        assertEqual(UserFullName, BranchCustomerNamePopUP_RIFC);
        assertEqual(ProductName, BranchProductNamePopUp_RIFC);

        //Modal Message
        waitSleep(2000);
        click(branchPageObjects.ReprintButton_RIFM(),"Reprint Button");
        waitSleep(1500);
        click(branchPageObjects.ReceiveItemButton_RIFM(),"Receive Item Button");
        waitSleep(3000);
        String ModalMesssage3 = getText(branchPageObjects.ConfirmationMessage_RIFC());
        LoggingUtils.info("Pop-up Message: " + ModalMesssage3);
        waitSleep(1200);
        click(branchPageObjects.CloseButton_RIFC(),"Close Button");
//        ------------------------------------------------------------------------------------------------------
        //Validate Delivery Status for "For Customer Pick-Up"
        switchToNextTab();
        driver.navigate().refresh();
        waitSleep(5000);
        String OrderStatus4 = getText(branchPageObjects.ShopStatus_MLSHOPBUYER());
        LoggingUtils.info("Done Gathering Updated Order Status = " +OrderStatus4);
        switchToPreviousTab();
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /*For Customer Pick-Up*/
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        click(branchPageObjects.ForCustomerPickUp_HomePage(),"For Customer Pick-up");
        typeEnter(branchPageObjects.ForCustomerPickUp_Searchbar(), "For Customer Pick-up Search Bar", "" +OrderNumber);
        waitSleep(1200);

        String BranchOrderNumber_FCPU = getText(branchPageObjects.OrderNumberFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchOrderNumber_FCPU);
        String BranchProductName_FCPU = getText(branchPageObjects.ProductNameFirstRow());
        LoggingUtils.info("Done Gathering Branch Product Name = " +BranchProductName_FCPU);
        String BranchCustomerName_FCPU = getText(branchPageObjects.CustomerNameFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchCustomerName_FCPU);
        String BranchDestinationAddress_FCPU = getText(branchPageObjects.DestinationAddressFirstRow());
        LoggingUtils.info("Done Gathering Branch Destination Address = " +BranchDestinationAddress_FCPU);
        String BranchStatus_FCPU = getText(branchPageObjects.StatusFirstRow());
        LoggingUtils.info("Done Gathering Branch Status = " +BranchStatus_FCPU);

        assertEqual(OrderNumber, BranchOrderNumber_FCPU);
        assertEqual(ProductName, BranchProductName_FCPU);
        assertEqual(UserFullName, BranchCustomerName_FCPU);
        assertEqual(BranchDestinationAddress, BranchDestinationAddress_FCPU);
        assertEqual(OrderStatus4, BranchStatus_FCPU);

        click(branchPageObjects.SelectButton(),"Select Row Button");

        String BranchCustomerNamePopUP_FCPU = getValue(branchPageObjects.CustomerFullNamePOPUP_PIUBC());
        LoggingUtils.info("Done Gathering Branch Customer Name on Pop Up Detail = " +BranchCustomerNamePopUP_FCPU);
        String BranchProductNamePopUp_FCPU = getValue(branchPageObjects.ProductName_PUIBC());
        LoggingUtils.info("Done Gathering Branch Product Name on Pop Up Detail = " +BranchProductNamePopUp_FCPU);

        assertEqual(UserFullName, BranchCustomerNamePopUP_FCPU);
        assertEqual(ProductName, BranchProductNamePopUp_FCPU);

        //Modal Message
        waitSleep(2000);
        click(branchPageObjects.ReprintButton_RIFM(),"Reprint Button");
        waitSleep(1500);
        click(branchPageObjects.OrderReceived_FCPU(),"Order Received Button");
        waitSleep(3000);
        String ModalMesssage4 = getText(branchPageObjects.ConfirmationMessage_FCPU());
        LoggingUtils.info("Pop-up Message: " + ModalMesssage4);
        waitSleep(1200);
        click(branchPageObjects.CloseButton_FCPU(),"Close Button");

        //Validate Delivery Status
        switchToNextTab();
        driver.navigate().refresh();
        waitSleep(5000);
        String OrderStatusFinal = getText(branchPageObjects.ShopStatus_MLSHOPBUYER());
        LoggingUtils.info("Done Gathering Updated Order Status = " +OrderStatusFinal);
        switchToPreviousTab();

        String FinalStatus = "COMPLETED";
        assertEqual(FinalStatus, OrderStatusFinal);
//        ------------------------------------------------------------------------------------------------------
        }

    //Search_002 > B_004
    public void InvalidSearch_via_Sidebars(){

        //Receive Item from Merchant
        click(branchPageObjects.ReceiveItemFromMerchant_HomePage(),"Receive Item from Merchant");
        typeEnter(branchPageObjects.ReceiveItemFromMerchant_Searchbar(),"Receive Item From Merchant Search Bar","MLMC1113AAD");
        isVisible(branchPageObjects.Modal_Failed(),"Modal Search Fail");
        String ModalText = getText(branchPageObjects.Modal_Text());
        LoggingUtils.info("Modal Text: "+ModalText);
        waitSleep(1500);
        click(branchPageObjects.Modal_Close(),"Close Modal");
        LoggingUtils.info("Receive Item From Merchant Invalid Search: Success");
        waitSleep(1500);

        //Pick-up Item by Cargo
        click(branchPageObjects.PickUpItembyCargo_HomePage(),"Pick-up Item by Cargo");
        typeEnter(branchPageObjects.PickUpItemByCargo_Searchbar(),"Receive Item From Merchant Search Bar","MLMC1113AAD");
        selectByValue(branchPageObjects.PickUpItemByCargo_Courier(),"3PL");
        isVisible(branchPageObjects.Modal_Failed(),"Modal Search Fail");
        String ModalText2 = getText(branchPageObjects.Modal_Text());
        LoggingUtils.info("Modal Text: "+ModalText2);
        waitSleep(1500);
        click(branchPageObjects.Modal_Close(),"Close Modal");
        LoggingUtils.info("Pick-up Item by Cargo Invalid Search: Success");
        waitSleep(1500);

        //Receive Item from Cargo
        click(branchPageObjects.ReceiveItemFromCargo_HomePage(),"Receive Item from Cargo");
        typeEnter(branchPageObjects.ReceiveItemFromCargo_Searchbar(),"Receive Item From Cargo Search Bar","MLMC1113AAD");
        isVisible(branchPageObjects.Modal_Failed(),"Modal Search Fail");
        String ModalText3 = getText(branchPageObjects.Modal_Text());
        LoggingUtils.info("Modal Text: "+ModalText3);
        waitSleep(1500);
        click(branchPageObjects.Modal_Close(),"Close Modal");
        LoggingUtils.info("Receive Item From Cargo Invalid Search: Success");
        waitSleep(1500);

        //For Customer Pick-up
        click(branchPageObjects.ForCustomerPickUp_HomePage(),"For Customer Pick-up");
        typeEnter(branchPageObjects.ForCustomerPickUp_Searchbar(),"For Customer Pick Up Search Bar","MLMC1113AAD");
        isVisible(branchPageObjects.Modal_Failed(),"Modal Search Fail");
        String ModalText4 = getText(branchPageObjects.Modal_Text());
        LoggingUtils.info("Modal Text: "+ModalText4);
        waitSleep(1500);
        click(branchPageObjects.Modal_Close(),"Close Modal");
        LoggingUtils.info("For Customer Pick Up Invalid Search: Success");
        waitSleep(1500);
        }

}
