package utilities.driver;

import static utilities.driver.DriverType.CHROME;
import static utilities.driver.DriverType.valueOf;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import utilities.logger.LoggingUtils;

public class DriverFactory {

    private RemoteWebDriver webDriver;
    private DriverType selectedDriverType;
    private String siteUnderTest = "";

    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");
    private final boolean useRemoteWebDriver = Boolean.getBoolean("remoteDriver");


    public DriverFactory() {
        DriverType driverType = CHROME;
        String browser = System.getProperty("browser", driverType.toString()).toUpperCase();
        try {
            driverType = driverType.valueOf(browser);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
        }
        selectedDriverType = driverType;
    }
    public RemoteWebDriver getDriver() {
        if (null == webDriver) {
            instantiateWebDriver(selectedDriverType);
        }
        return webDriver;
    }
    public void quitDriver() {
        if (null != webDriver) {
            webDriver.quit();
            webDriver = null;
            LoggingUtils.info("Driver is now quitting");
        }
    }
    private DesiredCapabilities instantiateWebDriver(DriverType driverType) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.acceptInsecureCerts();
        //desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        // desiredCapabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");

        if (useRemoteWebDriver) {
            String gridUrl = System.getProperty("gridURL");
            String desiredPlatform = System.getProperty("desiredPlatform");
            String desiredBrowser = driverType.toString().toLowerCase();
            String desiredBrowserVersion = System.getProperty("desiredBrowserVersion");
            URL seleniumGridURL;
            LoggingUtils.info("Connecting to Seleniumg Grid: " + gridUrl);
            try {
                seleniumGridURL = new URL(gridUrl);
            } catch (MalformedURLException e) {
                throw new IllegalStateException("The supplied Selenium Grid URL is malformed. Please check grid url.");
            }

            if (null != desiredPlatform && !desiredPlatform.isEmpty()) {
                desiredCapabilities.setPlatform(Platform.valueOf(desiredPlatform.toUpperCase()));
            }

            if (null != desiredBrowser && !desiredBrowser.isEmpty()) {
                desiredCapabilities.setBrowserName(desiredBrowser);
            }

            if (null != desiredBrowserVersion && !desiredBrowserVersion.isEmpty()) {
                desiredCapabilities.setVersion(desiredBrowserVersion);
            }

            webDriver = new RemoteWebDriver(seleniumGridURL, desiredCapabilities);

        } else {
            try {
                WebDriverManager.getInstance(DriverManagerType.valueOf(driverType.toString())).setup();
                LoggingUtils.info("OS: " + operatingSystem);
                LoggingUtils.info("Sys Arch: " + systemArchitecture);
                LoggingUtils.info("Driver Type: " + driverType.toString());
            } catch (Exception e) {
                LoggingUtils.error("WebDriverManager exception has occurred. It might be the DriverManagerType is unkown.");        
            }

            webDriver = driverType.getWebDriverObject(desiredCapabilities);
        }
        return desiredCapabilities;

    }
    public String setSiteUnderTest(String siteUnderTest) {
        return this.siteUnderTest = siteUnderTest;
    }
}
