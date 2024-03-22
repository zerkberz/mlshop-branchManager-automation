package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;

public class LoginT extends BaseTest {

    @Test
    public void login(){
       this.googlePageObjects.signViaGoogle();
       this.loginPage.loginKpx();
    }

}
