package ivi;

import io.qameta.allure.Step;
import ivi.actions.Config;
import ivi.method.FillLoginEmail;
import ivi.method.OpenPageAuthorization;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Тест реализует открытие страницы авторизации
 * и успешный вход действующим пользователем
 */
public class LoginTestUI {

    @Test
    public void loginWithExistingClient(){
        Config config = new Config();
        config.initDriver();  //setProperty
        ChromeDriver driver = config.createChromeDriver();
        driver.get("https://www.ivi.ru/profile");
        new OpenPageAuthorization(driver).run();
        new FillLoginEmail(driver, config.getLogin()).run();
        driver.quit();
    }

}
