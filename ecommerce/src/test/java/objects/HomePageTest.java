package objects;


import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HomePageTest  extends CommonAPI {


    @Test
    public void searchTest (){

        driver.findElement(By.id("search_query_top")).sendKeys("Shoes", Keys.ENTER);
       String actualText = driver.findElement(By.partialLinkText("Printed Chiffon Dress")).getText();
        System.out.println(actualText);

        Assert.assertEquals(actualText, "Printed Chiffon Dress");

    }
    @Test
    public void contactUsTest(){

        driver.findElement(By.partialLinkText("Contact us")).click();
        String actualText = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals(actualText, "CUSTOMER SERVICE - CONTACT US");
        System.out.println("Test Passed");

    }


}
