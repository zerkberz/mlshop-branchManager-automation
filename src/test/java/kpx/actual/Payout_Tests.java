package kpx.actual;

import kpx.base.BaseTest;

import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;
public class Payout_Tests extends BaseTest{
    @Test(priority = 1)
    public void Payout_TC_01()throws Exception{
        if(this.homeSteps.isInHomePage()){
            this.payoutSteps.navigatePayoutPage();


        }


    }

}
