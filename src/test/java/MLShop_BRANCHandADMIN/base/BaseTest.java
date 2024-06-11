package MLShop_BRANCHandADMIN.base;

import MLShop_BRANCHandADMIN.testSteps.*;
import org.testng.annotations.*;
import static utilities.Driver.DriverManager.*;
import utilities.Driver.DriverType;
import utilities.Logger.LoggingUtils;

public class BaseTest {
    protected LoginBranch_Steps loginBranchSteps;
    protected LoginAdmin_Steps loginAdminSteps;

    @Parameters({"browser","role"})
    @BeforeClass (alwaysRun = true)
    public void setUp(final String browser, final String role) throws InterruptedException {
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser parameter cannot be null or empty");
        }
        initializeDriver(DriverType.valueOf(browser.toUpperCase()));
        getDriver().manage().deleteAllCookies();
        Thread.sleep(3000);
        String url = null;
        if (role != null && role.equals("branch")) {
            LoggingUtils.info("Branch Role");
            url = System.getProperty("branchUrl");
        } else if (role != null && role.equals("admin")) {
            LoggingUtils.info("Admin Role");
            url = System.getProperty("adminUrl");
        } else {
            throw new IllegalArgumentException("Invalid role parameter: " + role);
        }
        getDriver().get(url);
        LoggingUtils.info("Redirecting back to home");
        loginBranchSteps = new LoginBranch_Steps();
        loginAdminSteps = new LoginAdmin_Steps();
    }
    private void initializeDriver(DriverType driverType) {
        createDriver(driverType);
    }

    @Parameters({"role"})
    @BeforeMethod(alwaysRun = true)
    public void setUpTests(final String role){
        String url = null;
        if (role != null && role.equals("branch")) {
            LoggingUtils.info("Branch Role");
            url = System.getProperty("branchUrl");
        } else if (role != null && role.equals("admin")) {
            LoggingUtils.info("Admin Role");
            url = System.getProperty("adminUrl");
        } else {
            throw new IllegalArgumentException("Invalid role parameter: " + role);
        }
        getDriver().get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void clean(){}
    @AfterClass(alwaysRun = true)
    public void tearDown () {
        closeWebBrowser();
    }
}