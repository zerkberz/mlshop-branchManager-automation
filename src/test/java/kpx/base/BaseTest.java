package kpx.base;

import mlkpx.testSteps.Home_Steps;
import mlkpx.testSteps.Kyc_Steps;
import mlkpx.testSteps.Login_Steps;
import org.testng.annotations.*;

import static utilities.Driver.DriverManager.*;
import utilities.Driver.DriverType;

import utilities.Logger.LoggingUtils;

public class BaseTest {
    protected Home_Steps homeSteps;
    protected Login_Steps loginSteps;
    protected Kyc_Steps kycSteps;


    @Parameters("browser")
    @BeforeClass (alwaysRun = true)
    public void setUp(final String browser){
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser parameter cannot be null or empty");
        }
        initializeDriver(DriverType.valueOf(browser.toUpperCase()));
        getDriver().manage().deleteAllCookies();
        if (getDriver().toString().contains("RemoteWebDriver")) {
            getDriver().get(System.getProperty("targetUrl"));
        } else {
            getDriver().get(System.getProperty("targetUrl"));
            LoggingUtils.info("Redirecting back to home");
        }
        this.loginSteps = new Login_Steps();
        this.homeSteps = new Home_Steps();
        this.kycSteps = new Kyc_Steps();

    }
    private void initializeDriver(DriverType driverType) {
        createDriver(driverType);
    }


    @BeforeMethod(alwaysRun = true)
    public void setUpTests(){
        getDriver().get(System.getProperty("homeUrl"));
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