package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test (testName = "Проверка количества отображаемых товаров на главной странице",
            description = "Проверка количества отображаемых товаров на главной странице")
    @Description("Проверка количества отображаемых товаров на главной странице")
    public void checkAmountOfProducts() {
        loginPage.open();
        loginPage.login(user, password);

        Assert.assertTrue(productsPage.getCountOfProductsOnProductsPage() >= 6,
                "There is no needed amount of products on products page");
    }

    @Test (testName = "Проверка наличия кнопки сортировки на странице с товарами",
            description = "Проверка наличия кнопки сортировки на странице с товарами")
    @Description("Проверка наличия кнопки сортировки на странице с товарами")
    public void checkSortingButtonPresentsOnThePage() {
        loginPage.open();
        loginPage.login(user, password);

        Assert.assertTrue(productsPage.isSortingButtonPresentsOnPage(),
                "Sorting button wasn't found on 'Products' page");
    }
}