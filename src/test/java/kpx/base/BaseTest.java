package kpx.base;

import org.testng.annotations.*;

import static utilities.Driver.DriverManager.*;
import utilities.Driver.DriverType;

import org.mlkpx.pageObject.Login_PageObjects;
import utilities.Logger.LoggingUtils;

public class BaseTest{
    protected Login_PageObjects loginPage;

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
        this.loginPage = new Login_PageObjects();
    }
    @AfterMethod(alwaysRun = true)
    public void clean(){
        LoggingUtils.info("------>>>Test Ended<<<-------");
        LoggingUtils.info("Redirecting back to home");
        getDriver().get(System.getProperty("targetUrl"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        quitDriver();
    }
}