package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void fillAllInputs(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(zipCode);
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public boolean isValidationErrorVisible() {
        return driver.findElement(VALIDATION_ERROR_MESSAGE).isDisplayed();
    }
}
