package tests.base;

import helper.Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseTest {
    public String baseUrl;

    public ThreadLocal<WebDriver> driver;
    public SignUpPage signUpPage;
    public HomePage homePage;
    public LoginPage loginPage;
    public CardPage cardPage;

    protected WebDriver webDriver() {
        return driver.get();
    }

    @BeforeClass(alwaysRun = true, description = "Before class")
    public void setup() throws Exception {
        baseUrl = "https://www.amazon.com/";
        driver = new ThreadLocal<>();
        driver.set(Factory.createWebDriver());
        driver.get().manage().window().maximize();
        signUpPage = PageFactory.initElements(webDriver(), SignUpPage.class);
        homePage = PageFactory.initElements(webDriver(), HomePage.class);
        loginPage = PageFactory.initElements(webDriver(), LoginPage.class);
        cardPage = PageFactory.initElements(webDriver(), CardPage.class);
        webDriver().navigate().to(baseUrl);
    }

    @AfterMethod
    public void screenShot(ITestResult result, Method method) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(webDriver());
            ImageIO.write(myScreenshot.getImage(), "PNG", new File("target/" + method.getName() + "screenshot.png"));
        }
    }

    @AfterClass(alwaysRun = true, description = "After method")
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}