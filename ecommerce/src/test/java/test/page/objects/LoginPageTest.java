package test.page.objects;

import application.page.base.ApplicationPageBase;
import com.util.xlsx.reader.MyDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.LoginPage;


import java.io.File;

public class LoginPageTest extends ApplicationPageBase {

    LoginPage objLoginPage = null;
    HomePage objHomePage = null;
    //WebDriver driver;

    @BeforeMethod
    public void initializationOfElements() {

        objLoginPage= PageFactory.initElements(driver, LoginPage.class);
        objHomePage = PageFactory.initElements(driver, HomePage.class);
    }

    @DataProvider(name="DP")
    public Object[][] getTestData() throws Exception{
        File filepath = new File(System.getProperty("user.dir") +  "/testData/TestData.xlsx");
        MyDataReader dr = new MyDataReader();
        dr.setExcelFile(filepath.getAbsolutePath());
        String[][] data = dr.getExcelSheetData("Sheet2");
        return data;
    }

  //  @Test
    @Test(dataProvider="DP")
    public void invalidSignIn(String email, String password/*, String VerificationText*/){

        objHomePage.getLogInPage();
        objLoginPage.login(email, password);



    }
}
