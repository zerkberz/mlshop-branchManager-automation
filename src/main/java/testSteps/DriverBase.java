package testSteps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.driver.DriverFactory;
import utilities.logger.LoggingUtils;


public class DriverBase {

    private static final List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverThread;

    private static final String targetUrl = System.getProperty("targetUrl");
    private static String siteUnderTest = "https://mlshoppreprod.mlhuillier.com/";



    public static void instantiateDriverObject() {
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    public static RemoteWebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    public String getSiteUnderTest() {
        return siteUnderTest;
    }


    public static void loadBrowser() {
        LoggingUtils.info("====Launching Browser====");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (targetUrl != null && !targetUrl.trim().isEmpty()) {
            siteUnderTest = targetUrl;
        }
        if (siteUnderTest == null) {
            throw new Error("Target URL must not be empty.");
        }
        driverThread.get().setSiteUnderTest(siteUnderTest);
        getDriver().get(siteUnderTest);
        LoggingUtils.info("URL : " + getDriver().getCurrentUrl());
    }


    public static void clearCookies(){
        getDriver().manage().deleteAllCookies();
    }

    public static void closeDriverObjects() {
        webDriverThreadPool.forEach(DriverFactory::quitDriver);
        webDriverThreadPool.clear();
    }
}