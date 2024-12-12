package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import products.Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static products.Credentials.*;

public class CheckoutCartOverviewTest extends BaseTest {

    @Test (testName = "Проверка расчета общей суммы за все товары в корзине",
            description = "Проверка расчета общей суммы за все товары в корзине")
    @Description("Проверка расчета общей суммы за все товары в корзине")
    public void checkTotalAmountForItems() {
        List<String> products = new ArrayList<>(Arrays.asList(
                Products.LIGHT,
                Products.BACKPACK,
                Products.ONESIE));

        loginPage.open();
        loginPage.login(user, password);

        products.stream().forEach(productsPage::clickAddButton);
        productsPage.clickShoppingCart();

        cartPage.clickCheckoutButton();
        checkoutClientInfoPage.fillAllInputs(VALID_NAME, VALID_LAST_NAME, VALID_ZIP_CODE);
        checkoutClientInfoPage.clickContinueButton();
        double expectedTotalPrice = products.stream()
                .mapToDouble(Products.PRODUCT_PRICES::get)
                .sum();
        double actualTotalPrice = checkoutCartOverviewPage.getActualTotalRawPrice();
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total sum counted wrong");
    }
}
