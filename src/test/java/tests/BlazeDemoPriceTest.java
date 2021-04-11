package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazeDemoFlightsPage;
import pages.BlazeDemoHomepage;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;

public class BlazeDemoPriceTest extends TestBase {

    BlazeDemoHomepage blazeDemoHomepage = new BlazeDemoHomepage();
    BlazeDemoFlightsPage blazeDemoFlightsPage = new BlazeDemoFlightsPage();
    //Test verifies all prices are below $1,000

    @Test
    public void priceTest(){


        driver.get(Configuration.GetProperty("URL"));
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        blazeDemoHomepage.findFlightsButton.click();
       // List<WebElement> prices = driver.findElements(By.xpath("//table[@class='table']//td[6]"));

        List<WebElement> prices = blazeDemoFlightsPage.prices;

        for(WebElement price:prices){
            String strPrice = price.getText().substring(1); //substring will remove $
            double doublePrice = Double.parseDouble(strPrice);

            Assert.assertTrue(doublePrice<1000);

            System.out.println(doublePrice);
        }

    }
    @Test
    public void airlineTest(){
        int count =1;
        String expectedAirline= "Virgin America";
        driver.get("https://blazedemo.com/reserve.php");
        List<WebElement> airlineName = driver.findElements(By.xpath("//table[@class='table']//td[3]"));

        for(WebElement airline:airlineName){
            String actualAirLine = airline.getText();
            count++;
            actualAirLine.contains("Virgin America");
            System.out.println(actualAirLine.contains("Virgin America"));




            System.out.println(actualAirLine);

        }


    }

    @Test
    public void cityCompare(){
        driver.get("https://blazedemo.com/index.php");
        String expectedPage = "Flights from San Diego to New York:";
       WebElement departCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
       departCity.click();
       Select select = new Select(departCity);
       select.selectByVisibleText("San Diego");
       departCity.click();

       WebElement destinationCity = driver.findElement(By.xpath("//select[@name='toPort']"));
       destinationCity.click();
        Select select2 = new Select(destinationCity);
        select2.selectByVisibleText("New York");
        destinationCity.click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement actualPage = driver.findElement(By.xpath("//div[@class='container']/h3"));
        String actualSite = actualPage.getText();
        Assert.assertEquals(actualSite,expectedPage);

    }

    //two virgin america .
    //verify flight destination is correct.

}
