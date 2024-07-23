package MLShop.testStepsAdmin;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Dashboard_Steps extends MLShop.testStepsAdmin.Base_Steps{

    //Methods
    public void loginByRole(String role) {
        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", reader.getEmailByRole(role));
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", reader.getPasswordByRole(role));
        click(adminLoginPageObjects.LoginButton_LoginPage(), "Login");
        LoggingUtils.info("Successful Logged In");
    }

    public void logoutByRole(String role) {
//      waitSleep(3000);
        click(adminLoginPageObjects.UserAvatar_Icon_HomePage(),"User Avatar");
        waitSleep(1000);
        click(adminLoginPageObjects.UserAvatar_LogoutButton_HomePage(),"User Log Out");
        waitSleep(1000);
    }

    //LOGIN
    public void Admin_Login() {
        loginByRole("admin");

        if (isVisible(adminLoginPageObjects.ReceiveItemFromCargo_HomePage(), "Receive Item From Cargo Tab") &&
                isVisible(adminLoginPageObjects.ReceiveItemFromMerchant_HomePage(), "Receive Item From Merchant Tab") &&
                isVisible(adminLoginPageObjects.PickUpItemFromCargo_HomePage(), "Pick Up Item From Cargo Tab") &&
                isVisible(adminLoginPageObjects.ForCustomerPickUp_HomePage(), "For Customer Pick Up Tab") &&
                isVisible(adminLoginPageObjects.Reports_HomePage(), "Reports Tab") &&
                isVisible(adminLoginPageObjects.UserAvatar_Icon_HomePage(), "User Avatar")) {
            ExtentReporter.logPass("Branch_Login", "Branch Log In: Successful");
        } else {
            ExtentReporter.logFail("Branch_Login", "Branch Log In: Failed");
            Assert.fail("Failed Logging In.");
        }
    }

    //TEST CASE




}
