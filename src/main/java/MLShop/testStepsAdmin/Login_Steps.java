package MLShop.testStepsAdmin;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Login_Steps extends MLShop.testStepsAdmin.Base_Steps {

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
        click(adminLoginPageObjects.UserAvatar_Icon_HomePage(),"User Avatar");
        waitSleep(1000);
        click(adminLoginPageObjects.UserAvatar_LogoutButton_HomePage(),"User Log Out");
        waitSleep(1000);
    }

    public void OTP(String role){
        type(adminLoginPageObjects.VerificationCode1_OTP(),"1","1");
        type(adminLoginPageObjects.VerificationCode2_OTP(),"1","1");
        type(adminLoginPageObjects.VerificationCode3_OTP(),"1","1");
        type(adminLoginPageObjects.VerificationCode4_OTP(),"1","1");
        type(adminLoginPageObjects.VerificationCode5_OTP(),"1","1");
        type(adminLoginPageObjects.VerificationCode6_OTP(),"1","1");
    }

    //Test Cases
    //Login_001 >AL_001
    public void Admin_Login() {
        loginByRole("login");

        if (isVisible(adminLoginPageObjects.UserIcon_Header(), "User Icon") &&
                isVisible(adminLoginPageObjects.Notification_Header(), "Notification Header") &&
                isVisible(adminLoginPageObjects.MLSHOPADMIN_Header(), "ML Shop Admin Header") &&
                isVisible(adminLoginPageObjects.MLHUILLIERSideBarLogo_Header(), "ML Logo") &&
                isVisible(adminLoginPageObjects.TotalSales_Dashboard(), "Total Sales Graph") &&
                isVisible(adminLoginPageObjects.ReturningCustomerRate_Dashboard(), "Returning Customer Rate Graph") &&
                isVisible(adminLoginPageObjects.AverageOrderValue_Dashboard(), "Average Order Value Graph") &&
                isVisible(adminLoginPageObjects.TotalOrders_Dashboard(), "Total Orders Graph") &&
                isVisible(adminLoginPageObjects.TopProductsByUnitsSold_Dashboard(), "Top Products By Unit Sold Graph")) {
            ExtentReporter.logPass("AL_001", "Admin Log In: Successful");
            waitSleep(1000);
            logoutByRole("login");
        } else {
            ExtentReporter.logFail("AL_001", "Admin Log In: Failed");
            Assert.fail("Failed Logging In.");
        }
    }

    //Login_002 > AL_002
    public void IncorrectEmail_Login() {

        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", "norberto.danosaur.com");
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", "123456789");
        String inputtedEmail = getValue(adminLoginPageObjects.EmailField_LoginPage());
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        click(adminLoginPageObjects.LoginButton_LoginPage(), "Login Button");
        LoggingUtils.info("Correct Email is norberto.dano@mlhuillier.com" + inputtedEmail);
        waitSleep(1000);

        if (isVisible(adminLoginPageObjects.InvalidLoginNotification_LoginPage(), "Invalid Username Notification")) {
            ExtentReporter.logPass("AL_002", "Incorrect Email Check: Successful");
        } else{
            ExtentReporter.logFail("AL_002", "Incorrect Email Check: Failed");
            Assert.fail("Failed Checking Invalid Email.");
        }
    }

   //Login_002 > AL_003
    public void IncorrectPassword_Login() {
        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", "norberto.dano@mlhuillier.com");
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", "123" + getRandomNumber());
        String inputtedPassword = getValue(adminLoginPageObjects.PasswordField_LoginPage());
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        click(adminLoginPageObjects.LoginButton_LoginPage(), "Login Button");
        LoggingUtils.info("Correct Password is 123456789 and input is " + inputtedPassword);
        waitSleep(1000);

        if (isVisible(adminLoginPageObjects.InvalidLoginNotification_LoginPage(), "Invalid Password Notification")) {
            ExtentReporter.logPass("IncorrectPassword_Login", "Incorrect Password Check: Successful");
        } else{
            ExtentReporter.logFail("IncorrectPassword_Login", "Incorrect Password Check: Failed");
            Assert.fail("Failed Checking Invalid Password.");
        }
    }

    //Login_002 > AL_004
    public void IncorrectEmailAndPassword_Login() {
        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", "norberto.danosaur.com");
        String inputtedEmail = getValue(adminLoginPageObjects.EmailField_LoginPage());
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", "123" + getRandomNumber());
        String inputtedPassword = getValue(adminLoginPageObjects.PasswordField_LoginPage());
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        click(adminLoginPageObjects.LoginButton_LoginPage(), "Login Button");
        LoggingUtils.info("Correct Email  is norberto.dano@mlhuillier.com and input is " + inputtedEmail);
        LoggingUtils.info("Correct Password is 123456789 and input is " + inputtedPassword);
        waitSleep(1000);

        if (isVisible(adminLoginPageObjects.InvalidLoginNotification_LoginPage(), "Invalid Email and Password Notification")) {
            ExtentReporter.logPass("IncorrectEmailAndPassword_Login", "Incorrect Email and Password Check: Successful");
        } else{
            ExtentReporter.logFail("IncorrectEmailAndPassword_Login", "Incorrect Password Check: Failed");
            Assert.fail("Failed Checking Invalid Email and Password.");
        }
    }

    //Login_002 > AL_005
    public void BlankInputs_Login() {
        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", "");
        String inputtedEmail = getValue(adminLoginPageObjects.EmailField_LoginPage());
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", "");
        String inputtedPassword = getValue(adminLoginPageObjects.PasswordField_LoginPage());
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");
        click(adminLoginPageObjects.LoginButton_LoginPage(), "Login Button");
        LoggingUtils.info("Correct Email  is norberto.dano@mlhuillier.com and input is " + inputtedEmail);
        LoggingUtils.info("Correct Password is 123456789 and input is " + inputtedPassword);
        waitSleep(1000);

        if (isVisible(adminLoginPageObjects.NoInputNotification_LoginPage(), "No Input Notification")) {
            ExtentReporter.logPass("BlankInputs_Login", "No Input Check: Successful");
        } else{
            ExtentReporter.logFail("BlankInputs_Login", "No Input Check: Failed");
            Assert.fail("Failed Checking Error Without any Inputs");
        }
    }


    //FP_001 > AL_006
    public void PasswordChange_PhoneNumber_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09999999999");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","1234567891011");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","1234567891011");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        waitSleep(1000);
        OTP("admin");
        click(adminLoginPageObjects.VerifyButton_OTP(),"Verify Button");

        if (isVisible(adminLoginPageObjects.SuccessChange_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("PasswordChange_PhoneNumber_ForgotPassword", getText(adminLoginPageObjects.SuccessChange_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordChange_PhoneNumber_ForgotPassword", "Failed to Change Password Using Phone Number");
            Assert.fail("Failed Changing Password Using Phone Number");
        }

        waitSleep(2500);
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09999999999");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456789");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456789");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        waitSleep(1000);
       OTP("admin");
        click(adminLoginPageObjects.VerifyButton_OTP(),"Verify Button");

        if (isVisible(adminLoginPageObjects.SuccessChange_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("Phone Number: Change Password", getText(adminLoginPageObjects.SuccessChange_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordChange_PhoneNumber_ForgotPassword", "Failed to Change Password Using Phone Number");
            Assert.fail("Failed Changing Password Using Phone Number");
        }
    }

    //FP_001 > AL_007
    public void PasswordChange_Email_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","norberto.dano@mlhuillier.com");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","1234567891011");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","1234567891011");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        waitSleep(1000);
        OTP("admin");
        click(adminLoginPageObjects.VerifyButton_OTP(),"Verify Button");

        if (isVisible(adminLoginPageObjects.SuccessChange_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("PasswordChange_Email_ForgotPassword", getText(adminLoginPageObjects.SuccessChange_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordChange_Email_ForgotPassword", "Failed to Change Password Using Email");
            Assert.fail("Failed Changing Password Using Email");
        }

        waitSleep(2500);
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","norberto.dano@mlhuillier.com");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456789");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456789");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        waitSleep(1000);
        OTP("admin");
        click(adminLoginPageObjects.VerifyButton_OTP(),"Verify Button");

        if (isVisible(adminLoginPageObjects.SuccessChange_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("PasswordChange_Email_ForgotPassword", getText(adminLoginPageObjects.SuccessChange_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordChange_Email_ForgotPassword", "Failed to Change Password Using Email");
            Assert.fail("Failed Changing Password Using Email");
        }
    }

    //FP_002 > AL_008
    public void UnregisteredEmail_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","merry.ajoc@mlhuillier.com");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        if (isVisible(adminLoginPageObjects.StatusMessage_ForgetPassword(), "Unregistered Email Notification")) {
            ExtentReporter.logPass("UnregisteredEmail_ForgotPassword", getText(adminLoginPageObjects.StatusMessage_ForgetPassword()));
        } else{
            ExtentReporter.logFail("UnregisteredEmail_ForgotPassword", "Failed Verifying Email");
            Assert.fail("Failed Verifying Email");
        }
    }

    //FP_002 > AL_009
    public void UnregisteredNumber_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","097987564321");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        if (isVisible(adminLoginPageObjects.StatusMessage_ForgetPassword(), "Unregistered Number Notification")) {
            ExtentReporter.logPass("IncorrectNumber_ForgotPassword", getText(adminLoginPageObjects.StatusMessage_ForgetPassword()));
        } else{
            ExtentReporter.logFail("IncorrectNumber_ForgotPassword", "Failed Verifying Number");
            Assert.fail("Failed Verifying Number");
        }
    }

    //FP_002 > AL_010
    public void ManyDigitNumberError_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","099999999999999999999");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        if (isVisible(adminLoginPageObjects.InvalidNumberNotification_ForgetPassword(), "Password Change Notification")) {
            ExtentReporter.logPass("ManyDigitNumberError_ForgotPassword", getText(adminLoginPageObjects.StatusMessage_ForgetPassword()));
        } else{
            ExtentReporter.logFail("ManyDigitNumberError_ForgotPassword", "Failed Verifying Number");
            Assert.fail("Failed Verifying Number");
        }
    }

    //FP_002 > AL_011
    public void NoInput_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        if (isVisible(adminLoginPageObjects.EnterAValidDataNotification_ForgetPassword(), "No Input Notification")) {
            ExtentReporter.logPass("NoInput_ForgotPassword", getText(adminLoginPageObjects.EnterAValidDataNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("NoInput_ForgotPassword", "No Inputs Unverified");
            Assert.fail("No Inputs Unverified");
        }
    }

    //FP_002 > AL_012
    public void PasswordDoNotMatch_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09999999999");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456789");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456789101");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        if (isVisible(adminLoginPageObjects.PasswordNotMatchNotification_ForgetPassword(), "The Passwords Doesn't Match Notification")) {
            ExtentReporter.logPass("PasswordDoNotMatch_ForgotPassword", getText(adminLoginPageObjects.PasswordNotMatchNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("PasswordDoNotMatch_ForgotPassword", "Failed to Validate Password");
            Assert.fail("Failed to Validate Password");
        }
    }

    //FP_002 > AL_013
    public void LessThan8DigitPassword_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09999999999");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        if (isVisible(adminLoginPageObjects.LessThan8CharacterNotification_ForgetPassword(), "The Passwords Has Less Characters Notification")) {
            ExtentReporter.logPass("LessThan8DigitPassword_ForgotPassword", getText(adminLoginPageObjects.LessThan8CharacterNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("LessThan8DigitPassword_ForgotPassword", "Failed to Validate Password");
            Assert.fail("Failed to Validate Password");
        }
    }

    //FP_002 > AL_014
    public void SameAsOldPassword_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09999999999");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","123456789");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","123456789");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        if (isVisible(adminLoginPageObjects.SimilarPasswordNotification_ForgetPassword(), "The Passwords Similarity Notification")) {
            ExtentReporter.logPass("SameAsOldPassword_ForgotPassword", getText(adminLoginPageObjects.SimilarPasswordNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("SameAsOldPassword_ForgotPassword", "Failed to Validate Password Similarity");
            Assert.fail("Failed to Validate Password Similarity");
        }
    }

    //FP_002 > AL_015
    public void OTPVerification_Number_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","09929171539");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","1234567891");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","1234567891");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        OTP("admin");
        click(adminLoginPageObjects.VerifyButton_OTP(),"Verify Code Button");
        if (isVisible(adminLoginPageObjects.InvalidOTPNotification_ForgetPassword(), "Invalid OTP Notification")) {
            ExtentReporter.logPass("OTPVerification_ForgotPassword", getText(adminLoginPageObjects.InvalidOTPNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("OTPVerification_ForgotPassword", "Failed to Validate OTP");
            Assert.fail("Failed to Validate OTP");
        }
    }


    //FP_002 > AL_016
    public void OTPVerification_Email_ForgotPassword() {
        click(adminLoginPageObjects.ForgotPasswordButton_LoginPage(),"Forgot Password Hyperlink Button");
        type(adminLoginPageObjects.Email_NumberTextbox_ForgetPassword(),"Email/Number Textbox","norberto.dano@mlhuillier.com");
        click(adminLoginPageObjects.ContinueButton_ForgetPassword(),"Continue Button");

        type(adminLoginPageObjects.NewPassword_ForgetPassword(),"New Password","1234567891");
        type(adminLoginPageObjects.ConfirmPassword_ForgetPassword(),"Confirm Password","1234567891");
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(),"Show Password");
        click(adminLoginPageObjects.ResetPasswordButton_ForgetPassword(),"Reset Password");

        OTP("admin");
        click(adminLoginPageObjects.VerifyButton_OTP(),"Verify Code Button");
        if (isVisible(adminLoginPageObjects.InvalidOTPNotification_ForgetPassword(), "Invalid OTP Notification")) {
            ExtentReporter.logPass("OTPVerification_ForgotPassword", getText(adminLoginPageObjects.InvalidOTPNotification_ForgetPassword()));
        } else{
            ExtentReporter.logFail("OTPVerification_ForgotPassword", "Failed to Validate OTP");
            Assert.fail("Failed to Validate OTP");
        }
    }

    //SP_001 > AL_017
    public void PasswordVisibility_Login() {
        type(adminLoginPageObjects.EmailField_LoginPage(), "Email Field", "norberto.dano@mlhuillier.com");
        type(adminLoginPageObjects.PasswordField_LoginPage(), "Email Field", "123" + getRandomNumber());
        String inputtedPassword = getValue(adminLoginPageObjects.PasswordField_LoginPage());
        click(adminLoginPageObjects.PasswordVisibility_LoginPage(), "Password Visibility Checkbox");

        assertEqual(getValue(adminLoginPageObjects.PasswordField_LoginPage()), inputtedPassword);

        LoggingUtils.info("Password Visibility: Successful");
    }














































































}

