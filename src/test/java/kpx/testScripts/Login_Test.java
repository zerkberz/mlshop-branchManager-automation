package kpx.testScripts;

import org.testng.annotations.Test;
import testSteps.LoginSteps;

public class Login_Test extends BaseTest {

    @Test(priority = 1)
    public static void MLS_TC_01() throws InterruptedException{
        LoginSteps.MLS_TC_01_loginPage_redirection();
    }
}
