package MLShop_BRANCHandADMIN.actual;

import MLShop_BRANCHandADMIN.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT_Branch extends BaseTest {

    @Test(priority = 0, description = "Validate Branch Log In")
    public  void Branch_Login() throws Exception{
        loginBranchSteps.Branch_Login();
    }
    @Test(priority = 1, dependsOnMethods = "Branch_Login", description = "Validate Visibility of Password")
    public  void PasswordVisibility_Login() throws Exception{
        loginBranchSteps.PasswordVisibility_Login();
    }

}
