package MLShop.testStepsBranch;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Login_Steps extends Base_Steps {
    
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

    public void OTP(String role){
        type(branchLoginPageObjects.VerificationCode1_OTP(),"1","1");
        type(branchLoginPageObjects.VerificationCode2_OTP(),"1","1");
        type(branchLoginPageObjects.VerificationCode3_OTP(),"1","1");
        type(branchLoginPageObjects.VerificationCode4_OTP(),"1","1");
        type(branchLoginPageObjects.VerificationCode5_OTP(),"1","1");
        type(branchLoginPageObjects.VerificationCode6_OTP(),"1","1");
    }

    public void ML_Shop(String role){
        ((JavascriptExecutor)driver).executeScript("window.open('https://mlshoppreprod.mlhuillier.com');");
        waitSleep(5000);
        passTest("ML_Shop","Passed");
    }

    //Test Cases
    //Login_001 >AL_001
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
            logoutByRole("branch login");
        } else {
            ExtentReporter.logFail("Branch_Login", "Branch Log In: Failed");
            Assert.fail("Failed Logging In.");
        }
    }

    //Login_002 > AL_002
    public void IncorrectEmail_Login() {

        type(branchLoginPageObjects.EmailField_LoginPage(), "Email Field", "norberto.danosaur.com");
        type(branchLoginPageObjects.PasswordField_LoginPage(), "Email Field", "123456q@");
        String inputtedEmail = getValue(branchLoginPageObjects.EmailField_LoginPage());
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        click(branchLoginPageObjects.LoginButton_LoginPage(), "Login Button");
        LoggingUtils.info("Correct Email is norberto.dano@mlhuillier.com while inputted is " + inputtedEmail);
        waitSleep(1000);

        if (isVisible(branchLoginPageObjects.GSuiteNotification_LoginPage(), "Invalid Email Notification")) {
            ExtentReporter.logPass("AL_002", "Incorrect Email Check: Successful");
        } else{
            ExtentReporter.logFail("AL_002", "Incorrect Email Check: Failed");
            Assert.fail("Failed Checking Invalid Email.");
        }
    }

    //Login_002 > AL_003
    public void IncorrectPassword_Login() {
        type(branchLoginPageObjects.EmailField_LoginPage(), "Email Field", "norberto.dano@mlhuillier.com");
        type(branchLoginPageObjects.PasswordField_LoginPage(), "Password Field", "123" + getRandomNumber());
        String inputtedPassword = getValue(branchLoginPageObjects.PasswordField_LoginPage());
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        click(branchLoginPageObjects.LoginButton_LoginPage(), "Login Button");
        LoggingUtils.info("Correct Password is 123456q@ and input is " + inputtedPassword);
        waitSleep(1000);

        if (isVisible(branchLoginPageObjects.InvalidCredentialsNotification_LoginPage(), "Invalid Password Notification")) {
            ExtentReporter.logPass("IncorrectPassword_Login", "Incorrect Password Check: Successful");
        } else{
            ExtentReporter.logFail("IncorrectPassword_Login", "Incorrect Password Check: Failed");
            Assert.fail("Failed Checking Invalid Password.");
        }
    }

    //Login_002 > AL_004
    public void IncorrectEmailAndPassword_Login() {
        type(branchLoginPageObjects.EmailField_LoginPage(), "Email Field", "norberto.danosaur.com");
        String inputtedEmail = getValue(branchLoginPageObjects.EmailField_LoginPage());
        type(branchLoginPageObjects.PasswordField_LoginPage(), "Email Field", "123" + getRandomNumber());
        String inputtedPassword = getValue(branchLoginPageObjects.PasswordField_LoginPage());
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        click(branchLoginPageObjects.LoginButton_LoginPage(), "Login Button");
        LoggingUtils.info("Correct Email  is norberto.dano@mlhuillier.com and input is " + inputtedEmail);
        LoggingUtils.info("Correct Password is 123456q@ and input is " + inputtedPassword);
        waitSleep(1000);

        if (isVisible(branchLoginPageObjects.GSuiteNotification_LoginPage(), "Invalid Email and Password Notification")) {
            ExtentReporter.logPass("IncorrectEmailAndPassword_Login", "Incorrect Email and Password Check: Successful");
        } else{
            ExtentReporter.logFail("IncorrectEmailAndPassword_Login", "Incorrect Password Check: Failed");
            Assert.fail("Failed Checking Invalid Email and Password.");
        }
    }

    //Login_002 > AL_005
    public void BlankInputs_Login() {
        type(branchLoginPageObjects.EmailField_LoginPage(), "Email Field", "");
        String inputtedEmail = getValue(branchLoginPageObjects.EmailField_LoginPage());
        type(branchLoginPageObjects.PasswordField_LoginPage(), "Email Field", "");
        String inputtedPassword = getValue(branchLoginPageObjects.PasswordField_LoginPage());
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        click(branchLoginPageObjects.LoginButton_LoginPage(), "Login Button");
        LoggingUtils.info("Correct Email  is norberto.dano@mlhuillier.com and input is " + inputtedEmail);
        LoggingUtils.info("Correct Password is 123456q@ and input is " + inputtedPassword);
        waitSleep(1000);

        if (isVisible(branchLoginPageObjects.InputPasswordandEmailNotification_LoginPage(), "No Input Notification")) {
            ExtentReporter.logPass("BlankInputs_Login", "No Input Check: Successful");
        } else{
            ExtentReporter.logFail("BlankInputs_Login", "No Input Check: Failed");
            Assert.fail("Failed Checking Error Without any Inputs");
        }
    }


    //FP_001 > AL_006
    public void PasswordChange_PhoneNumber_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09929171539");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","1123456q@1011");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456q@1011");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        waitSleep(1000);
        OTP("branch login");
        click(branchLoginPageObjects.VerifyButton_OTP(),"Verify Button");

        if (isVisible(branchLoginPageObjects.SuccessChange_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("PasswordChange_PhoneNumber_ForgotPassword", getText(branchLoginPageObjects.SuccessChange_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordChange_PhoneNumber_ForgotPassword", "Failed to Change Password Using Phone Number");
            Assert.fail("Failed Changing Password Using Phone Number");
        }

        waitSleep(2500);
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09999999999");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456q@");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456q@");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        waitSleep(1000);
        OTP("branch login");
        click(branchLoginPageObjects.VerifyButton_OTP(),"Verify Button");

        if (isVisible(branchLoginPageObjects.SuccessChange_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("Phone Number: Change Password", getText(branchLoginPageObjects.SuccessChange_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordChange_PhoneNumber_ForgotPassword", "Failed to Change Password Using Phone Number");
            Assert.fail("Failed Changing Password Using Phone Number");
        }
    }

    //FP_001 > AL_007
    public void PasswordChange_Email_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","norberto.dano@mlhuillier.com");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456q@1011");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","1123456q@1011");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        waitSleep(1000);
        OTP("branch login");
        click(branchLoginPageObjects.VerifyButton_OTP(),"Verify Button");

        if (isVisible(branchLoginPageObjects.SuccessChange_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("PasswordChange_Email_ForgotPassword", getText(branchLoginPageObjects.SuccessChange_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordChange_Email_ForgotPassword", "Failed to Change Password Using Email");
            Assert.fail("Failed Changing Password Using Email");
        }

        waitSleep(2500);
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","norberto.dano@mlhuillier.com");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456q@");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456q@");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        waitSleep(1000);
        OTP("branch login");
        click(branchLoginPageObjects.VerifyButton_OTP(),"Verify Button");

        if (isVisible(branchLoginPageObjects.SuccessChange_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("PasswordChange_Email_ForgotPassword", getText(branchLoginPageObjects.SuccessChange_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordChange_Email_ForgotPassword", "Failed to Change Password Using Email");
            Assert.fail("Failed Changing Password Using Email");
        }
    }

    //FP_002 > AL_008
    public void UnregisteredEmail_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","merry.ajoc@mlhuillier.com");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        if (isVisible(branchLoginPageObjects.StatusMessage_ForgetPassword(), "Unregistered Email Notification")) {
            ExtentReporter.logPass("UnregisteredEmail_ForgotPassword", getText(branchLoginPageObjects.StatusMessage_ForgetPassword()));
        } else{
            ExtentReporter.logFail("UnregisteredEmail_ForgotPassword", "Failed Verifying Email");
            Assert.fail("Failed Verifying Email");
        }
    }

    //FP_002 > AL_009
    public void UnregisteredNumber_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","097987564321");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        if (isVisible(branchLoginPageObjects.StatusMessage_ForgetPassword(), "Unregistered Number Notification")) {
            ExtentReporter.logPass("IncorrectNumber_ForgotPassword", getText(branchLoginPageObjects.StatusMessage_ForgetPassword()));
        } else{
            ExtentReporter.logFail("IncorrectNumber_ForgotPassword", "Failed Verifying Number");
            Assert.fail("Failed Verifying Number");
        }
    }

    //FP_002 > AL_010
    public void ManyDigitNumberError_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","099999999999999999999");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        if (isVisible(branchLoginPageObjects.InvalidNumberNotification_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("ManyDigitNumberError_ForgotPassword", getText(branchLoginPageObjects.StatusMessage_ForgetPassword()));
        } else{
            ExtentReporter.logFail("ManyDigitNumberError_ForgotPassword", "Failed Verifying Number");
            Assert.fail("Failed Verifying Number");
        }
    }

    //FP_002 > AL_011
    public void NoInput_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        if (isVisible(branchLoginPageObjects.EnterAValidDataNotification_ForgetPassword(), "No Input Notification")) {
            ExtentReporter.logPass("NoInput_ForgotPassword", getText(branchLoginPageObjects.EnterAValidDataNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("NoInput_ForgotPassword", "No Inputs Unverified");
            Assert.fail("No Inputs Unverified");
        }
    }

    //FP_002 > AL_012
    public void PasswordDoNotMatch_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09929171539");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456q@");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456q@101");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        if (isVisible(branchLoginPageObjects.PasswordNotMatchNotification_ForgetPassword(), "The Passwords Doesn't Match Notification")) {
            ExtentReporter.logPass("PasswordDoNotMatch_ForgotPassword", getText(branchLoginPageObjects.PasswordNotMatchNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordDoNotMatch_ForgotPassword", "Failed to Validate Password");
            Assert.fail("Failed to Validate Password");
        }
    }

    //FP_002 > AL_013
    public void LessThan8DigitPassword_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09929171539");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        if (isVisible(branchLoginPageObjects.LessThan8CharacterNotification_ForgetPassword(), "The Passwords Has Less Characters Notification")) {
            ExtentReporter.logPass("LessThan8DigitPassword_ForgotPassword", getText(branchLoginPageObjects.LessThan8CharacterNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("LessThan8DigitPassword_ForgotPassword", "Failed to Validate Password");
            Assert.fail("Failed to Validate Password");
        }
    }

    //FP_002 > AL_014
    public void SameAsOldPassword_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09929171539");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456q@");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456q@");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        if (isVisible(branchLoginPageObjects.SimilarPasswordNotification_ForgetPassword(), "The Passwords Similarity Notification")) {
            ExtentReporter.logPass("SameAsOldPassword_ForgotPassword", getText(branchLoginPageObjects.SimilarPasswordNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("SameAsOldPassword_ForgotPassword", "Failed to Validate Password Similarity");
            Assert.fail("Failed to Validate Password Similarity");
        }
    }

    //FP_002 > AL_015
    public void OTPVerification_Number_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09929171539");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456q@1");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456q@1");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        OTP("branch login");
        click(branchLoginPageObjects.VerifyButton_OTP(),"Verify Code Button");
        if (isVisible(branchLoginPageObjects.InvalidOTPNotification_ForgetPassword(), "Invalid OTP Notification")) {
            ExtentReporter.logPass("OTPVerification_ForgotPassword", getText(branchLoginPageObjects.InvalidOTPNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("OTPVerification_ForgotPassword", "Failed to Validate OTP");
            Assert.fail("Failed to Validate OTP");
        }
    }


    //FP_002 > AL_016
    public void OTPVerification_Email_ForgotPassword() {
        click(branchLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(branchLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","norberto.dano@mlhuillier.com");
        click(branchLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(branchLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456q@1");
        type(branchLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","1123456q@1");
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(branchLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        OTP("branch login");
        click(branchLoginPageObjects.VerifyButton_OTP(),"Verify Code Button");
        if (isVisible(branchLoginPageObjects.InvalidOTPNotification_ForgetPassword(), "Invalid OTP Notification")) {
            ExtentReporter.logPass("OTPVerification_ForgotPassword", getText(branchLoginPageObjects.InvalidOTPNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("OTPVerification_ForgotPassword", "Failed to Validate OTP");
            Assert.fail("Failed to Validate OTP");
        }
    }

    //SP_001 > AL_017
    public void PasswordVisibility_Login() {
        type(branchLoginPageObjects.EmailField_LoginPage(), "Email Field", "norberto.dano@mlhuillier.com");
        type(branchLoginPageObjects.PasswordField_LoginPage(), "Email Field", "123" + getRandomNumber());
        String inputtedPassword = getValue(branchLoginPageObjects.PasswordField_LoginPage());
        click(branchLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");

        assertEqual(getValue(branchLoginPageObjects.PasswordField_LoginPage()), inputtedPassword);

        LoggingUtils.info("Password Visibility: Successful");


    }

}
//        waitSleep(4000);
//        ((JavascriptExecutor)driver).executeScript("window.open('https://mlshoppreprod.mlhuillier.com/admin');");
//
//        waitSleep(4000);
//        ((JavascriptExecutor)driver).executeScript("window.open('https://mlshoppreprod.mlhuillier.com');");
//        waitSleep(4000);
