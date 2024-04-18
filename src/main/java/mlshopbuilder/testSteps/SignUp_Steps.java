package mlshopbuilder.testSteps;

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

    public void SBSU_TC_01_to_03(){
        directToSignUp();
        type(signUpRegisterPageObjects.signupEmailtxtbox(), "Email", propertyReader.getproperty("InvEmail"));
        type(signUpRegisterPageObjects.signupNametxtbox(), "Name",propertyReader.getproperty("Name"));
        type(signUpRegisterPageObjects.signupPasswordtxtbox(), "Password","Password");
        type(signUpRegisterPageObjects.signupRepasstxtbox(), "Password","Password");
        click(signUpRegisterPageObjects.Continuebtn(), "Continue");
        LoggingUtils.info("[SBSU_TC_01] Successfully Validated Email: Needs to be company Email");
        waitSleep(2000);
        type(signUpRegisterPageObjects.signupEmailtxtbox(),"Email",propertyReader.getproperty("Email"));
        click(signUpRegisterPageObjects.Continuebtn(), "Continue");
        waitSleep(2000);
        click(signUpRegisterPageObjects.Confirmbtn(), "Confirm");
        LoggingUtils.info("[SBSU_TC_02] Successfully Created Account");

        //click(signUpRegisterPageObjects.TickboxMerchant(), "Merchant Tickbox Checked");
       // LoggingUtils.info("Successfully placed Invalid Inputs");
    }
}
