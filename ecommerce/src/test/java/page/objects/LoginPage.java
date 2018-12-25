package page.objects;

import application.page.base.ApplicationPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends ApplicationPageBase {

    @FindBy(how = How.ID, id = "email")
    private WebElement emailBox;

    @FindBy(how = How.ID, id = "passwd")
    private WebElement passwordBox;

    public LoginPage login(String email, String password){

        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);

        return new LoginPage();

    }

}
