package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    private static final By ITEM_NAME_IN_CART = By.cssSelector(".inventory_item_name");
    private static final By UNIQUE_ITEM_IN_CART = By.xpath("//*[@class='cart_list']//*[@class='cart_item']");
    private static final String SPECIFIC_ITEM_REMOVE_BUTTON_PATTERN = "//*[@class='cart_item']" +
            "//*[text()='%s']//ancestor::div[@class='cart_item']//button[text()='Remove']";
    private static final By CHECKOUT_BUTTON = By.xpath("//*[@id='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemNameInCart() {
        return driver.findElement(ITEM_NAME_IN_CART).getText();
    }

    public List<String> getItemNamesInCart() {
        return driver.findElements(ITEM_NAME_IN_CART)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public int getCountOfProductsInCart() {
        return driver.findElements(UNIQUE_ITEM_IN_CART).size();
    }

    public void deleteSpecificItemFromCart(String deleteItemName) {
        By deleteItem = By.xpath(String.format(SPECIFIC_ITEM_REMOVE_BUTTON_PATTERN, deleteItemName));
        driver.findElement(deleteItem).click();
    }

    public void deleteSpecificItemsFromCart(List<String> itemsForDelete) {
        itemsForDelete.stream().forEach(item -> {
            By deleteItem = By.xpath(String.format(SPECIFIC_ITEM_REMOVE_BUTTON_PATTERN, item));
            driver.findElement(deleteItem).click();
        });
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
