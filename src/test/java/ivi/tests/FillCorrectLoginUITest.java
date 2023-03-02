package ivi.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import ivi.actions.Config;
import ivi.method.BaseTest;
import ivi.pages.ProfilePage;
import org.junit.Test;

/**
 * Тест реализует открытие страницы авторизации
 * и успешный вход действующим пользователем
 */

@Epic("валидация логина")
@Feature("ввод корректного или некорректного логина")
public class FillCorrectLoginUITest extends BaseTest {

    @Test
    @Description("ввод существующего логина при авторизации")
    @Story("/profile:login")
    @DisplayName("попытка ввода корректного login")
    public void loginWithExistingClient() {
        Config config = new Config();
        config.initDriver();  //setProperty
        driver = config.createChromeDriver();

        new ProfilePage(driver)
                .notAuth()
                .runCorrect(config.getLogin());
        driver.quit();
    }
}
