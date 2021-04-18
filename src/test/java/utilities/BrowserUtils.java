package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserUtils {

    /*
    will accept webelement dropdown and string value of dropdown.
    then it will select by provided value in dropdown.
     */

public static void selectDropdownByValue(WebElement element, String value){
Select select = new Select(element);
select.selectByValue(value);

}
/*
This method will wait for element to be clickable.
 */
public static WebElement waitElementToBeClickable(WebElement element, int seconds){
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
    WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
    return element1;


}
/*
this method will wait for element to be visible.
 */

    public static WebElement waitElementToBeVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        return element1;
    }

    /*
    will help switch windows.
     */

    public static void switchWindow(){
        WebDriver driver = Driver.getDriver();
        String currentWindowID = driver.getWindowHandle();
        Set<String>  windows = driver.getWindowHandles();
        for(String window: windows){
            if(!currentWindowID.equals(window)){
                driver.switchTo().window(window);
            }
        }
    }

    /*
    will scroll up or down
     */

    public static void scroll(int pixels) {
        WebDriver driver = Driver.getDriver();
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollBy(0,"+pixels+")");
    }
}
