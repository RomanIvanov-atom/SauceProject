package pages;

import base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private static final By USER_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public void open() {
        log.info("Open login page");
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Вход в систему с логином {user} и паролем {password}")
    public void login(String user, String password) {
        log.info("Logging with {} username and {} password", user, password);
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Получение сообщения об ошибке")
    public String getErrorMessage() {
        log.info("Try to get error message");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
