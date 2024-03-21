package actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReport;

public class LoginT extends BaseTest {

    @Test
    public void TC_01_LoginNavigate(){
        this.loginPage.navigateLoginPage();
        ExtentReport.logPass("Test passed successfully");
    }

    @Test(dependsOnMethods = "TC_01_LoginNavigate")
    public void TC_02_VerifyOTP(){
        this.loginPage.navigateLoginPage();
        this.loginPage.typeNumber();
    }

}
