package MLShop_BRANCH.base;

import MLShop_BRANCH.testSteps.*;
import org.testng.annotations.*;
import static utilities.Driver.DriverManager.*;
import utilities.Driver.DriverType;
import utilities.Logger.LoggingUtils;

public class BaseTest {
    protected Login_Steps loginSteps;


    @Parameters("browser")
    @BeforeClass (alwaysRun = true)
    public void setUp(final String browser) throws InterruptedException {
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser parameter cannot be null or empty");
        }
        initializeDriver(DriverType.valueOf(browser.toUpperCase()));
        getDriver().manage().deleteAllCookies();
        Thread.sleep(3000);
        getDriver().get(System.getProperty("targetUrl"));
        LoggingUtils.info("Redirecting back to home");
        loginSteps = new Login_Steps();
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
       

    }
    @AfterClass(alwaysRun = true)
    public void tearDown () {
        closeWebBrowser();
    }
}