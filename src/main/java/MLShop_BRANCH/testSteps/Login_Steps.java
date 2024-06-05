package MLShop_BRANCH.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Login_Steps extends Base_Steps{

   //Methods
   public void loginByRole(String role) {
      type(loginPageObjects.EmailField_LoginPage(), "Email Field", reader.getEmailByRole(role));
      type(loginPageObjects.PasswordField_LoginPage(), "Email Field", reader.getPasswordByRole(role));
      click(loginPageObjects.LoginButton_LoginPage(), "Login");
      LoggingUtils.info("Successful Logged In");
   }

   //Test Cases
   public void Branch_Login() {
      loginByRole("branch");

      if (isVisible(loginPageObjects.ReceiveItemFromCargo_HomePage(), "Receive Item From Cargo Tab") &&
              isVisible(loginPageObjects.ReceiveItemFromMerchant_HomePage(), "Receive Item From Merchant Tab") &&
              isVisible(loginPageObjects.PickUpItemFromCargo_HomePage(), "Pick Up Item From Cargo Tab") &&
              isVisible(loginPageObjects.ForCustomerPickUp_HomePage(), "For Customer Pick Up Tab") &&
              isVisible(loginPageObjects.Reports_HomePage(), "Reports Tab") &&
              isVisible(loginPageObjects.UserAvatar_HomePage(), "User Avatar")) {
         ExtentReporter.logPass("Branch_Login", "Branch Log In: Successful");
      } else {
         ExtentReporter.logFail("Branch_Login", "Branch Log In: Failed");
         Assert.fail("Failed Logging In.");
      }
   }







}
