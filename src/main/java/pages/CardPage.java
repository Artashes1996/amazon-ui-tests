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

    @FindBy(className = "sc-invisible-when-no-js")
    private WebElement deleteItemElement;

    @FindBy(className = "a-text-left")
    private List<WebElement> deleteAllItemsElements;

    public CardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean getHeaderText(String value) throws InterruptedException {
        boolean bool = false;
        if(getElementText(cardHeaderElement).contains(value)) {
            bool = true;
        }
        return bool;
    }

    public void clickOnDeleteButton() {
        clickOnElement(deleteItemElement);
    }

    public void deleteItems() {
        for (WebElement item : deleteAllItemsElements) {
            if (item.getText().contains("Delete all items")) {
                clickOnElement(item);
                break;
            }
        }
    }


}
