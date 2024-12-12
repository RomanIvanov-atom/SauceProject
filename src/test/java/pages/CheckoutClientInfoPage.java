package pages;

import base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutClientInfoPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.xpath("//*[@id='first-name']");
    private static final By LAST_NAME_INPUT = By.xpath("//*[@id='last-name']");
    private static final By POSTAL_CODE_INPUT = By.xpath("//*[@id='postal-code']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");
    private static final By VALIDATION_ERROR_MESSAGE = By.xpath(
            "//div[@class='checkout_info']//div[@class='error-message-container error']");

    public CheckoutClientInfoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение всех полей")
    public void fillAllInputs(String firstName, String lastName, String zipCode) {
        log.info("Filling all fields with client's info");
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(zipCode);
    }

    @Step("Нажатие кнопки 'Продолжить'")
    public void clickContinueButton() {
        log.info("Click 'Continue'");
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Получение информации о видимости сообщения об ошибке")
    public boolean isValidationErrorVisible() {
        return driver.findElement(VALIDATION_ERROR_MESSAGE).isDisplayed();
    }
}
