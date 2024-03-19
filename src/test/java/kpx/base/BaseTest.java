package kpx.base;

import org.testng.annotations.*;

import static utilities.Driver.DriverManager.*;
import utilities.Driver.DriverType;

import org.mlkpx.pageObject.loginPageObjects;
import utilities.Logger.LoggingUtils;

public class BaseTest{
    protected loginPageObjects loginPage;

    @Parameters("browser")
    @BeforeClass (alwaysRun = true)
    public void setUp(final String browser){
        createDriver(DriverType.valueOf(browser.toUpperCase()));
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpTests(){
        if (getDriver().toString().contains("RemoteWebDriver")) {
            getDriver().get(System.getProperty("targetUrl"));
        } else {
            getDriver().get(System.getProperty("targetUrl"));
        }
        this.loginPage = new loginPageObjects();
    }
    @AfterMethod(alwaysRun = true)
    public void clean(){
        LoggingUtils.info("Redirect back to home");
        getDriver().get(System.getProperty("targetUrl"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        quitDriver();
    }
}