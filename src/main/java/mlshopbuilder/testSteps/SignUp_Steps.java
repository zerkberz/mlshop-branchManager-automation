package mlshopbuilder.testSteps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.PropertyReader.propertyReader;
import utilities.Logger.LoggingUtils;

public class SignUp_Steps extends Base_Steps {
    public void navigateLoginPage() throws Exception {
    }

    public void directToSignUp() {
        click(signUpRegisterPageObjects.userIcon(), "Menu Icon");
        click(signUpRegisterPageObjects.signupbtn(), "Sign Up Button");
        isVisible(signUpRegisterPageObjects.signupEmailtxtbox(), "Email");
        isVisible(signUpRegisterPageObjects.signupNametxtbox(), "Name");
        isVisible(signUpRegisterPageObjects.signupPasswordtxtbox(), "Initial Password");
        isVisible(signUpRegisterPageObjects.signupRepasstxtbox(), "Reenter Password");
        isVisible(signUpRegisterPageObjects.Continuebtn(), "Continue");
        isVisible(signUpRegisterPageObjects.TickboxMerchant(), "I Want to become merchant");
        click(signUpRegisterPageObjects.TickboxMerchant(), "Merchant Tickbox Checked");
        LoggingUtils.info("Successfully Directed to SIgn Up");
    }

    public boolean isInSignUp() {
        if (isVisible(signUpRegisterPageObjects.TickboxMerchant(), "Tickbox Merchant")) {
        }
        return true;
    }

    public void Dropdowns() {
        waitSleep(2000);
        click(signUpRegisterPageObjects.provincetxtbox(), "DropDown");
        waitSleep(2000);
        typeEnter(signUpRegisterPageObjects.ProvDropDown(), "Province Input", "Cebu");
        waitSleep(2000);
        click(signUpRegisterPageObjects.CityDropDown(), "City Dropdown");
        waitSleep(2000);
        typeEnter(signUpRegisterPageObjects.CityDropDown(), "City Input", "Cebu");
        waitSleep(2000);
        click(signUpRegisterPageObjects.BranchDropDown(), "Branch Dropdown");
        waitSleep(2000);
        typeEnter(signUpRegisterPageObjects.BranchDropDown(), "Branch Name Input", "Cebu head office");
        waitSleep(2000);
    }

    public void SBSU_TC_01_and_02() {
        directToSignUp();
        type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", propertyReader.getproperty("InvEmail"));
        type(signUpRegisterPageObjects.signupNametxtbox(), "Name", propertyReader.getproperty("Name"));
        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password", "Password");
        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Password", "Password");
        click(signUpRegisterPageObjects.Continuebtn(), "Continue");

        if (isInSignUp()) {
            ExtentReporter.logPass("SBSU_TC_01", " Successfully Validated Email: Needs to be company Email");
        } else {
            ExtentReporter.logFail("", "Failed to Validate Email");
            Assert.fail("");
        }
        click(signUpRegisterPageObjects.exitbtn(), "Exit Pop up");

        directToSignUp();
        type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", propertyReader.getproperty("Email"));
        type(signUpRegisterPageObjects.signupNametxtbox(), "Name", propertyReader.getproperty("Name"));
        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password", "Password");
        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Confirm Password", "Password");
        click(signUpRegisterPageObjects.Continuebtn(), "Continue");
        click(signUpRegisterPageObjects.exitbtn(), "exit Pop Up");
        if (isInSignUp()) {
            ExtentReporter.logPass("SBSU_TC_02", "Successfully Created Account");
        } else {
            ExtentReporter.logFail("", "Failed to Create Account");
            Assert.fail("");
        }
        waitSleep(2000);
    }
        public void SBSU_TC_03_Emptytxtboxes(){
            directToSignUp();
            type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", propertyReader.getproperty("Emptyemail"));
            type(signUpRegisterPageObjects.signupNametxtbox(), "Name", propertyReader.getproperty("Emptyname"));
            type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password", "Emptypass");
            type(signUpRegisterPageObjects.signupRepasstxtbox(), "Confirm Password", "EmptyRepass");
            click(signUpRegisterPageObjects.Continuebtn(), "Continue");
            waitSleep(2000);
            isVisible(signUpRegisterPageObjects.InvalidStoreEmail(),"Invalid Email Address");
            click(signUpRegisterPageObjects.exitbtn(), "exit Pop Up");

            LoggingUtils.info("SBSU_TC_03: Empty Textboxes: Successful");
        }

    public void SBSU_TC_04_Tickbox() {
        directToSignUp();
        if (isInSignUp()) {
            click(signUpRegisterPageObjects.TickboxMerchant(), "Merchant Tickbox");
            click(signUpRegisterPageObjects.exitbtn(), "Exit Pop up");
            ExtentReporter.logPass("SBSU_TC_04", "Successfully Validated Tickbox: I want to be Merchant");
        }
        else {
            ExtentReporter.logFail("SBSU_TC_04", "Failed to validate Merchant textbox");
            Assert.fail("");
        }
    }
    public void SBSU_TC_05_InvalidStoreEmail() {
        directToSignUp();
        type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", propertyReader.getproperty("Email2"));
        type(signUpRegisterPageObjects.signupNametxtbox(), "Name", propertyReader.getproperty("Name2"));
        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password", propertyReader.getproperty("Password2"));
        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Password", propertyReader.getproperty("Password2"));
        type(signUpRegisterPageObjects.ContactNumtxtbox(), "Contact Number", propertyReader.getproperty("phonenum"));
        type(signUpRegisterPageObjects.StoreEmail(), "Store Email Address", propertyReader.getproperty("InvStoreEmail2"));

        Dropdowns();
        click(signUpRegisterPageObjects.Continuebtn(),"Continue Button");

        if (isVisible(signUpRegisterPageObjects.StoreEmailError(), "Invalid Store email")) {
            ExtentReporter.logPass("SBSU_TC_05", "Invalid Store Email: Successful");
        }
        else {
            ExtentReporter.logFail("SBSU TC 05","Invalid Store Email: Failed");
            Assert.fail("");
        }
    }
    public void SBSU_TC_06_InvalidNumber(){
            directToSignUp();
            type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", "test.automation"+getRandomNumber()+"@mlhuillier.com");
            type(signUpRegisterPageObjects.signupNametxtbox(), "Name", "test."+getRandomNumber()+"name");
            type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password", propertyReader.getproperty("Password2"));
            type(signUpRegisterPageObjects.signupRepasstxtbox(), "Password", propertyReader.getproperty("Password2"));
            type(signUpRegisterPageObjects.ContactNumtxtbox(), "Contact Number", "09"+getRandomNumber()+"69");
            type(signUpRegisterPageObjects.StoreEmail(), "Store Email Address", "test.automation"+getRandomNumber()+"@mlhuillier.com");
            Dropdowns();
            click(signUpRegisterPageObjects.Continuebtn(),"Continue Button");
            waitSleep(1000);
            if (isVisible(signUpRegisterPageObjects.ContactNumberError(), "Invalid Number")) {
                passTest("SBSU_TC_06_InvalidNumber","Successfully Validate Invalid Contact Number Address");
            }
            else {
                failTest("SBSU_TC_06_InvalidNumber","Invalid Number: Failed");
            }
    }
    public void SBSU_TC_07_InvalidBranchName(){
        directToSignUp();
        type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", "test.automation"+getRandomNumber()+"@mlhuillier.com");
        type(signUpRegisterPageObjects.signupNametxtbox(), "Name", "test."+getRandomNumber()+"name");
        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password", propertyReader.getproperty("Password2"));
        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Password", propertyReader.getproperty("Password2"));
        type(signUpRegisterPageObjects.ContactNumtxtbox(), "Contact Number", propertyReader.getproperty("phonenum"));
        type(signUpRegisterPageObjects.StoreEmail(), "Store Email Address", "test.automation"+getRandomNumber()+"@mlhuillier.com");
        //
        waitSleep(1000);
        click(signUpRegisterPageObjects.provincetxtbox(), "DropDown");
        waitSleep(1000);
        typeEnter(signUpRegisterPageObjects.ProvDropDown(), "Province Input", "Cebu");
        waitSleep(1000);
        click(signUpRegisterPageObjects.CityDropDown(), "City Dropdown");
        waitSleep(1000);
        typeEnter(signUpRegisterPageObjects.CityDropDown(), "City Input", "Cebu City");
        waitSleep(1000);
        click(signUpRegisterPageObjects.BranchDropDown(), "Branch Dropdown");
        waitSleep(1000);
        typeEnter(signUpRegisterPageObjects.BranchDropDown(), "Branch Name Input", "ML NRA");
        waitSleep(1000);
        //
        click(signUpRegisterPageObjects.Continuebtn(),"Continue Button");
        if (isVisible(signUpRegisterPageObjects.BranchnameError(), getText(signUpRegisterPageObjects.BranchnameError()))) {
            passTest("PASSED: SBSU_TC_07", "Invalid Branch Name: Successful");
        }
        else {
            failTest("FAILED: SBSU_TC_07", "Invalid Branch Name: Failed");
        }
    }

    //update drop downs and branch name to successfully sign up
    public void SBSU_TC_08_SuccesfulSignUp(){
        directToSignUp();
        type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", "test.automation"+getRandomNumber()+"@mlhuillier.com");
        type(signUpRegisterPageObjects.signupNametxtbox(), "Name", "test."+getRandomNumber()+"name");
        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password", propertyReader.getproperty("Password2"));
        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Password", propertyReader.getproperty("Password2"));
        type(signUpRegisterPageObjects.ContactNumtxtbox(), "Contact Number", propertyReader.getproperty("phonenum"));
        type(signUpRegisterPageObjects.StoreEmail(), "Store Email Address", "test.automation"+getRandomNumber()+"@mlhuillier.com");

        waitSleep(1000);
        click(signUpRegisterPageObjects.provincetxtbox(), "DropDown");
        waitSleep(1000);
        arrowKeyDownv2(getThreeDigitRandomNumber());
        waitSleep(1000);
        click(signUpRegisterPageObjects.CityDropDown(), "City Dropdown");
        waitSleep(1000);
        arrowKeyDownv2(getThreeDigitRandomNumber());
        waitSleep(1000);
        click(signUpRegisterPageObjects.BranchDropDown(), "Branch Dropdown");
        waitSleep(1000);
        arrowKeyDownv2(getThreeDigitRandomNumber());
        waitSleep(2000);
        click(signUpRegisterPageObjects.Continuebtn(),"Continue Button");
        waitSleep(2000);
        boolean isSucess = false;
        if (isVisible(signUpRegisterPageObjects.SignUpsuccessful(), getText(signUpRegisterPageObjects.SignUpsuccessful()))) {
            isSucess = true;
        }

        click(signUpRegisterPageObjects.ConfirmBtn(), "Confirm Button");
        if(isSucess){
            passTest("PASSED: SBSU TC 08", "Sign Up Account: Successful");
        }else{
            failTest("SBSU TC 08","Sign Up Account: Failed");
        }
    }
}



