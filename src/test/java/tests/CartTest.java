package tests;

import org.testng.annotations.Test;
import products.Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    public void checkAdd1ItemInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton(Products.BACKPACK);
        productsPage.clickShoppingCart();
        String actualProductName = cartPage.getItemNameInCart();
        assertEquals(
                actualProductName,
                Products.BACKPACK,
                "Product " + Products.BACKPACK + " wasn't found in cart");
    }

    @Test
    public void checkAddManyItemsInCart() {
        List<String> products = new ArrayList<>(Arrays.asList(
                Products.LIGHT,
                Products.BACKPACK,
                Products.ONESIE));

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        products.stream().forEach(productsPage::clickAddButton);
        productsPage.clickShoppingCart();

        List<String> actualProductsInCart = cartPage.getItemNamesInCart();
        for (String product : products) {
            assertTrue(
                    actualProductsInCart
                    .contains(product),
                    "Product with name " + product + " wasn't found in cart");
        }
    }

    @Test
    public void checkDelete1ItemFromCart() {
        List<String> products = new ArrayList<>(Arrays.asList(
                Products.BACKPACK,
                Products.LIGHT));

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        products.stream().forEach(productsPage::clickAddButton);
        productsPage.clickShoppingCart();

        int actualCountOfProductsBeforeDelete = cartPage.getCountOfProductsInCart();
        cartPage.deleteSpecificItemFromCart(Products.BACKPACK);
        int actualCountOfProductsAfterDelete = cartPage.getCountOfProductsInCart();
        assertEquals(actualCountOfProductsAfterDelete, actualCountOfProductsBeforeDelete - 1,
                "Count of products wasn't become less");

        List<String> actualProductsInCart = cartPage.getItemNamesInCart();
        for (String product : actualProductsInCart) {
            assertFalse(
                    product
                    .contains(Products.BACKPACK),
                    "Product with name " + Products.BACKPACK + " wasn't deleted");
        }
    }

    @Test
    public void checkDeleteManyItemsFromCart() {
        List<String> products = new ArrayList<>(Arrays.asList(
                Products.LIGHT,
                Products.BACKPACK,
                Products.ONESIE,
                Products.T_SHIRT,
                Products.JACKET));
        List<String> productsForDelete = new ArrayList<>(Arrays.asList(
                Products.LIGHT,
                Products.BACKPACK,
                Products.ONESIE));

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        products.stream().forEach(productsPage::clickAddButton);
        productsPage.clickShoppingCart();

        int actualCountOfProductsBeforeDelete = cartPage.getCountOfProductsInCart();
        cartPage.deleteSpecificItemsFromCart(productsForDelete);
        int actualCountOfProductsAfterDelete = cartPage.getCountOfProductsInCart();
        assertEquals(actualCountOfProductsAfterDelete, actualCountOfProductsBeforeDelete - productsForDelete.size(),
                "Count of products wasn't become less => some products wasn't deleted");

        List<String> actualProductsInCart = cartPage.getItemNamesInCart();
        for (String product : productsForDelete) {
            assertFalse(
                    actualProductsInCart
                    .contains(product),
                    "Product with name " + product + " wasn't deleted");
        }
    }
}