package MLShop_BRANCH.actual;

import MLShop_BRANCH.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT extends BaseTest {

    @Test(priority = 0, description = "Validate Branch Log In")
    public  void Branch_Login() throws Exception{
        loginSteps.Branch_Login();
    }

}
