package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BlazeDemoHomepage;
import utilities.Configuration;
import utilities.Driver;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class BlazeDemoTest extends TestBase {

    BlazeDemoHomepage blazeDemoHomepage = new BlazeDemoHomepage();



    @Test
    public void test(){
        driver.get(Configuration.GetProperty("URL"));
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        blazeDemoHomepage.findFlightsButton.click();
        String expectedTitle = "BlazeDemo - reserve";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
