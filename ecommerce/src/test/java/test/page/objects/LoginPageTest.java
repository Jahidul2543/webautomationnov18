package test.page.objects;

import application.page.base.ApplicationPageBase;
import com.xlsx.api.MyDataReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.LoginPage;


import java.io.File;

public class LoginPageTest extends ApplicationPageBase {

    LoginPage objLoginPage = null;
    HomePage objHomePage = null;


    @BeforeMethod
    public void initializationOfElements() {

        objLoginPage= PageFactory.initElements(driver, LoginPage.class);
        objHomePage = PageFactory.initElements(driver, HomePage.class);
    }

    @DataProvider(name="DP")
    public Object[][] getTestData() throws Exception{
        File filepath = new File(System.getProperty("user.dir") +  "/testData/TestData.xlsx");
        MyDataReader dr = new MyDataReader();
        //Show me where is data file
        dr.setExcelFile(filepath.getAbsolutePath());

        String[][] data = dr.getExcelSheetData("Sheet3");
        return data;
    }


    /*@Test(dataProvider="DP")
    public void invalidSignIn(String email, String password/*, String VerificationText*//*){

        objHomePage.getLogInPage();
        objLoginPage.login(email, password);

    }*/

    @Test(dataProvider = "DP")
    public  void invalidSignin(String email, String password, String expectedErroMessage){

        objHomePage.getLogInPage();
        objLoginPage.login(email, password);
        String expectedText = expectedErroMessage;
        String actulText = objLoginPage.getErroMessage();
        Assert.assertEquals(actulText, expectedText);

    }
}
