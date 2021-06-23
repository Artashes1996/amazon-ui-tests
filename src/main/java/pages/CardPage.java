package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CardPage extends BasePage {
    @FindBy(className = "acs-product-block")
    private List<WebElement> emailFieldElement;

    @FindBy(id = "sc-active-cart")
    private WebElement cardHeaderElement;

    @FindBy(id = "gc-order-form-recipients")
    private WebElement toEmailElement;

    @FindBy(xpath = "//input[@data-action='delete']")
    private WebElement deleteGiftCardElement;

    public CardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHeaderText() throws InterruptedException {
        Thread.sleep(2000); /* Is not good practice */
        return getElementText(cardHeaderElement);
    }

    public void clickOnDeleteButtonForGiftCard() {
        clickOnElement(deleteGiftCardElement);
    }


}
