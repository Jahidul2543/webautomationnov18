package page.objects;

import base.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactUsPage extends BrowserDriver {



     @FindBy(how = How.CLASS_NAME, className = "page-heading")
     private  WebElement pageHeading;

    public String contactUs(){

        String getText = pageHeading.getText();

      return getText;

    }


}
