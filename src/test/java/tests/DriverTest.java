package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import utilities.Configuration;

public class DriverTest {

    @Test
    public void testProperties(){
        System.out.println(Configuration.GetProperty("browser"));
    }
}
