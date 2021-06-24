package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage {

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchSubmitButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchItemElement;

    @FindBy(id = "nav-link-accountList")
    private WebElement accountListElement;

    @FindBy(id = "nav-cart")
    private WebElement navCartButtonElement;

    @FindBy(className = "qa-buy-now-button")
    private WebElement buyNowButtonElement;

    @FindBy(id = "p_n_condition-type/New")
    private WebElement newCondition;

    @FindBy(className = "s-line-clamp-2")
    private List<WebElement> itemElements;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAccountListButton() {
        clickOnElement(accountListElement);
    }

    public void setNewCondition() {
        clickOnElement(newCondition);
    }

    public void openItem() {
        for (WebElement item : itemElements) {
            if (item.getText().contains("iPhone")) {
                clickOnElement(item);
                break;
            }
        }
    }

    public void clickOnBuyNowButton() {
        clickOnElement(buyNowButtonElement);
    }

    public void searchItem(String value) {
        fillText(searchItemElement, value);
    }

    public void clickOnNavCartButton() {
        clickOnElement(navCartButtonElement);
    }

    public void clickOnSearchSubmitButton() {
        clickOnElement(searchSubmitButton);
    }

    public String getCardCount() throws InterruptedException {
        Thread.sleep(2000); /* Is not good practice*/
        return getElementText(navCartButtonElement);
    }

}
