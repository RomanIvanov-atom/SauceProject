package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.listeners.TestListener;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutClientInfoPage checkoutClientInfoPage;
    protected CheckoutCartOverviewPage checkoutCartOverviewPage;

    @Parameters({"browser"})
    @BeforeMethod
    @Step("Открытие браузера")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            driver = new EdgeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // в контекст теста добавляем драйвер по ключу 'driver'. Он потом передается в метод onTestFailure в Listener'е
        context.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutClientInfoPage = new CheckoutClientInfoPage(driver);
        checkoutCartOverviewPage = new CheckoutCartOverviewPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
