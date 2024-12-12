package pages;

import base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final By CART_LINK = By.cssSelector(".shopping_cart_link");
    private final By UNIQUE_ITEM = By.xpath("//div[@class='inventory_list']/div[@class='inventory_item']");
    private final By SORTING_DROPDOWN =
            By.xpath("//div[@class='header_secondary_container']//select[@class='product_sort_container']");
    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    @Step("Получение тайтла")
    public String getTitle() {
        log.info("Get page's title");
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с именем {productName} в корзину")
    public void clickAddButton(String productName) {
        log.info("Add {} in cart", productName);
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, productName));
        driver.findElement(addToCart).click();
    }

    @Step("Клик по корзине")
    public void clickShoppingCart() {
        log.info("Click 'Cart'");
        driver.findElement(CART_LINK).click();
    }

    @Step("Получение количества продуктов на главной странице")
    public int getCountOfProductsOnProductsPage() {
        log.info("Get count of products on main page");
        return driver.findElements(UNIQUE_ITEM).size();
    }

    @Step("Проверка наличия кнопки сортировки на странице")
    public boolean isSortingButtonPresentsOnPage() {
        return driver.findElement(SORTING_DROPDOWN).isDisplayed();
    }
}