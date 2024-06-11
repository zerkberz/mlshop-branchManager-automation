package MLShop_BRANCHandADMIN.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class LoginBranch_Steps extends Base_Steps{

   //Methods
   public void loginByRole(String role) {
      type(loginBranchPageObjects.EmailField_LoginPage(), "Email Field", reader.getEmailByRole(role));
      type(loginBranchPageObjects.PasswordField_LoginPage(), "Email Field", reader.getPasswordByRole(role));
      click(loginBranchPageObjects.LoginButton_LoginPage(), "Login");
      LoggingUtils.info("Successful Logged In");
   }

   public void logoutByRole(String role) {
//      waitSleep(3000);
      click(loginBranchPageObjects.UserAvatar_Icon_HomePage(),"User Avatar");
      waitSleep(1000);
      click(loginBranchPageObjects.UserAvatar_LogoutButton_HomePage(),"User Log Out");
      waitSleep(1000);
   }

   //Test Cases
   public void Branch_Login() {
      loginByRole("branch");

      if (isVisible(loginBranchPageObjects.ReceiveItemFromCargo_HomePage(), "Receive Item From Cargo Tab") &&
              isVisible(loginBranchPageObjects.ReceiveItemFromMerchant_HomePage(), "Receive Item From Merchant Tab") &&
              isVisible(loginBranchPageObjects.PickUpItemFromCargo_HomePage(), "Pick Up Item From Cargo Tab") &&
              isVisible(loginBranchPageObjects.ForCustomerPickUp_HomePage(), "For Customer Pick Up Tab") &&
              isVisible(loginBranchPageObjects.Reports_HomePage(), "Reports Tab") &&
              isVisible(loginBranchPageObjects.UserAvatar_Icon_HomePage(), "User Avatar")) {
         ExtentReporter.logPass("Branch_Login", "Branch Log In: Successful");
      } else {
         ExtentReporter.logFail("Branch_Login", "Branch Log In: Failed");
         Assert.fail("Failed Logging In.");
      }
   }

   public void PasswordVisibility_Login() {
      click(loginBranchPageObjects.UserAvatar_Icon_HomePage(),"User Avatar");
      logoutByRole("branch");

      type(loginBranchPageObjects.EmailField_LoginPage(), "Email Field", "norberto.dano@mlhuillier.com");
      type(loginBranchPageObjects.PasswordField_LoginPage(), "Email Field", "123" + getRandomNumber());
      String inputtedPassword = getValue(loginBranchPageObjects.PasswordField_LoginPage());
      click(loginBranchPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
      assertEqual(getValue(loginBranchPageObjects.PasswordField_LoginPage()), inputtedPassword);

      LoggingUtils.info("Password Visibility: Successful");
   }



}
