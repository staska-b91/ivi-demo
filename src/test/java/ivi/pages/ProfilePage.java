package ivi.pages;

import io.qameta.allure.Step;
import ivi.actions.ui.ClickButton;
import ivi.actions.ui.WaitForVisible;
import ivi.env.AbstractProfilePage;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProfilePage extends AbstractProfilePage {
    protected ChromeDriver driver;

    public ProfilePage(ChromeDriver driver){
        this.driver = driver;
    }
    @Step("открытие странцы профиля не автор. польз.")
    public LoginPage notAuth(){
        goToPageTitle();
        checkButtonSignNotAuth();
        return goToLoginPage();
    }
    @Step("открытие страницы профиля не автор. польз.")
    public void auth(){
        goToPageTitle();
        checkButtonSignAuth();
    }
    @Step("проверка открытия страницы профиля")
    private void goToPageTitle(){
        driver.get("https://www.ivi.ru/profile");
    }
    @Step("проверка открытия страницы на шаге ввода логина")
    public LoginPage goToLoginPage(){
        new ClickButton(driver).clickButton(BUTTONSIGN);
        return new LoginPage(driver);
    }
    @Step("кнопка авторизации отсутвует")
    public void checkButtonSignNotAuth(){
        Assert.assertTrue(new WaitForVisible(driver,1,3, BUTTONSIGN).waitForVisible());
    }
    @Step("кнопка авторизации есть")
    public void checkButtonSignAuth(){
        Assert.assertFalse(new WaitForVisible(driver,1,3, BUTTONSIGN).waitForVisible());
    }
}
