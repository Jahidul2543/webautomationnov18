package application.page.base;

import base.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporting.TestLogger;

public class ApplicationPageBase extends BrowserDriver {
    /*
    * @author Jahidul Islam
    * All commonly used helper methods should be created here
    *
    * */

    //return status of link if it is enabled
    public static boolean isEnableStatus(WebDriver driver, WebElement web) {
        boolean en = web.isEnabled();
        return en;
    }
    public static void sendKeys(WebElement webElement, String webElementName, String keys){
        webElement.clear();
        TestLogger.log("Sending keys to " + webElementName);
        webElement.sendKeys(keys);
        TestLogger.log("Keys Sent to " + webElementName);
    }

}
