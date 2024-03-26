package kpx.actual;

import org.testng.annotations.Test;
import kpx.base.BaseTest;
import utilities.ExtentReport.ExtentReporter;

public class Kyc_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("admin");
        this.loginSteps.loginKpx("admin");
    }

    @Test(dependsOnMethods = "loginGoogle" , description = "To verify Search Rexistered KYC inputs using valid data")
    public void KYC_TC_02()throws Exception{
        this.loginSteps.signInGoogleV2();
        this.loginSteps.loginKpx("admin");
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.kycSteps.searchRegisteredKYC_Valid();
            ExtentReporter.logPass("KYC_TC_02, Passed!!");
        }
    }
}
