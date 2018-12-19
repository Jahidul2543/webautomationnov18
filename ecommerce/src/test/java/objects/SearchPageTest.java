package objects;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends CommonAPI {

    @Test
    public void contactUsTest(){

        driver.findElement(By.partialLinkText("Contact us")).click();
        String actualText = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals(actualText, "CUSTOMER SERVICE - CONTACT US");
        System.out.println("Test Passed");
        System.out.println("I am in SearchPageTest ");

    }

}
