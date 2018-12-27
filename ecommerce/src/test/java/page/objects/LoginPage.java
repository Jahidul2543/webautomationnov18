package page.objects;

import application.page.base.ApplicationPageBase;
import base.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import reporting.TestLogger;

public class LoginPage extends ApplicationPageBase {
     private WebDriver driver ;
    @FindBy(how = How.ID, id = "email")
    private WebElement emailBox;

    @FindBy(how = How.ID, id = "passwd")
    private WebElement passwordBox;

    @FindBy(how = How.CLASS_NAME, css = "#center_column > div.alert.alert-danger > p")
    private WebElement errorMessage;

    @FindBy(how = How.ID, id = "SubmitLogin")
    private WebElement submitButton;

    public LoginPage login(String email, String password){

        sendKeys(emailBox, "emailBox", email);
        sendKeys(passwordBox,"passwordBox", password);
        click(submitButton,"submitButton");

        return new LoginPage();

    }


    public String getErroMessage(){

        String actualText = getText(errorMessage,"errorMessage");

        return actualText;
    }


    /*public LoginPage login(String email, String password){

        TestLogger.log("Sending keys to email box");
        sendKeys(emailBox,"emailBox", email);
        sendKeys(passwordBox,"passwordBox",password);


        return new LoginPage();

    }*/



}
