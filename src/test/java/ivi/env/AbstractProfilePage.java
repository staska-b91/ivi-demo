package ivi.env;

import org.openqa.selenium.By;

public class AbstractProfilePage {
    protected static final By BUTTONSIGN = By.xpath("//*[contains(text(),\"Войти или зарегистрироваться\")]/parent::button");
}
