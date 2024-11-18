package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest {

    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.tagName("h4"));
        driver.findElement(By.className("submit-button")).click();

        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Facebo"));
        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//*[contains(@id, 'react-burger-me')]"));
        driver.findElement(By.xpath("//div[contains(text(), 'Swag')]"));
        driver.findElement(By.xpath("//div[contains(text(), 'Swag')]//ancestor::div"));
        driver.findElement(By.xpath("//*[contains(@id, 'menu_button_container')]/descendant::div"));
        driver.findElement(By.xpath("//*[contains(@id, 'menu_button_container')]/following::div"));
        driver.findElement(By.xpath("//*[contains(@id, 'menu_button_container')]/parent::div"));
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/preceding::div"));
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt' and text()='Add to cart']"));

        driver.findElement(By.cssSelector(".bm-menu-wrap"));
        driver.findElement(By.cssSelector(".bm-menu-wrap .bm-menu"));
        driver.findElement(By.cssSelector(".bm-item.menu-item"));
        driver.findElement(By.cssSelector("#react-burger-menu-btn"));
        driver.findElement(By.cssSelector("footer"));
        driver.findElement(By.cssSelector("footer.footer"));
        driver.findElement(By.cssSelector("[id='react-burger-menu-btn']"));
        driver.findElement(By.cssSelector("[class~='menu-item']"));
        driver.findElement(By.cssSelector("[id|='react']"));
        driver.findElement(By.cssSelector("[id^='react']"));
        driver.findElement(By.cssSelector("[id*='-menu-btn']"));
    }
}
