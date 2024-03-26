package kpx.actual;

import kpx.base.BaseTest;

import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;



public class LoginT extends BaseTest {

    @Test(priority = 1)
    public void loginValid()throws Exception{
       this.loginSteps.signInGoogle("admin");
       this.loginSteps.loginKpx("admin");
       if(this.homeSteps.isInHomePage()){
           ExtentReporter.logPass("Login Successful");
       }
    }

}
