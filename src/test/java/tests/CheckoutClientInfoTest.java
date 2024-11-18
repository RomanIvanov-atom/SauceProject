package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import products.Products;

import static products.Credentials.*;

public class CheckoutClientInfoTest extends BaseTest {

    @Test
    public void checkFillClientInfoFieldsWithValidData() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickAddButton(Products.BACKPACK);
        productsPage.clickShoppingCart();

        cartPage.clickCheckoutButton();

        checkoutClientInfoPage.fillAllInputs(VALID_NAME, VALID_LAST_NAME, VALID_ZIP_CODE);
        checkoutClientInfoPage.clickContinueButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),
                "'Continue' button doesn't work properly");
    }

    @Test()
    public void checkFillClientInfoFieldsWithInvalidData() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickAddButton(Products.BACKPACK);
        productsPage.clickShoppingCart();

        cartPage.clickCheckoutButton();

        checkoutClientInfoPage.fillAllInputs("", "", "");
        checkoutClientInfoPage.clickContinueButton();
        Assert.assertTrue(checkoutClientInfoPage.isValidationErrorVisible(),
                "Validation error message wasn't found");
    }
}