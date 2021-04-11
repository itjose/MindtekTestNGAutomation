package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppHomePage;
import pages.StoreAppRegisterPage;
import pages.StoreAppSignInPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.DataUtils;
import utilities.TestBase;

public class StoreAppSignUpTest extends TestBase {


    @DataProvider(name="signUpTestData")
    public static Object[][] testData(){
        return new Object[][]{
                {"john", "Doe", "123468", "1", "12", "2000", "123 Wasginton blvd", "chicago", "13", "60640", "3129585646"},
                {"John", "Mr Doe", "dhsjkss", "1", "11", "2020", "33 de road", "New York", "32", "50505", "7998884455"}
        };

    }


    @Test(dataProvider = "signUpTestData")
    public void signUpTest(String firstName, String lastName, String password,
                           String day, String month, String year, String address,
                           String city, String state, String postcode, String mobileNumber){

        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppSignInPage storeAppSignInPage = new StoreAppSignInPage();
        StoreAppRegisterPage storeAppRegisterPage = new StoreAppRegisterPage();



        driver.get(Configuration.GetProperty("StoreURL"));
        storeAppHomePage.signInButton.click();
        storeAppSignInPage.emailInputBox.sendKeys(DataUtils.getRandomEmail());
        storeAppSignInPage.CreateAccountButton.click();
        storeAppRegisterPage.FirstName.sendKeys(firstName);
        storeAppRegisterPage.lastName.sendKeys(lastName);
        storeAppRegisterPage.password.sendKeys(password);

        //Select select = new Select(storeAppRegisterPage.days);
        //select.selectByValue("1");

        BrowserUtils.selectDropdownByValue(storeAppRegisterPage.days, day);
        BrowserUtils.selectDropdownByValue(storeAppRegisterPage.months, month);
        BrowserUtils.selectDropdownByValue(storeAppRegisterPage.years, year);
        storeAppRegisterPage.address1.sendKeys(address);
        storeAppRegisterPage.cities.sendKeys(city);
        BrowserUtils.selectDropdownByValue(storeAppRegisterPage.states, state);
        storeAppRegisterPage.postcode.sendKeys(postcode);
        storeAppRegisterPage.mobile.sendKeys(mobileNumber);
        storeAppRegisterPage.registerButton.click();
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Actual title "+actualTitle+
                " didn't match with expected title"+expectedTitle);

    }


}
