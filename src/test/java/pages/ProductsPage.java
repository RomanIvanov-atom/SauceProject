package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void clickAddButton(String productName) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, productName));
        driver.findElement(addToCart).click();
    }

    public void clickShoppingCart() {
        driver.findElement(CART_LINK).click();
    }

    public int getCountOfProductsOnProductsPage() {
        return driver.findElements(UNIQUE_ITEM).size();
    }

    public boolean isSortingButtonPresentsOnPage() {
        return driver.findElement(SORTING_DROPDOWN).isDisplayed();
    }
}