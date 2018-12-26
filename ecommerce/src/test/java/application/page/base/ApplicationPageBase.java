package application.page.base;

import base.BrowserDriver;
import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporting.TestLogger;

public abstract class ApplicationPageBase extends PageBase {
    /*
    * @author Jahidul Islam
    * All commonly used helper methods should be created here
    *
    * */
    String pageUrl;

    public ApplicationPageBase(String pageUrl)
    {
        super(pageUrl);
    }

    public ApplicationPageBase(String pageUrl, String domain)
    {
        super(pageUrl, domain);
    }

    @Override
    protected void load()
    {

    }

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
