package ivi;

import ivi.actions.Config;
import ivi.actions.ui.InitDriver;
import ivi.method.FillLoginEmail;
import ivi.method.OpenPageAuthorization;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Тест реализует открытие страницы авторизации
 * и успешный вход действующим пользователем
 */
public class LoginTest {

    @Test
    public void loginWithExistingClient(){
        ChromeDriver driver = new InitDriver().createChromeDriver();
        Config config = new Config();
        driver.get("https://www.ivi.ru/profile");
        new OpenPageAuthorization(driver).run();
        new FillLoginEmail(driver, config.getLogin()).run();
        driver.quit();
    }

}
