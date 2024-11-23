package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test (testName = "Проверка логина с валидными данными", description = "Проверка логина с валидными данными")
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "Переход на страницу не выполнен");
    }

    @Test (testName = "Проверка логина с пустым именем", description = "Проверка логина с пустым именем")
    public void checkLoginWithEmptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не верное");
    }

    @Test (testName = "Проверка логина с пустым паролем", description = "Проверка логина с пустым паролем")
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не верное");
    }

    @Test (testName = "Проверка логина с неверным паролем", description = "Проверка логина с неверным паролем")
    public void checkLoginWithErrorPassword() {
        loginPage.open();
        loginPage.login("standard_user", "12341233");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не верное");
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "12341233", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test (dataProvider = "loginData", testName = "Проверка всех валидационных сообщений на странице входа в сервис",
            description = "Проверка всех валидационных сообщений на странице входа в сервис")
    public void testAllErrorMessages(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(
                loginPage.getErrorMessage(),
                expectedError,
                "Сообщение об ошибке не верное");
    }
}