package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void checkAmountOfProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.getCountOfProductsOnProductsPage() >= 6,
                "There is no needed amount of products on products page");
    }

    @Test
    public void checkSortingButtonPresentsOnThePage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isSortingButtonPresentsOnPage(),
                "Sorting button wasn't found on 'Products' page");
    }
}