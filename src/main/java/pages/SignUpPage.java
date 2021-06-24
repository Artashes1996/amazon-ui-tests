package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "ap_customer_name")
    private WebElement customerNameElement;

    @FindBy(id = "ap_email")
    private WebElement emailElement;

    @FindBy(id = "ap_password")
    private WebElement passwordElement;

    @FindBy(id = "ap_password_check")
    private WebElement reEnterPasswordElement;

    @FindBy(id = "auth-create-account-link")
    private WebElement createAccountElement;

    @FindBy(id = "continue")
    private WebElement createYourAmazonAccountButtonElement;

    @FindBy(className = "a-spacing-large")
    private WebElement signUpInfoElement;

    public void fillValueInYourNameField(String value) {
        fillText(customerNameElement, value);
    }

    public void fillValueInEmailField(String value) {
        fillText(emailElement, value);
    }

    public void fillValueInPasswordField(String value) {
        fillText(passwordElement, value);
    }

    public void fillValueInReEnterPasswordField(String value) {
        fillText(reEnterPasswordElement, value);
    }

    public void clickOnCreateYourAmazonAccountButton() {
        clickOnElement(createYourAmazonAccountButtonElement);
    }

    public String getSignUpInfo() {
        return getElementText(signUpInfoElement);
    }

}
    



