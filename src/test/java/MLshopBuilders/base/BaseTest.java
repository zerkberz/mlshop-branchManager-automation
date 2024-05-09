package MLshopBuilders.base;

import mlshopbuilder.testSteps.Merchant_Steps;
import mlshopbuilder.testSteps.SupportAdmin_Steps;
import org.testng.annotations.*;

import static utilities.Driver.DriverManager.*;
import utilities.Driver.DriverType;

import utilities.Logger.LoggingUtils;
import mlshopbuilder.testSteps.Login_Steps;
import mlshopbuilder.testSteps.SignUp_Steps;

import java.time.Duration;


public class BaseTest {
    protected Login_Steps loginSteps;
    protected SignUp_Steps signUpSteps;
    protected Merchant_Steps merchantSteps;
    protected SupportAdmin_Steps supportAdminSteps;
    @Parameters("browser")
    @BeforeClass (alwaysRun = true)
    public void setUp(final String browser) throws InterruptedException {
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser parameter cannot be null or empty");
        }
        initializeDriver(DriverType.valueOf(browser.toUpperCase()));
        getDriver().manage().deleteAllCookies();
        if (getDriver().toString().contains("RemoteWebDriver")) {
            getDriver().get(System.getProperty("targetUrl"));
        } else {
            Thread.sleep(3000);
            getDriver().get(System.getProperty("targetUrl"));
            LoggingUtils.info("Redirecting back to home");
        }
        loginSteps = new Login_Steps();
        signUpSteps = new SignUp_Steps();
        merchantSteps = new Merchant_Steps();
        supportAdminSteps = new SupportAdmin_Steps();
    }
    private void initializeDriver(DriverType driverType) {
        createDriver(driverType);
    }


    @BeforeMethod(alwaysRun = true)
    public void setUpTests(){
        getDriver().get(System.getProperty("targetUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void clean(){
        LoggingUtils.info("------>>>Test Ended<<<-------");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        closeWebBrowser();
    }
}