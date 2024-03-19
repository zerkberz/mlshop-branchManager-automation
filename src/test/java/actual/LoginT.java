package actual;

import kpx.base.BaseTest;
import org.mlkpx.pageObject.loginPageObjects;
import org.testng.annotations.Test;


public class LoginT extends BaseTest {

    @Test
    public void TC_01_LoginNavigate(){
        this.loginPage.navigateLoginPage();
    }

    @Test(dependsOnMethods = "TC_01_LoginNavigate")
    public void TC_02_VerifyOTP(){
        this.loginPage.navigateLoginPage();
        this.loginPage.typeNumber();

    }
}
