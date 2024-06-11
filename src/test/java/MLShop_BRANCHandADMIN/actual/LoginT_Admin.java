package MLShop_BRANCHandADMIN.actual;

import MLShop_BRANCHandADMIN.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT_Admin extends BaseTest {

    @Test(priority = 0, description = "Validate Branch Log In")
    public  void Admin_Login() throws Exception{
        loginAdminSteps.Admin_Login();
    }
    @Test(priority = 1, dependsOnMethods = "Admin_Login", description = "Validate Visibility of Password")
    public  void PasswordVisibility_Login() throws Exception{
        loginAdminSteps.PasswordVisibility_Login();
    }
}
