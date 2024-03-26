package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT extends BaseTest {

    @Test
    public void login()throws Exception{
       this.googlePageObjects.signViaGoogle("admin");
       this.loginPage.loginKpx("admin");
       this.homePageObjects.isInHomepage();
    }

//    @Test(priority = 1)
//    public void invalidLogin()throws Exception{
//        this.googlePageObjects.signViaGoogle("invalid");
//        this.loginPage.loginKpx("invalid");
//        this.loginPage.isInvalidAccount();
//    }

}
