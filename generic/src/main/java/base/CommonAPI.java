package base;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;

    @Parameters({/*"useCloudEnv","cloudEnvName", */"os", "os_version", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(/*@Optional("false") boolean useCloudEnv, @Optional("false") String cloudEnvName,*/
                      @Optional("windows") String os, @Optional("10") String os_version, @Optional("firefox") String browserName, @Optional("34")
                              String browserVersion, @Optional("https://www.google.com") String url) throws IOException {
        getLocalDriver(browserName, os);
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS); // 20
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS); //35
        driver.get(url);
       // driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String browserName, String os) {
            if (browserName.equalsIgnoreCase("chrome")) {
                if (os.equalsIgnoreCase("windows")) {
                    System.setProperty("webdriver.chrome.driver", "../Generic/drivers/windows/chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (os.equalsIgnoreCase("mac")) {
                    System.setProperty("webdriver.chrome.driver", "../Generic/drivers/mac/chromedriver");
                    driver = new ChromeDriver();
                }
            } else if (browserName.equalsIgnoreCase("firefox")) {
                if (os.equalsIgnoreCase("windows")) {
                    System.setProperty("webdriver.gecko.driver", "../Generic/drivers/windows/geckodriver.exe");
                    driver = new ChromeDriver();
                } else if (os.equalsIgnoreCase("mac")) {
                    System.setProperty("webdriver.gecko.driver", "../Generic/drivers/mac/geckodriver");
                    driver = new ChromeDriver();
                }
            }
        return driver;
    }

    @AfterMethod
    public void closeOut() {
        //driver.manage().deleteAllCookies();
        driver.quit();
    }

}
