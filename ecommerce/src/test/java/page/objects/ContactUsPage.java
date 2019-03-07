package page.objects;

import base.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ContactUsPage extends BrowserDriver {



     @FindBy(how = How.CLASS_NAME, className = "page-heading")
     private  WebElement pageHeading;

     /**
      * Store all the WebElement under input tag in a List and access that array
      * to get your desired element by index
      * */
     private List<WebElement> elements = driver.findElements(By.tagName("cc"));

  public void login(){
      /**
       * elments.length() will tell number of element with input tag in this DOM
       * To get the first input tag element use elements.get(0);
       * */
      elements.get(0).sendKeys("userName");
      elements.get(1).sendKeys("password");
  }

    public String contactUs(){

        String getText = pageHeading.getText();


      return getText;

    }




}
