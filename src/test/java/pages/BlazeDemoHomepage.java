package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazeDemoHomepage {

    //Once we create object of of this
    //below constructor will be called.

    //initElements(driver, this); will initialize all
    //webelement variable with value.

    public BlazeDemoHomepage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@type='submit']")
    public WebElement findFlightsButton;

}
