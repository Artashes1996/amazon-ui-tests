package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "ap_email")
    private WebElement emailFieldElement;

    @FindBy(id = "ap_password")
    private WebElement passwordFieldElement;

    @FindBy(id = "continue")
    private WebElement continueButtonElement;

    @FindBy(id = "auth-signin-button")
    private WebElement signInButtonElement;

    @FindBy(id = "createAccountSubmit")
    private WebElement createAccountButtonElement;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillValueInEmailField(String value) {
        fillText(emailFieldElement, value);
    }

    public void fillValueInPasswordField(String value) {
        fillText(passwordFieldElement, value);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButtonElement);
    }

    public void clickOnSignInButton() {
        clickOnElement(signInButtonElement);
    }

    public void clickOnCreateAccountButton() {
        clickOnElement(createAccountButtonElement);
    }


}
