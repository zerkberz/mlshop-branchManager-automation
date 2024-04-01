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
            this.kycSteps.searchRegisteredKYC_Valid();
            ExtentReporter.logPass("Registered KYC records will display");

        }
    }

    @Test(dependsOnMethods = "loginGoogle" , priority = 2)
    public void KYC_TC_03()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.kycSteps.searchRegisteredKYC_Invalid();
            ExtentReporter.logPass("LASTNAME and FIRSTNAME IS REQUIRED.");

        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 3)
    public void KYC_TC_03_1()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.kycSteps.searchRegisteredKYC_InvalidInputNumbers();
            ExtentReporter.logPass("LAST NAME IS REQUIRED.");

        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 4)
    public void KYC_TC_03_2()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.kycSteps.searchRegisteredKYC_InvalidInputSpecialCharacters();
            ExtentReporter.logPass("Cannot proceed to search or No Data");

        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 5)
    public void KYC_TC_03_3()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.kycSteps.searchRegisteredKYC_InvalidInputMoreThan60Characters();
            ExtentReporter.logPass("MAXIMUM OF 60 CHARACTERS.");

        }
    }
    @Test(dependsOnMethods = "loginGoogle" , priority = 6)
    public void KYC_TC_04()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.kycSteps.navigateKycPage();
            this.kycSteps.ValidInputsInAddKYCNameSectionPositiveTesting();

        }
    }


}
