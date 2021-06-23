package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30);
    }

    public void scrollIntoElement(WebElement webElement) {
        String javascript = "arguments[0].scrollIntoView()";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript(javascript, webElement);
    }

    public void clickOnElement(WebElement webElement) {
        waitToElementIsVisible(webElement);
        scrollIntoElement(webElement);
        webElement.click();
    }

    public void fillText(WebElement webElement, String strText) {
        waitToElementIsVisible(webElement);
        webElement.clear();
        webElement.sendKeys(strText);
    }

    public String getElementText(WebElement webElement) {
        scrollIntoElement(webElement);
        waitToElementIsVisible(webElement);
        return webElement.getText();
    }

    public String getWebElementText(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return arguments[0].text;", webElement);
    }

    public void waitToElementIsVisible(WebElement webElement) throws TimeoutException {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitToElementsCount(By by, int number) throws TimeoutException {
        this.webDriverWait.until(ExpectedConditions.numberOfElementsToBe(by, 0));
    }

    public boolean waitToTitleContains(String title) {
        this.webDriverWait.until(ExpectedConditions.titleContains(title));
        return true;
    }

    public void openUrl(String URL) {
        webDriver.navigate().to(URL);
    }
}
