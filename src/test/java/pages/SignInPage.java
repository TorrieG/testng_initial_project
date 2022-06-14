package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage {
    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    public WebElement signInHeading;

    @FindBy(css = "p[class='sds-page-section__title--sub signup-block']")
    public WebElement subHeadingNewToCarsCom;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(className = "sds-label")
    public List<WebElement> emailPasswordLabels;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(css = "p[class='sds-helper-text']")
    public WebElement passwordMinEightCharacters;

    @FindBy(css = "a[href='/forgot_password/?email=']")
    public WebElement forgotPasswordLink;

    @FindBy(css = "div[class='sds-disclaimer ']")
    public WebElement privacyStatementAndTermsOfServiceText;

    @FindBy(tagName = "h3")
    public WebElement connectWithSocialHeading;

    @FindBy(css = "ul[class='sds-list']:nth-child(2) a")
    public List<WebElement> facebookGoogleAppleSignInLinks;

    @FindBy(css = "div[class='sds-notification__title']")
    public WebElement unableToSignYouInErrorMessage;

    @FindBy(css = "p[class='sds-notification__desc']")
    public WebElement emailPasswordNotRecognizedMessage;


}
