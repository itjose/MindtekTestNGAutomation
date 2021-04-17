package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class StoreAppHomePage {
    public StoreAppHomePage(){

        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

            }

            @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

            @FindBy(xpath = "//a[@title='View my shopping cart']")
    public WebElement cartButton;

            @FindBy(xpath = "//div[@class='button-container']//a[@data-id-product='2']")
    public WebElement blouseButton;

            @FindBy(id = "add_to_cart")
    public WebElement addToCartButton2;

            @FindBy(xpath = "//span[@title='Continue shopping']")
    public WebElement keepShopping;

        }

