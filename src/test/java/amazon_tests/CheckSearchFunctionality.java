package amazon_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CheckSearchFunctionality extends BaseTest {

    @Test
    public void checkSearchFunctionality() throws InterruptedException {
        homePage.clickOnAccountListButton();
        loginPage.fillValueInEmailField("mihran.pivazyan@gmail.com");
        loginPage.clickOnContinueButton();
        loginPage.fillValueInPasswordField("mihran1963");
        loginPage.clickOnSignInButton();
        homePage.searchItem("Iphone 8");
        homePage.clickOnSearchSubmitButton();
        Assert.assertTrue(homePage.waitToTitleContains("Amazon.com : Iphone 8"),
                "Title doesn't contain 'Amazon.com : Iphone 8'");
        homePage.setNewCondition();
        homePage.openItem();
        homePage.clickOnBuyNowButton();
        Assert.assertTrue(homePage.waitToTitleContains("Select a shipping address"),
                "Title doesn't contain 'Select a shipping address'");
        buyPage.fillValueInPhoneNumberField("+374123456789");
        buyPage.fillValueInAddressField("Aeropost Way");
        buyPage.fillValueInCityField("Miami");
        buyPage.selectValueInStateDropDown("Florida");
        buyPage.fillValueInZipCodeField("33206");
        buyPage.clickOnUseThisAddressButton();
        Assert.assertTrue(homePage.waitToTitleContains("Select a Payment Method - Amazon.com Checkout"),
                "Title doesn't contain 'Select a Payment Method - Amazon.com Checkout'");
        homePage.openUrl("https://www.amazon.com/");
        Assert.assertTrue(cardPage.waitToTitleContains("Amazon.com. Spend less. Smile more."));
        Assert.assertEquals(homePage.getCardCount(), "1\n" +
                "Cart", "Card Count is not 1");
        homePage.clickOnNavCardButton();
        cardPage.clickOnDeleteButtonForGiftCard();
        Assert.assertEquals(homePage.getCardCount(), "0\n" +
                "Cart", "Card Count is not 0");
        Assert.assertEquals(cardPage.getHeaderText(), "Your Amazon Cart is empty.\n" +
                "Your Shopping Cart lives to serve. Give it purpose — fill it with groceries, clothing, household supplies, electronics, and more.\n" +
                "Continue shopping on the Amazon.com homepage, learn about today's deals, or visit your Wish List.");
    }
}
