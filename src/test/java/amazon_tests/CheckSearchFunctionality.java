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
        Assert.assertTrue(homePage.waitToTitleContains("Select a Payment Method - Amazon.com Checkout"),
                "Title doesn't contain 'Select a Payment Method - Amazon.com Checkout'");
        Assert.assertTrue(homePage.waitToTitleContains("Select a Payment Method - Amazon.com Checkout"),
                "Title doesn't contain 'Select a Payment Method - Amazon.com Checkout'");
        homePage.openUrl("https://www.amazon.com/");
        Assert.assertTrue(cardPage.waitToTitleContains("Amazon.com. Spend less. Smile more."));
        Assert.assertEquals(homePage.getCardCount(), "3\n" +
                "Cart", "Card Count is not 3");
        homePage.clickOnNavCartButton();
        cardPage.clickOnDeleteButton();
        cardPage.deleteItems();
        Assert.assertTrue(homePage.waitToUrlContains("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart"));
        Assert.assertTrue(cardPage.getHeaderText("Your Amazon Cart is empty."), "'Your Amazon Cart is empty.' header is not available");
    }
}