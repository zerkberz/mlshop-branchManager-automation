package mlshopbuilder.testSteps;

import mlshopbuilder.pageObject.Merchant_Objects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;
import utilities.PropertyReader.propertyReader;
import utilities.Logger.LoggingUtils;

public class Merchant_Steps extends Base_Steps {

    public void navigateLoginPage() throws Exception{
    }
    public void loginByRole(String role) {
        click(merchantObjects.userIcon(), "Menu Icon");
        click(merchantObjects.MLoginbtn(), "Login option");
        type(merchantObjects.Email_add(), "Email Field", reader.getEmailByRole(role));
        type(merchantObjects.Login_pass(), "Email Field", reader.getPasswordByRole(role));
        click(merchantObjects.Continuebtn(), "Continue");
        LoggingUtils.info("Successful Logged In");
    }

    public void logout(String role){
        click(merchantObjects.userIcon(),"Menu Icon");
        click(merchantObjects.MLogoutbtn(), "Logout");
        waitSleep(1500);
        LoggingUtils.info("Successful Logged off");
    }

    public void SBR_TC_01_Login() {
        loginByRole("merchant");
        LoggingUtils.info("SBR_TC_01_LogIn_as_Merchant");
        logout("merchant");
    }

    public void SBR_TC_02_NavigateShopBuilder_Page() {
        loginByRole("merchant");
        click(loginPageObjects.userIcon(), "User Avatar");
        click(merchantObjects.shopbuilderbutton(), "Shopbuilder Button");
        LoggingUtils.info("SBR_TC_02: Validated Navigation to ShopBuilder Page");
        logout("merchant");
        }

    public void SBR_TC_03_TotalStores() {
        loginByRole("merchant");
        isVisible(merchantObjects.TotalStore(), "Total Store");
        isVisible(merchantObjects.TotalNumberStore(), "Number of Stores");
        LoggingUtils.info("SBR_TC_03: Validated Total Stores");
        logout("merchant");
    }
    public void SBR_TC_04 (){
        
    }

}
