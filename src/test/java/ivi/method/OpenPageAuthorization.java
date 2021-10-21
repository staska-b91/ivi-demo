package ivi.method;

import ivi.actions.ClickButton;
import ivi.actions.OnSuccess;
import ivi.actions.WaitForVisible;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Метод реализует открытие страницы авторизации и проверку отображения обязательных элементов:
 * Заголовка
 * Сообщения чата
 * Кнопок авторизации через VK или FaceBook
 */
public class OpenPageAuthorization {

    private static final By BUTTONSIGN = By.xpath("//span[contains(text(),\"Войти или зарегистрироваться\")]/parent::button");
    private static final By HEADERTEXT = By.xpath("//div[contains(text(),\"Вход или регистрация\")]");
    private static final By STARTMESSAGECHAT = By.xpath("//div[@data-test='message']/div[contains(text(),\"Войдите или зарегистрируйтесь\")]");
    private static final By BUTTONVK = By.xpath("//div[@data-test='button_vk']");
    private static final By BUTTONFACEBOOK = By.xpath("//div[@data-test='button_fb']");
    private static final By INPUTLOGIN = By.xpath("//input[@data-test='input_login']");
    private static final By BUTTONNEXT = By.xpath("//button[@data-test='button_continue']");

    private ChromeDriver driver;

    public OpenPageAuthorization(ChromeDriver driver){
        this.driver = driver;
    }

    public void run(){

        new ClickButton(driver, BUTTONSIGN).clickButton();
        Assert.assertTrue(new WaitForVisible(driver, 1, 5, HEADERTEXT).waitForVisible());

        Assert.assertTrue(new OnSuccess(driver, STARTMESSAGECHAT,1).onSuccess().isDisplayed());
        Assert.assertTrue(new OnSuccess(driver, BUTTONVK, 1).onSuccess().isDisplayed());
        Assert.assertTrue(new OnSuccess(driver, BUTTONFACEBOOK,1).onSuccess().isDisplayed());

        Assert.assertTrue(new OnSuccess(driver, INPUTLOGIN,1).onSuccess().isDisplayed());
        Assert.assertFalse(new OnSuccess(driver, BUTTONNEXT, 2).onSuccess().isEnabled());
    }
}
