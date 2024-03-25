package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT extends BaseTest {

    @Test
    public void login(){
       this.googlePageObjects.signViaGoogle("teller");
       this.loginPage.loginKpx("teller");
       this.homePageObjects.isInHomepage();
    }

//    @Test
//    public void invalidLogin(){
//        this.googlePageObjects.signViaGoogle("invalid");
//        this.loginPage.loginKpx("invalid");
//        this.loginPage.isInvalidAccount();
//    }

}
