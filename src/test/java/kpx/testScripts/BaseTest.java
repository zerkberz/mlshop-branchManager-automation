package kpx.testScripts;

import org.testng.annotations.*;
import testSteps.DriverBase;
import utilities.logger.LoggingUtils;


public class BaseTest{

    @BeforeSuite
    public void beforeSuite() {
        LoggingUtils.info("Instantiating Object");
        DriverBase.instantiateDriverObject();
    }

//    @BeforeTest
//    public void beforeTest() {
//        LoggingUtils.info("Before Test");
//
//
//    }

    @BeforeMethod
    public void beforeMethod() {
        DriverBase.loadBrowser();

    }

    @AfterMethod
    public void closeDriver() {
        DriverBase.closeDriverObjects();
    }

//    @AfterTest
//    public void clearCookies(){
//        try {
//            DriverBase.clearCookies();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }


}