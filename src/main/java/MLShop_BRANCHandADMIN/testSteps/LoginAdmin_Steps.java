package MLShop_BRANCHandADMIN.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class LoginAdmin_Steps extends Base_Steps{

    //Methods
    public void loginByRole(String role) {
        type(loginAdminPageObjects.EmailField_LoginPage(), "Email Field", reader.getEmailByRole(role));
        type(loginAdminPageObjects.PasswordField_LoginPage(), "Email Field", reader.getPasswordByRole(role));
        click(loginAdminPageObjects.LoginButton_LoginPage(), "Login");
        LoggingUtils.info("Successful Logged In");
    }

    public void logoutByRole(String role) {
//      waitSleep(3000);
        click(loginAdminPageObjects.UserAvatar_Icon_HomePage(),"User Avatar");
        waitSleep(1000);
        click(loginAdminPageObjects.UserAvatar_LogoutButton_HomePage(),"User Log Out");
        waitSleep(1000);
    }

    //Test Cases
    public void Admin_Login() {
        loginByRole("admin");

        if (isVisible(loginAdminPageObjects.ReceiveItemFromCargo_HomePage(), "Receive Item From Cargo Tab") &&
                isVisible(loginAdminPageObjects.ReceiveItemFromMerchant_HomePage(), "Receive Item From Merchant Tab") &&
                isVisible(loginAdminPageObjects.PickUpItemFromCargo_HomePage(), "Pick Up Item From Cargo Tab") &&
                isVisible(loginAdminPageObjects.ForCustomerPickUp_HomePage(), "For Customer Pick Up Tab") &&
                isVisible(loginAdminPageObjects.Reports_HomePage(), "Reports Tab") &&
                isVisible(loginAdminPageObjects.UserAvatar_Icon_HomePage(), "User Avatar")) {
            ExtentReporter.logPass("Branch_Login", "Branch Log In: Successful");
        } else {
            ExtentReporter.logFail("Branch_Login", "Branch Log In: Failed");
            Assert.fail("Failed Logging In.");
        }
    }

    public void PasswordVisibility_Login() {
        click(loginAdminPageObjects.UserAvatar_Icon_HomePage(),"User Avatar");
        logoutByRole("admin");

        type(loginAdminPageObjects.EmailField_LoginPage(), "Email Field", "norberto.dano@mlhuillier.com");
        type(loginAdminPageObjects.PasswordField_LoginPage(), "Email Field", "123" + getRandomNumber());
        String inputtedPassword = getValue(loginAdminPageObjects.PasswordField_LoginPage());
        click(loginAdminPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        assertEqual(getValue(loginAdminPageObjects.PasswordField_LoginPage()), inputtedPassword);

        LoggingUtils.info("Password Visibility: Successful");
    }

}
