package mlshopbuilder.testSteps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.PropertyReader.propertyReader;
import utilities.Logger.LoggingUtils;

public class SignUp_Steps extends Base_Steps {
    public void navigateLoginPage() throws Exception{
    }

    public void directToSignUp(){
        click(signUpRegisterPageObjects.userIcon(),"Menu Icon");
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
        if (isVisible(signUpRegisterPageObjects.TickboxMerchant(),"Tickbox Merchant")) {
        }
        return true;
    }

//    public void SBSU_TC_01_to_03(){
//        directToSignUp();
//        type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", propertyReader.getproperty("InvEmail"));
//        type(signUpRegisterPageObjects.signupNametxtbox(), "Name",propertyReader.getproperty("Name"));
//        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password","Password");
//        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Password","Password");
//        click(signUpRegisterPageObjects.Continuebtn(), "Continue");
//        click(signUpRegisterPageObjects.exitbtn(), "Exit Pop up");
//        if(isInSignUp()){
//            ExtentReporter.logPass("SBSU_TC_01", " Successfully Validated Email: Needs to be company Email");
//        }
//        else{
//            ExtentReporter.logFail("", "Failed to Validate Email");
//            Assert.fail("");
//        }
//
//        directToSignUp();
//        type(signUpRegisterPageObjects.signupEmailtxtbox(),"Email",propertyReader.getproperty("Email"));
//        type(signUpRegisterPageObjects.signupNametxtbox(), "Name",propertyReader.getproperty("Name"));
//        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password","Password");
//        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Confirm Password","Password");
//        click(signUpRegisterPageObjects.Continuebtn(), "Continue");
//        click(signUpRegisterPageObjects.exitbtn(), "exit Pop Up");
//        if(isInSignUp()){
//            ExtentReporter.logPass("SBSU_TC_02", "Successfully Created Account");
//        }
//        else{
//            ExtentReporter.logFail("", "Failed to Create Account");
//            Assert.fail("");
//        }
//
//        directToSignUp();
//        type(signUpRegisterPageObjects.signupEmailtxtbox(),"Email",propertyReader.getproperty("Emptyemail"));
//        type(signUpRegisterPageObjects.signupNametxtbox(), "Name",propertyReader.getproperty("Emptyname"));
//        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password","Emptypass");
//        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Confirm Password","EmptyRepass");
//        click(signUpRegisterPageObjects.Continuebtn(), "Continue");
//        click(signUpRegisterPageObjects.exitbtn(), "exit Pop Up");
//        if(isInSignUp()){
//            ExtentReporter.logPass("SBSU_TC_03", "Successfully confirmed empty textboxes");
//        }
//        else{
//            ExtentReporter.logFail("SBSU_TC_03", "Failed to confirmed empty textboxes");
//            Assert.fail("");
//        }
//    }

    public void SBSU_TC_04_to_09(){
//        directToSignUp();
//        if(isInSignUp()){
//            click(signUpRegisterPageObjects.TickboxMerchant(), "Merchant Tickbox");
//            click(signUpRegisterPageObjects.exitbtn(), "Exit Pop up");
//            ExtentReporter.logPass("SBSU_TC_04", "Successfully Validated Tickbox: I want to be Merchant");
//        }
//        else{
//            ExtentReporter.logFail("SBSU_TC_04", "Failed to validate Merchant textbox");
//            Assert.fail("");
//        }

            click(signUpRegisterPageObjects.userIcon(), "User Avatar");
            click(signUpRegisterPageObjects.signupbtn(), "SIgn Up button");

            click(signUpRegisterPageObjects.TickboxMerchant(), "Merchant tickbox");

//            type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", propertyReader.getproperty("Email2"));
//            type(signUpRegisterPageObjects.signupNametxtbox(), "Name", propertyReader.getproperty("Name2"));
//            type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password", propertyReader.getproperty("Password2"));
//            type(signUpRegisterPageObjects.signupRepasstxtbox(), "Password", propertyReader.getproperty("Password2"));
//
//            type(signUpRegisterPageObjects.ContactNumtxtbox(), "Contact Number", propertyReader.getproperty("phonenum"));
//            type(signUpRegisterPageObjects.StoreEmail(), "Store Email Address", propertyReader.getproperty("InvStoreEmail2"));

            click(signUpRegisterPageObjects.dropdown1(), "Province");
            typeEnter(signUpRegisterPageObjects.Selection1(), "Province Input", "Cebu");
            waitSleep(2000);
            //todo follow this sht
            click(signUpRegisterPageObjects.dropdown2(), "City");
            click(signUpRegisterPageObjects.Selection2(),"BANGUED");

            click(signUpRegisterPageObjects.dropdown3(), "Zonecode");

            click(signUpRegisterPageObjects.dropdown4(), "Branch");

//            isVisible(signUpRegisterPageObjects.InvalidStoreEmail(), "Invalid Store Email");
//            click(signUpRegisterPageObjects.Continuebtn(),"Continue Button" );

//            if(isInSignUp()){
//            ExtentReporter.logPass("SBSU_TC_05", "Successfully Validated Invalid Store Email Address");
//        }
//        else{
//            ExtentReporter.logFail("SBSU_TC_04", "Failed to validate invalid Store Email Address");
//            Assert.fail("");
        }
    }


