package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BuyPage extends BasePage{

    @FindBy(id = "address-ui-widgets-form-submit-button")
    private WebElement useThisAddressElement;

    @FindBy(id = "address-ui-widgets-countryCode")
    private WebElement countryRegionDropDownElement;

    @FindBy(id = "1_dropdown_combobox")
    private WebElement countryDropDownElement;

    @FindBy(id = "address-ui-widgets-enterAddressStateOrRegion")
    private WebElement stateDropDownElement;

    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    private WebElement phoneNumberElement;

    @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
    private WebElement zipCodeElement;

    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    private WebElement addressLine1Element;

    @FindBy(id = "address-ui-widgets-enterAddressCity")
    private WebElement cityElement;


    @FindBy(id = "apx-add-credit-card-action-test-id")
    private WebElement addCreditCardButton;


    public BuyPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnUseThisAddressButton() {
        clickOnElement(useThisAddressElement);
    }

    public void selectValueInCountryRegionField(String countryName) {
        clickOnElement(countryRegionDropDownElement);
        List<WebElement> dropDownElements = countryDropDownElement.findElements(By.tagName("li"));
        for(WebElement dropDownElement: dropDownElements) {
            if(dropDownElement.getText().equals(countryName)) {
                clickOnElement(dropDownElement);
                break;
            }
        }
    }

    public void fillValueInPhoneNumberField(String value) {
        fillText(phoneNumberElement, value);
    }

    public void fillValueInAddressField(String value) {
        fillText(addressLine1Element, value);
        addressLine1Element.sendKeys(Keys.RETURN);

    }

    public void fillValueInCityField(String value) {
        fillText(cityElement, value);
    }

    public void fillValueInZipCodeField(String value) {
       fillText(zipCodeElement, value);
    }

    public void selectValueInStateDropDown(String countryName) {
        clickOnElement(stateDropDownElement);
        List<WebElement> dropDownElements = countryDropDownElement.findElements(By.tagName("li"));
        for(WebElement dropDownElement: dropDownElements) {
            if(dropDownElement.getText().equals(countryName)) {
                clickOnElement(dropDownElement);
                break;
            }
        }
    }

    public boolean waitToAddCreditCardButtonIsVisible() {
        waitToElementIsVisible(addCreditCardButton);
        return true;
    }
}
