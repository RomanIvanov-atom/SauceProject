package pages;

import base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class CartPage extends BasePage {

    private static final By ITEM_NAME_IN_CART = By.cssSelector(".inventory_item_name");
    private static final By UNIQUE_ITEM_IN_CART = By.xpath("//*[@class='cart_list']//*[@class='cart_item']");
    private static final String SPECIFIC_ITEM_REMOVE_BUTTON_PATTERN = "//*[@class='cart_item']" +
            "//*[text()='%s']//ancestor::div[@class='cart_item']//button[text()='Remove']";
    private static final By CHECKOUT_BUTTON = By.xpath("//*[@id='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение имени товара в корзине")
    public String getItemNameInCart() {
        log.info("Get item name from cart");
        return driver.findElement(ITEM_NAME_IN_CART).getText();
    }

    @Step("Получение имен товаров в корзине")
    public List<String> getItemNamesInCart() {
        log.info("Get item names from cart");
        return driver.findElements(ITEM_NAME_IN_CART)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Получение списка продуктов в корзине")
    public int getCountOfProductsInCart() {
        log.info("Counting products in cart..");
        return driver.findElements(UNIQUE_ITEM_IN_CART).size();
    }

    @Step("Удаление {deleteItemName} из корзины")
    public void deleteSpecificItemFromCart(String deleteItemName) {
        log.info("Deleteing {} from cart", deleteItemName);
        By deleteItem = By.xpath(String.format(SPECIFIC_ITEM_REMOVE_BUTTON_PATTERN, deleteItemName));
        driver.findElement(deleteItem).click();
    }

    @Step("Удаление списка товаров с корзины из корзины")
    public void deleteSpecificItemsFromCart(List<String> itemsForDelete) {
        log.info("Deleting item list from cart");
        itemsForDelete.stream().forEach(item -> {
            By deleteItem = By.xpath(String.format(SPECIFIC_ITEM_REMOVE_BUTTON_PATTERN, item));
            driver.findElement(deleteItem).click();
        });
    }

    @Step("Клик по корзине")
    public void clickCheckoutButton() {
        log.info("Click on checkout button");
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
