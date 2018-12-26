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

    public LoginPage() {
        super(BrowserDriver.getUrl());
        this.driver = BrowserDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @Override
    protected void isLoaded() throws Error {

        TestLogger.log("AV Home Page has been loaded");
    }

    public LoginPage login(String email, String password){

        TestLogger.log("Sending keys to email box");
        sendKeys(emailBox,"emailBox", email);
        sendKeys(passwordBox,"passwordBox",password);

        return new LoginPage();

    }

}
