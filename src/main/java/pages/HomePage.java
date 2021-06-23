package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage {

    WebDriver webDriver;

    @FindBy(className = "sc-product-link")
    private WebElement productLinkElement;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchSubmitButton;

    @FindBy(id = "nav-xshop")
    private WebElement navigationItemElement;

    @FindBy(id = "a-price")
    private WebElement priceElement;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchItemElement;

    @FindBy(id = "nav-link-accountList")
    private WebElement accountListElement;

    @FindBy(id = "gc-buy-box-atc")
    private WebElement addCardButtonElement;

    @FindBy(id = "nav-cart")
    private WebElement navCardButtonElement;

    @FindBy(id = "nav-cart-count")
    private WebElement navCardCountElement;

    @FindBy(id = "nav-global-location-popover-link")
    private WebElement deliverIconElement;

    @FindBy(id = " GLUXCountryListDropdown")
    private WebElement countryListDropDownElement;

    @FindBy(id = "buy-now-button")
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

    public void clickDeliverIcon() {
        clickOnElement(deliverIconElement);
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
//        if(webDriver.findElement(By.className("a-icon-close")).isDisplayed())
        clickOnElement(buyNowButtonElement);
    }

    public void clickOnAddCardButton() {
        clickOnElement(addCardButtonElement);
    }

    public void searchItem(String value) {
        fillText(searchItemElement, value);
    }

    public void selectNavigationTab(String tabName) {
        waitToElementIsVisible(navigationItemElement);
        List<WebElement> navigationTabElements = navigationItemElement.
                findElements(By.tagName("a"));
        for (WebElement navigationTabElement : navigationTabElements) {
            if (navigationTabElement.getText().equals(tabName)) {
                clickOnElement(navigationTabElement);
                break;
            }
        }
    }

    public void clickOnNavCardButton() {
        clickOnElement(navCardButtonElement);
    }

    public void clickOnSearchSubmitButton() {
        clickOnElement(searchSubmitButton);
    }

    public String getCardCount() {
        return getElementText(navCardButtonElement);
    }

}
