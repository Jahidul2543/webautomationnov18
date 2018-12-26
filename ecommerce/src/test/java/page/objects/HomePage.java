package page.objects;


import application.page.base.ApplicationPageBase;
import base.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import reporting.TestLogger;

public class HomePage extends ApplicationPageBase  {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement searchBox;

    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Contact us")
    private WebElement contactUs;

    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Sign in")
    private WebElement signInButton;

    public HomePage() {
        super(BrowserDriver.getUrl());
        this.driver = BrowserDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @Override
    protected void isLoaded() throws Error {

        TestLogger.log("AV Home Page has been loaded");
    }
    public LoginPage getLogInPage() {

        signInButton.click();
        return new LoginPage();
    }

    public void clickContactUs(){

        ApplicationPageBase.isEnableStatus(driver, contactUs);
        contactUs.click();

    }
    public String search (){

        searchBox.sendKeys("Shoes", Keys.ENTER);
        String actualText = driver.findElement(By.partialLinkText("Printed Chiffon Dress")).getText();

      return actualText;

    }


}





















/*public HomePage() {
      // BrowserDriver.getUrl());
       // this.driver=BrowserDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
*/