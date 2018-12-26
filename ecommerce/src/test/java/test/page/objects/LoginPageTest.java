package test.page.objects;

import application.page.base.ApplicationPageBase;
import com.util.xlsx.reader.MyDataReader;
import google.sheet.api.GoogleSheetReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.LoginPage;


import java.io.File;
import java.io.IOException;
import java.util.List;

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
    @Test(dataProvider="DP", enabled = false)
    public void invalidSignIn(String email, String password/*, String VerificationText*/){

        objHomePage.getLogInPage();
        objLoginPage.login(email, password);


    }
    @Test
    public void invalidSignInUsingGoogleSheet(/*String email, String password, String VerificationText*/) throws IOException {
        String spreadsheetId = "1A6G3avCchSjTPM1xoGU8YaYo3azwl4uHBsfgwRZB31A" ;
        String range = "Sheet1!A2:D";

        List<List<Object>> cellValue = GoogleSheetReader.getSpreadSheetRecords(spreadsheetId, range);
        objHomePage.getLogInPage();

        for (List cell : cellValue) {

            objLoginPage.login(cell.get(1).toString(), cell.get(2).toString());
        }

    }

   /* public List<String> signInByInvalidIdPass(String spreadsheetId, String range) throws IOException, InterruptedException {

        List<List<Object>> cellValue = GoogleSheetReader.getSpreadSheetRecords(spreadsheetId, range);
        List<String> actual = new ArrayList<>();
        for (List cell : cellValue) {
            sleepFor(1);
            inputValueInTextBoxByWebElement(account, cell.get(1).toString());
            inputValueInTextBoxByWebElement(password, cell.get(2).toString());
            sleepFor(1);
            //actual.add(getCurrentPageTitle());
            actual.add(getTextByWebElement(signInErrorMesage));
            System.out.println(getTextByWebElement(signInErrorMesage));
            clearInputBox(account);
            clearInputBox(password);
            sleepFor(1);
        }
        return actual;
    }*/

}
