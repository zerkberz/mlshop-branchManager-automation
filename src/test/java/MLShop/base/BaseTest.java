package MLShop.base;

import MLShop.testStepsAdmin.*;
import org.testng.annotations.*;
import static utilities.Driver.DriverManager.*;
import utilities.Driver.DriverType;
import utilities.Logger.LoggingUtils;

public class BaseTest {

    //ADMIN
    protected Login_Steps adminLoginSteps;
    protected Dashboard_Steps adminDashboardSteps;
    protected Orders_Steps adminOrderSteps;
    protected  SellerList_Steps adminSellerListSteps;
    protected  Reports_ProductList_Steps adminReportsProductListSteps;
    protected  Reports_ProductInventory_Steps adminReportsProductInventorySteps;
    protected  Reports_SalesReport_Steps adminReportsSalesReportSteps;

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
        if (role != null && role.equals("login")) {
            LoggingUtils.info("Login Role");
            url = System.getProperty("adminUrl");
        } else if (role != null && role.equals("admin")) {
            LoggingUtils.info("Admin Role");
            url = System.getProperty("adminUrl");
//            url = System.getProperty("adminUrl")+ "Home/Dashboard";
        } else {
            throw new IllegalArgumentException("Invalid role parameter: " + role);
        }
        getDriver().get(url);
        LoggingUtils.info("Redirecting back to home");

        //ADMIN
        adminOrderSteps = new Orders_Steps();
        adminLoginSteps = new Login_Steps();
        adminDashboardSteps = new Dashboard_Steps();
        adminSellerListSteps = new SellerList_Steps();
        adminReportsProductListSteps = new Reports_ProductList_Steps();
        adminReportsProductInventorySteps = new Reports_ProductInventory_Steps();
        adminReportsSalesReportSteps = new Reports_SalesReport_Steps();

    }
    private void initializeDriver(DriverType driverType) {
        createDriver(driverType);
    }

    @Parameters({"role"})
    @AfterMethod(alwaysRun = true)
    public void setUpTests(final String role){
        String url = null;
        if (role != null && role.equals("admin")) {
            LoggingUtils.info("Admin Role");
            url = System.getProperty("adminUrl") + "Home/Dashboard";
        } else if (role != null && role.equals("login")) {
            LoggingUtils.info("Login Role");
            url = System.getProperty("adminUrl");
        } else {
            throw new IllegalArgumentException("Invalid role parameter: " + role);
        }
        getDriver().get(url);
    }

//    @AfterMethod(alwaysRun = true)
//    public void clean(){}
    @AfterClass(alwaysRun = true)
    public void tearDown () {
        closeWebBrowser();
    }
}