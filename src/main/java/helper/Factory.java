package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Factory {

    public static WebDriver createWebDriver() {
        final WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
}