package application.page.base;

import base.BrowserDriver;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporting.TestLogger;

public  class ApplicationPageBase extends BrowserDriver {
    /*
    * @author Jahidul Islam
    * All commonly used helper methods should be created here
    *
    * */
    String pageUrl;



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

    public static String getText(WebElement webElement, String webElementName){

        TestLogger.log("Getting Text from " + webElementName);
      String actualText =  webElement.getText();
      TestLogger.log("Actual text: " + actualText);

      return actualText;

    }
    public static void click(WebElement webElement, String webElementName){
        TestLogger.log("Click " + webElementName );
        webElement.click();
        TestLogger.log("Clicked " + webElementName);
    }

}
