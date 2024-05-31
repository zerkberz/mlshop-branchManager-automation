package MLshopBuilders.actual;

import MLshopBuilders.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT extends BaseTest {

    @Test(priority = 0, description = "Validate Login as User")
    public  void Login() throws Exception{
        loginSteps.login();
    }
}
