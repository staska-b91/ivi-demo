package ivi.pages;

import io.qameta.allure.Step;
import ivi.actions.ui.*;
import ivi.env.AbstractLoginPage;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends AbstractLoginPage {
    protected ChromeDriver driver;

    public LoginPage(ChromeDriver driver){
        this.driver = driver;
    }

    @Step("открытие и проверка страницы ввода логина")
    private void openPageAndCheck(){
        checkPageTitle();
        visibleLogin();
        enabledButtonNextFalse();
    }
    @Step("проверка страницы на шаге ввода логина")
    private void checkPageTitle(){
        Assert.assertTrue(new WaitForVisible(driver, 1, 5, HEADERTEXT).waitForVisible());
        Assert.assertTrue(new OnSuccess(driver).onSuccess(STARTMESSAGECHAT).isDisplayed());
    }
    @Step("поле логина видимо")
    private void visibleLogin(){
        Assert.assertTrue(new OnSuccess(driver, 3).onSuccess(INPUTLOGIN).isDisplayed());
    }
    @Step("кнопка Продолжить не кликабельна")
    private void enabledButtonNextFalse(){
        Assert.assertFalse(new OnSuccess(driver, 1).onSuccess(BUTTONNEXT).isEnabled());
    }
    @Step("кнопка Продолжить кликабельна")
    private void enabledButtonNextTrue(){
        Assert.assertTrue(new OnSuccess(driver, 2).onSuccess(BUTTONNEXT).isEnabled());
    }
    @Step("ввод в поле логина корректного значения")
    public void runCorrect(String login){
        openPageAndCheck();
        runFillLogin(login);
        new ClickButton(driver).clickButton(BUTTONNEXT);
        runVisibleErrorFalse();
        runVisiblePasswordTrue();
    }
    @Step("ошибка не отображается")
    private void runVisibleErrorFalse(){
        Assert.assertFalse(new WaitForVisible(driver,2,3, CHATERROR).waitForVisible());
    }
    @Step("ввод в поле логина некорректного значения")
    public void runWrong( String login){
        openPageAndCheck();
        runFillLogin(login);
        new ClickButton(driver).clickButton(BUTTONNEXT);
        runVisibleErrorTrue();
        runVisiblePasswordFalse();
        checkErrorLogin(new GetText(driver).getText(TEXTERROR));
    }
    @Step("заполнение поля логина")
    private void runFillLogin(String login){
        new ClickFill(driver, INPUTLOGIN, login).clickFill();
        enabledButtonNextTrue();
    }
    @Step("ошибка отображается")
    private void runVisibleErrorTrue(){
        Assert.assertTrue(new WaitForVisible(driver,2,3, CHATERROR).waitForVisible());
    }
    @Step("поле пароля отображается")
    private void runVisiblePasswordTrue(){
        Assert.assertTrue(new WaitForVisible(driver,2,3, PASSWORD).waitForVisible());
    }
    @Step("поле пароля не отображается")
    private void runVisiblePasswordFalse(){
        Assert.assertFalse(new WaitForVisible(driver,2,3, PASSWORD).waitForVisible());
    }
    @Step("сравнение текста ошибки с ожидаемым")
    private void checkErrorLogin(String error){
        Assert.assertEquals(error, "Неправильно указаны данные.");
    }
}
