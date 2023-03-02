package ivi.pages;

import io.qameta.allure.Step;
import ivi.actions.ui.WaitForVisible;
import ivi.env.AbstractSettingsPage;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class SettingsPage extends AbstractSettingsPage {

    protected ChromeDriver driver;

    public SettingsPage(ChromeDriver driver){
        this.driver = driver;
    }
    @Step("на страницу перешел не автор. пользователь")
    public LoginPage pageSettingsNotAuth(){
        openPageSettings();
        checkButtonNotAuth();
        return goToLoginPage();
    }
    @Step("на страницу перешел автор. пользователь")
    public void pageSettingsAuth(){
        openPageSettings();
        checkButtonAuth();
    }

    @Step("открытие и проверка страницы настроек не авторизованным пользователем")
    private void openPageSettings(){
        driver.get("https://www.ivi.ru/profile/settings");
        Assert.assertTrue(new WaitForVisible(driver,1,3, H1).waitForVisible());
    }
    @Step("проверка кнопки авторизации у авторизованного пользователя")
    private void checkButtonAuth(){
        ProfilePage profile = new ProfilePage(driver);
        profile.checkButtonSignAuth();
    }
    @Step("проверка кнопки авторизации у не авторизованного пользователя")
    private void checkButtonNotAuth(){
        ProfilePage profile = new ProfilePage(driver);
        profile.checkButtonSignNotAuth();
    }
    @Step("переход на страницу авторизации")
    private LoginPage goToLoginPage(){
        ProfilePage profilePage = new ProfilePage(driver);
        return profilePage.goToLoginPage();
    }
}
