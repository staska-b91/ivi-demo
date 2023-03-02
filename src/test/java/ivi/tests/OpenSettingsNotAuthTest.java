package ivi.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import ivi.actions.Config;
import ivi.method.BaseTest;
import ivi.pages.SettingsPage;
import org.junit.Test;

@Epic("Страница Настройки")
@Feature("попытка авторизации со страницы Настройки не автор. польз.")
public class OpenSettingsNotAuthTest extends BaseTest {

    @Test
    @Description("не автор. польз открывает стр Настройки и переходит с нее на страницу авторизации")
    @Story("/settings")
    @DisplayName("вкладка Настройки - попытка авторизации")
    public void loginWithNotAuthClientFromSettingsPage() {
        Config config = new Config();
        config.initDriver();  //setProperty
        driver = config.createChromeDriver();

        new SettingsPage(driver)
                .pageSettingsNotAuth()
                .runCorrect(config.getLogin());
        driver.quit();
    }
}
