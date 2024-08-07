package MLShop.actualBranch;

import MLShop.base.BaseTest;
import org.testng.annotations.Test;

public class Login extends BaseTest {

    //LogIn_001
    @Test(priority = 0, description = "Successful Login: Validate Branch Log In")
    public  void Branch_Login() throws Exception{
        branchLoginSteps.Branch_Login();
    }

    //Login_002
    @Test(priority = 1,  description = "Invalid Login: Incorrect Email Check")
    public  void IncorrectEmail_Login() throws Exception{
        branchLoginSteps.IncorrectEmail_Login();
    }
    @Test(priority = 2,  description = "Invalid Login: Incorrect Password Check")
    public  void IncorrectPassword_Login() throws Exception{
        branchLoginSteps.IncorrectPassword_Login();
    }
    @Test(priority = 3,  description = "Invalid Login: Incorrect Email and Password Check")
    public  void IncorrectEmailAndPassword_Login() throws Exception{
        branchLoginSteps.IncorrectEmailAndPassword_Login();
    }
    @Test(priority = 4,  description = "Invalid Login: Blank Inputs Check")
    public  void BlankInputs_Login() throws Exception{
        branchLoginSteps.BlankInputs_Login();
    }

    //FP_001
//    failed due to number cannot go through without OTP
//    @Test(priority = 5,  description = "Password Change Using Phone Number")
//    public  void PasswordChange_PhoneNumber_ForgotPassword() throws Exception{
//        branchLoginSteps.PasswordChange_PhoneNumber_ForgotPassword();
//    }
//    @Test(priority = 6,  description = "Password Change Using Email")
//    public  void PasswordChange_Email_ForgotPassword() throws Exception{
//        branchLoginSteps.PasswordChange_Email_ForgotPassword();
//    }

    //FP_002
    @Test(priority = 7,  description = "Unable to Log in due to unknown Email")
    public  void UnregisteredEmail_ForgotPassword() throws Exception{
        branchLoginSteps.UnregisteredEmail_ForgotPassword();
    }
    @Test(priority = 8,  description = "Unable to Log in due to unknown Number")
    public  void UnregisteredNumber_ForgotPassword() throws Exception{
        branchLoginSteps.UnregisteredNumber_ForgotPassword();
    }
    @Test(priority = 9,  description = "Many Digits Number Error.")
    public  void ManyDigitNumberError_ForgotPassword() throws Exception{
        branchLoginSteps.ManyDigitNumberError_ForgotPassword();
    }
    @Test(priority = 10,  description = "No Number Input Check")
    public  void NoInput_ForgotPassword() throws Exception{
        branchLoginSteps.NoInput_ForgotPassword();
    }
    @Test(priority = 11,  description = "Password Does Not Match Check")
    public  void PasswordDoNotMatch_ForgotPassword() throws Exception{
        branchLoginSteps.PasswordDoNotMatch_ForgotPassword();
    }
    @Test(priority = 12,  description = "Password Less Than 8 Characters Check")
    public  void LessThan8DigitPassword_ForgotPassword() throws Exception{
        branchLoginSteps.LessThan8DigitPassword_ForgotPassword();
    }
    @Test(priority = 13,  description = "Same As Old Password Check")
    public  void SameAsOldPassword_ForgotPassword() throws Exception{
        branchLoginSteps.SameAsOldPassword_ForgotPassword();
    }
    @Test(priority = 14,  description = "OTP Verification Check (Number)")
    public  void OTPVerification_Number_ForgotPassword() throws Exception{
        branchLoginSteps.OTPVerification_Number_ForgotPassword();
    }
//    @Test(priority = 15,  description = "OTP Verification Check (Email)")
//    public  void OTPVerification_Email_ForgotPassword() throws Exception{
//        branchLoginSteps.OTPVerification_Email_ForgotPassword();
//    }

    //SP_001
    @Test(priority = 16, description = "Validating Visibility of Password")
    public  void PasswordVisibility_Login() throws Exception{
        branchLoginSteps.PasswordVisibility_Login();
    }

}
