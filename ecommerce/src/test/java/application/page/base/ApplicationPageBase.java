package application.page.base;

import base.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
