package ivi.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import ivi.actions.Config;
import ivi.method.BaseTest;
import ivi.pages.ProfilePage;
import org.junit.Test;

@Epic("валидация логина")
@Feature("ввод корректного или некорректного логина")
public class FillWrongLoginUITest extends BaseTest {

    @Test
    @Description("ввод  некорректного логина при авторизации")
    @Story("/profile:login")
    @DisplayName("попытка ввода некорректного login")
    public void loginWithNotExistingClient() {
        Config config = new Config();
        config.initDriver();  //setProperty
        driver = config.createChromeDriver();

        new ProfilePage(driver)
                .notAuth()
                .runWrong("fgdg");

        driver.quit();
    }
}
