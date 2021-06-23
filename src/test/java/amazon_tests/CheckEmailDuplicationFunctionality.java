package amazon_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CheckEmailDuplicationFunctionality extends BaseTest {

    @Test(description = "Check that amazon.com users doesn't have which have same email")
    public void checkEmailDuplicationFunctionality() throws InterruptedException {
        homePage.clickOnAccountListButton();
        loginPage.clickOnCreateAccountButton();
        Assert.assertTrue(homePage.waitToTitleContains("Amazon Registration"),
                "Title doesn't contain 'Amazon Registration'");
        signUpPage.fillValueInYourNameField("Artash055");
        signUpPage.fillValueInEmailField("artashes.pivazyan@gmail.com");
        signUpPage.fillValueInPasswordField("artash1996");
        signUpPage.fillValueInReEnterPasswordField("artash1996");
        signUpPage.clickOnCreateYourAmazonAccountButton();
        Assert.assertEquals(signUpPage.getSignUpInfo(), "Email address already in use\n" +
                "You indicated you're a new customer, but an account already exists with the email address artashes.pivazyan@gmail.com.");
    }
}
