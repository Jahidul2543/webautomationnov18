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
import sheet.google.api.GoogleSheetReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class LoginPageTest extends ApplicationPageBase {

    LoginPage objLoginPage = null;
    HomePage objHomePage = null;


    @BeforeMethod
    public void initializationOfElements() {

        objLoginPage= PageFactory.initElements(driver, LoginPage.class);
        objHomePage = PageFactory.initElements(driver, HomePage.class);
    }

   /* @DataProvider(name="DP")
    public Object[][] getTestData() throws Exception{
        File filepath = new File(System.getProperty("user.dir") +  "/testData/TestData.xlsx");
        MyDataReader dr = new MyDataReader();
        //Show me where is data file
        dr.setExcelFile(filepath.getAbsolutePath());

        String[][] data = dr.getExcelSheetData("Sheet3");
        return data;
    }



    @Test(dataProvider = "DP")
    public  void invalidSignin(String email, String password, String expectedErroMessage){

        objHomePage.getLogInPage();
        objLoginPage.login(email, password);
        String expectedText = expectedErroMessage;
        String actulText = objLoginPage.getErroMessage();
        Assert.assertEquals(actulText, expectedText);

    }*/
    @Test
    public  void invalidSigninByGoogleSheetApi() throws IOException {

        Properties properties = loadProperties();
       String spreadsheetId = properties.getProperty("GOOGLE.spreadsheetId");
       String range = "Sheet4!A2:D";
       List<List<Object>> getRecords = GoogleSheetReader.getSpreadSheetRecords(spreadsheetId,range);



        for (List cell: getRecords) {
            objHomePage.getLogInPage();
            objLoginPage.login(cell.get(1).toString(), cell.get(2).toString());

            String expectedText = cell.get(3).toString();

            String actulText = objLoginPage.getErroMessage();
            Assert.assertEquals(actulText, expectedText);

        }



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
