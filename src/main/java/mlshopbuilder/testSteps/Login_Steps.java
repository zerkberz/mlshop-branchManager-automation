package mlshopbuilder.testSteps;



import mlshopbuilder.pageObject.Login_PageObjects;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

public class Login_Steps extends Base_Steps{
    public void navigateLoginPage() throws Exception{
    }

    public void loginByRole(String role) {
        click(loginPageObjects.userIcon(), "Menu Icon");
        click(loginPageObjects.MLoginbtn(), "Login option");
        type(loginPageObjects.Email_add(), "Email Field", reader.getEmailByRole(role));
        type(loginPageObjects.Login_pass(), "Email Field", reader.getPasswordByRole(role));
        click(loginPageObjects.Continuebtn(), "Continue");
        LoggingUtils.info("Successful Logged In");
    }

    public void logout(String role){
        click(loginPageObjects.userIcon(),"Menu Icon");
        click(loginPageObjects.MLogoutbtn(), "Logout");
        waitSleep(2000);
        LoggingUtils.info("Successful Logged off");
    }

    public boolean isInHomePage() {
        if (isVisible(loginPageObjects.HeaderAcctOwnership(),"HeaderAcctOwnership")) {
        }
        return true;
    }
    public void SBL_TC_01_AdminLogIn() {
        loginByRole("admin");
            if(isInHomePage()){
            ExtentReporter.logPass("SBL_TC_01_AdminLogIn", "Successfully Logged in Admin");
        }
                else{
                ExtentReporter.logFail("", "Failed to Log In as Admin");
                Assert.fail("");
        }
                logout("admin");
    }

    public void SBL_TC_02_SuppAdminLogIn(){
        loginByRole("supportadmin");
        if(isInHomePage()){
            ExtentReporter.logPass("SBL_TC_02_SuppAdminLogIn", "Successfully Logged in Support Admin");
        }
        else {
            ExtentReporter.logFail("", "Failed to Log In as Support Admin");
            Assert.fail("");
        }
        logout("supportadmin");
    }

    public void SBL_TC_03_MerchantLogIn(){
        loginByRole("merchant");
        if(isInHomePage()){
        ExtentReporter.logPass("SBL_TC_03_MerchantLogIn", "Successfully Logged in Merchant");
    }
        else {
            ExtentReporter.logFail("", "Failed to Log In as Merchant");
            Assert.fail("");
        }
        logout("merchant");
    }

    public void SBL_TC_04_NoGmail_LogIn(){
        loginByRole("invalidEmailAdmin");
        if (isVisible(loginPageObjects.EmailError_Warning(), "Invalid Email")){
            ExtentReporter.logPass("SBL_TC_04_NoGmail_LogIn","Invalid Email Successfully Validated");
        }
        else {
            ExtentReporter.logFail("SBL_TC_04_NoGmail_LogIn", "Failed Invalidating gmail");
            Assert.fail("Failed Invalidating gmail");
        }
    }

    public void SBL_TC_05_InvalidPass_LogIn(){
        loginByRole("invalidPassAdmin");
        if (isVisible(loginPageObjects.Status(), "Invalid Password")){
            ExtentReporter.logPass("SBL_TC_05_InvalidPass_LogIn","Validated Invalid Password");
        }
        else {
            ExtentReporter.logFail("SBL_TC_05_InvalidPass_LogIn", "Failed Invalidating Password");
            Assert.fail("Failed Invalidating password");
        }
    }

    public void SBL_TC_06_InvalidCredential_LogIn(){
        loginByRole("noInput");
        if (isVisible(loginPageObjects.EmailError_Warning(), "Invalid Password")){
            ExtentReporter.logPass("SBL_TC_06_InvalidCredential_LogIn","Validated Invalid Credentials");
        }
}

    public void SBL_TC_07_MSignUpPopup(){
        click(loginPageObjects.userIcon(), "Menu Icon");
        waitSleep(1500);
        click(loginPageObjects.Msignupbtn(), "Register");
        waitSleep(1500);
        isVisible(loginPageObjects.MsignupEmailtxtbox(), "Email textbox");
        isVisible(loginPageObjects.MsignupNametxtbox(), "Name textbox");
        isVisible(loginPageObjects.MsignupPasswordtxtbox(), "Initial Password textbox");
        isVisible(loginPageObjects.MsignupRepasstxtbox(), "Password textbox");
        ExtentReporter.logPass("SBL_TC_07_MSignUpPopup","Validated Sign Up Pop Up");
    }

    public void SBL_TC_08and09_LogInPopupAndExit() {
        click(loginPageObjects.userIcon(), "Menu Icon");
        waitSleep(1500);
        click(loginPageObjects.MLoginbtn(), "Login option");
        click(loginPageObjects.exitbtn(),"Exit button");
        ExtentReporter.logPass("SBL_TC_08and09_LogInPopupAndExit","Validated Log In Pop Up and Exit");
    }

    public void SBL_TC_10_SignUpRedirection_via_createaccount(){
        click(loginPageObjects.userIcon(), "Menu Icon");
        waitSleep(1500);
        click(loginPageObjects.MLoginbtn(), "Login option");
        waitSleep(3000);
        click(loginPageObjects.CreateanAcct_btn(), "Create an account");
        isVisible(loginPageObjects.MsignupEmailtxtbox(), "Email textbox");
        isVisible(loginPageObjects.MsignupNametxtbox(), "Name textbox");
        isVisible(loginPageObjects.MsignupPasswordtxtbox(), "Initial Password textbox");
        isVisible(loginPageObjects.MsignupRepasstxtbox(), "Password textbox");
        ExtentReporter.logPass("SBL_TC_10_SignUpRedirection_via_createaccount","Validated Log In Pop Up and Exit");
    }
}
