package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserDriver {

    public static WebDriver driver = null;

    @Parameters({/*"useCloudEnv","cloudEnvName", */"os", "os_version", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(/*@Optional("false") boolean useCloudEnv, @Optional("false") String cloudEnvName,*/
                      @Optional("windows") String os, @Optional("10") String os_version, @Optional("firefox") String browserName, @Optional("34")
                              String browserVersion, @Optional("https://www.google.com") String url) throws IOException {
        getLocalDriver(browserName, os);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // 20
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS); //35
        //driver.manage().window().maximize();
        driver.get(url);

    }

    public WebDriver getLocalDriver(String browserName, String os) {


            if (browserName.equalsIgnoreCase("chrome")) {

               /*
               * Command Line Arguments
               * https://peter.sh/experiments/chromium-command-line-switches/
               * */

                ChromeOptions options =new ChromeOptions();
               // options.setHeadless(true);
                options.addArguments("--start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--incognito");

                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                if (os.equalsIgnoreCase("windows")) {
                    System.setProperty("webdriver.chrome.driver", "../Generic/drivers/windows/chromedriver.exe");
                    driver = new ChromeDriver(options);
                } else if (os.equalsIgnoreCase("mac")) {
                    System.setProperty("webdriver.chrome.driver", "../Generic/drivers/mac/chromedriver");
                    driver = new ChromeDriver(options);
                }
            } else if (browserName.equalsIgnoreCase("firefox")) {
                 /*
                 * https://chercher.tech/java/chrome-firefox-options-selenium-webdriver
                 *
                 * */
                FirefoxOptions options = new FirefoxOptions();
                //options.setHeadless(true);
                options.addArguments("--start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--private");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);


                if (os.equalsIgnoreCase("windows")) {
                    System.setProperty("webdriver.gecko.driver", "../Generic/drivers/windows/geckodriver.exe");
                    driver = new FirefoxDriver(options);
                } else if (os.equalsIgnoreCase("mac")) {
                    System.setProperty("webdriver.gecko.driver", "../Generic/drivers/mac/geckodriver");
                    driver = new FirefoxDriver(options);
                }
            }

        return driver;
    }

    @AfterMethod
    public void closeOut() {
        //driver.manage().deleteAllCookies();
        driver.quit();
    }

    /**
     *
     * @return current WebDriver instance
     */

    public static WebDriver  getDriver()
    {
        return driver;
    }
    /**
     * This method returns the url.
     *
     * @return Returns the string.
     */
    public static String getUrl()
    {
        return driver.getCurrentUrl();
    }

}
