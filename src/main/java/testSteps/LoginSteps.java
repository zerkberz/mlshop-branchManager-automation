package testSteps;

import org.mlkpx.pageObject.loginPageObjects;

import utilities.logger.LoggingUtils;

public class LoginSteps extends BasePage<LoginSteps>{

    public LoginSteps(){
        super();
    }
    public static void MLS_TC_01_loginPage_redirection() throws InterruptedException{
        LoggingUtils.info(">> STARTING : MLS_TC_01_loginPage_redirection");
        click(loginPageObjects.objUser_icon, "User icon");
    }

    @Override
    protected void load() {
        //click(loginPageObjects.objUser_icon, "User icon");
    }

    @Override
    protected void isLoaded() throws Error {
        if(!isVisible(loginPageObjects.login_btn, "Login button")){
            LoggingUtils.error("Login Page was not successfully loaded!");
        }
    }
    public static void MLS_TC_02_loginPage_redirection() throws InterruptedException{
        LoggingUtils.info(">> STARTING : MLS_TC_02_loginPage_redirection");
        click(loginPageObjects.objUser_icon, "User icon");
    }
}
