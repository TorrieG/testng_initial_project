package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarsCom extends Base {

    @Test(priority = 1, description = "TC1 | Validate Cars.com Sign in page form")
    public void testSignInPageForm() {
        Assert.assertEquals(signInPage.signInHeading.getText(), "Sign in");
        Assert.assertEquals(signInPage.subHeadingNewToCarsCom.getText(), "New to Cars.com? Sign up. Are you a dealer?");
        Assert.assertEquals(signInPage.emailPasswordLabels.get(0).getText(), "Email");
        Assert.assertEquals(signInPage.emailPasswordLabels.get(1).getText(), "Password");
        Assert.assertEquals(signInPage.passwordMinEightCharacters.getText(), "Minimum of eight characters");
        Assert.assertTrue(signInPage.forgotPasswordLink.isDisplayed());
        Assert.assertEquals(signInPage.privacyStatementAndTermsOfServiceText.getText(), "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.");
        Assert.assertEquals(signInPage.signInButton.getText(), "Sign in");
        Assert.assertTrue(signInPage.signInButton.isDisplayed());
        Assert.assertTrue(signInPage.signInButton.isEnabled());
    }

    @Test(priority = 2, description = "TC2 | Validate Cars.com Sign in page social media section")
    public void testSignInPageSocialMediaSection() {
        Assert.assertEquals(signInPage.connectWithSocialHeading.getText(), "Connect with social");
        String[] socialMediaText = {"Sign in with Facebook", "Sign in with Google", "Sign in with Apple"};
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(signInPage.facebookGoogleAppleSignInLinks.get(i).getText(), socialMediaText[i]);
            Assert.assertTrue(signInPage.facebookGoogleAppleSignInLinks.get(i).isDisplayed());
            Assert.assertTrue(signInPage.facebookGoogleAppleSignInLinks.get(i).isEnabled());
        }
    }

    @Test(priority = 3, description = "TC3 | Validate user cannot sign in to Cars.com with invalid credentials")
    public void testFailedSignInInvalidCredentials() {
        signInPage.emailInputBox.sendKeys("johndoe@gmail.com");
        signInPage.passwordInputBox.sendKeys("abcd1234");
        signInPage.signInButton.click();

        Assert.assertEquals(signInPage.unableToSignYouInErrorMessage.getText(), "We were unable to sign you in.");
        Assert.assertEquals(signInPage.emailPasswordNotRecognizedMessage.getText(), "Your email or password was not recognized. Try again soon.");
    }
}
