package utilities.driver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import utilities.logger.LoggingUtils;

import java.util.HashMap;

public enum DriverType implements DriverSetup {
    CHROME {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            ChromeOptions options = new ChromeOptions();
            options.merge(capabilities);

            // Check if the headless option is enabled >> pom.xml >> systemVariables
            if (Boolean.parseBoolean(System.getProperty("headless"))) {
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                LoggingUtils.info("Running in Headless");
            }

            options.addArguments("--no-default-browser-check");
            options.addArguments("--lang=en");
            options.addArguments("--ignore-ssl-errors=yes");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("enable-automation");
            options.addArguments("start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080"); // Set window size to 1920x1080

            if (System.getProperty("userDataDir") != null) {
                options.addArguments("user-data-dir=" + System.getProperty("userDataDir"));
            }

            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled", false);
            chromePreferences.put("intl.accept_languages", "en-US,en");
            chromePreferences.put("profile.default_content_settings.popups", 0);
            options.setExperimentalOption("prefs", chromePreferences);

            return new ChromeDriver(options);
        }
    },
    FIREFOX {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            FirefoxProfile profile = new FirefoxProfile();
            FirefoxOptions options = new FirefoxOptions();
            profile.setPreference("intl.accept_languages", "en-US, en");
            options.merge(capabilities);
            //options.setHeadless(HEADLESS);
            options.addPreference("intl.accept_languages", "en-US");
            options.setProfile(profile);
            return new FirefoxDriver(options);
        }
    };

    public abstract RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities);
}
