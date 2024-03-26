package kpx.actual;

import org.testng.annotations.Test;
import kpx.base.BaseTest;

public class Kyc_Tests extends BaseTest {
    @Test
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("admin");
        this.loginSteps.loginKpx("admin");
    }

    @Test(dependsOnMethods = "loginGoogle")
    public void KYC_TC_02()throws Exception{
        this.loginSteps.signInGoogleV2();
        this.loginSteps.loginKpx("admin");
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.kycSteps.searchRegisteredKYC_Valid();
        }
    }
}
