package kpx.actual;

import org.testng.annotations.Test;
import kpx.base.BaseTest;
import utilities.ExtentReport.ExtentReporter;

public class Kyc_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if(this.homeSteps.isInHomePage()){
            ExtentReporter.logPass("Login, Passed!!");
        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 1)
    public void KYC_TC_02()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();

//            this.kycSteps.searchRegisteredKYC_Valid();

            this.kycSteps.searchRegisteredKYC_Valid();
            ExtentReporter.logPass("Registered KYC records will display");


        }
    }


//    @Test(dependsOnMethods = "loginGoogle" , priority = 2)
//    public void KYC_TC_03()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.kycSteps.navigateKycPage();
//            this.kycSteps.searchRegisteredKYC_Invalid();
//            this.kycSteps.searchRegisteredKYC_Invalid03();
//            this.kycSteps.searchRegisteredKYC_Invalid04();
//            this.kycSteps.searchRegisteredKYC_Invalid05();
//
//        }
//    }
    
    @Test(dependsOnMethods = "loginGoogle" , priority = 2)
    public void KYC_TC_04()throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.kycSteps.AddNewKYC_Valid();
            this.kycSteps.AddNewKYC01();

        }
    }
}
