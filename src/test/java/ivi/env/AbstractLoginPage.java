package ivi.env;

import org.openqa.selenium.By;

public class AbstractLoginPage {
    protected static final By HEADERTEXT = By.xpath("//div[contains(text(),\"Вход или регистрация\")]");
    protected static final By STARTMESSAGECHAT = By.xpath("//div[@data-test='message']/div[contains(text(),\"Войдите или зарегистрируйтесь\")]");
    protected static final By INPUTLOGIN = By.xpath("//input[@data-test='input_login']");
    protected static final By BUTTONNEXT = By.xpath("//button[@data-test='button_continue']");
    protected static final By CHATERROR = By.xpath("//div[@class='chatError__content']");
    protected static final By TEXTERROR = By.xpath("//div[@class='chatError__subtitle']");
    protected static final By PASSWORD = By.xpath("//input[@name='email']/parent::form//div[@class='nbl-chatMessage__title']");
}
