package utilities.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.Logger.LoggingUtils;

import java.time.Duration;
import java.util.HashMap;

public class DriverManager {
    //thread local for web driver
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<> ();
    //private static final boolean useRemoteWebDriver = Boolean.getBoolean("remoteDriver");
    public static void createDriver(final DriverType browser){
        switch (browser){
            case CHROME:
                setupChrome();
                break;
            case REMOTE_CRHOME:
                break;
            default:
                LoggingUtils.error("Invalid Browser...");
                break;
        }
        setupBrowserTimeouts();
    }
    public static void setupChrome(){
        LoggingUtils.info("Setting up chrome driver...");
        HashMap<String, Object> chromePreferences = new HashMap<>();
        chromePreferences.put("profile.password_manager_enabled", false);
        chromePreferences.put("intl.accept_languages", "en-US,en");
        chromePreferences.put("profile.default_content_settings.popups", 0);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--lang=en");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080"); // Set window size to maximum

        options.setExperimentalOption("prefs", chromePreferences);
        setDriver(WebDriverManager.chromedriver().capabilities(options).create());
        LoggingUtils.info("Chrome Driver created successfully");
    }

//    public static void setupRemoteChrome(){
//        //switch case for remote browser (e.g. CHROME, EDGE, FIREFOX)
//        try {
//            LoggingUtils.info ("Setting up Remote Chrome Driver....");
//            final ChromeOptions options = new ChromeOptions ();
//            options.addArguments ("--no-sandbox");
//            options.addArguments ("--disable-dev-shm-usage");
//            setDriver (new RemoteWebDriver (new URL (System.getProperty("seleniumGridURL")), options));
//            LoggingUtils.info ("Remote Chrome Driver created successfully!");
//        } catch (MalformedURLException e) {
//            LoggingUtils.error("Error setting up remote chrome.");
//        }
//    }
    //method for quitting driver
    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            LoggingUtils.info("Quitting Driver...");
            driver.quit();
            DRIVER.remove();
        }
    }

    //method for setting up driver
    private static void setDriver (WebDriver driver){
        DriverManager.DRIVER.set(driver);
    }

    //method for getting driver
    public static WebDriver getDriver () {
        return DriverManager.DRIVER.get ();
    }

    //setup for timeouts
    private static void setupBrowserTimeouts(){
        LoggingUtils.info("Setting browser timeouts...");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout (Duration.ofSeconds (10));
        getDriver().manage().timeouts().scriptTimeout (Duration.ofSeconds (10));
    }

    private DriverManager(){}
}
