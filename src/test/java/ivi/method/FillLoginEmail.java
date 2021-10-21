package ivi.method;

import ivi.actions.ClickFill;
import ivi.actions.OnSuccess;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Метод реализует заполнение поля Логин и проверку того, что кнопка перехода паролю активна
 */
public class FillLoginEmail {

    private static final By INPUTLOGIN = By.xpath("//input[@data-test='input_login']");
    private static final By BUTTONNEXT = By.xpath("//button[@data-test='button_continue']");

    private final ChromeDriver driver;
    private final String login;

    public FillLoginEmail(ChromeDriver driver, String login){
        this.driver = driver;
        this.login = login;
    }

    public void run(){
        new ClickFill(driver, INPUTLOGIN, login).clickFill();
        Assert.assertTrue(new OnSuccess(driver, BUTTONNEXT, 2).onSuccess().isEnabled());
    }
}
