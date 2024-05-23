package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT extends BaseTest {

    @Test(priority = 0, description = "Verify login as Admin")
    public  void SBL_TC_01_AdminLogIn() throws Exception{
        loginSteps.SBL_TC_01_AdminLogIn();
    }
    @Test(priority = 1, description = "Verify login as Support Admin")
    public  void SBL_TC_02_SuppAdminLogIn() throws Exception{
        loginSteps.SBL_TC_02_SuppAdminLogIn();
    }
    @Test(priority = 2, description = "Verify login as Regular")
    public  void SBL_TC_03_MerchantLogIn() throws Exception{
        loginSteps.SBL_TC_03_MerchantLogIn();
    }
    @Test(priority = 3, description = "Verify enter no @gmail ")
    public  void SBL_TC_04_NoGmail_LogIn() throws Exception{
        loginSteps.SBL_TC_04_NoGmail_LogIn();
    }
    @Test(priority = 4)
    public  void SBL_TC_05_InvalidPass_LogIn() throws Exception{
        loginSteps.SBL_TC_05_InvalidPass_LogIn();
    }
    @Test(priority = 5)
    public  void SBL_TC_06_InvalidCredential_LogIn() throws Exception{
        loginSteps.SBL_TC_06_InvalidCredential_LogIn();
    }
    @Test(priority = 6)
    public  void SBL_TC_07_MSignUpPopup() throws Exception{
        loginSteps.SBL_TC_07_MSignUpPopup();
    }
    @Test(priority = 7)
    public  void SBL_TC_08and09_LogInPopupAndExit() throws Exception{
        loginSteps.SBL_TC_08and09_LogInPopupAndExit();
    }
    @Test(priority =8)
    public  void SBL_TC_10_SignUpRedirection_via_createaccount() throws Exception{
        loginSteps.SBL_TC_10_SignUpRedirection_via_createaccount();
    }
}
