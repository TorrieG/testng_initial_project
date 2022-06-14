package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SignInPage;
import utilities.Driver;

public class Base {
    WebDriver driver;
    WebDriverWait explicitWait;
    SoftAssert softAssert;
    Actions actions;
    JavascriptExecutor js;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");
    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
