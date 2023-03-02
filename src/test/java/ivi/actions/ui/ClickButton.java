package ivi.actions.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Метод осуществляет нажатие на кнопку, клик на поле input
 * Производит скролл до элемента(задержка 200 мс)
 * Если элемент доступен для клика, инициируется клик
 */
public class ClickButton {

    private final ChromeDriver driver;

    public ClickButton(ChromeDriver driver) {
        this.driver = driver;
    }
    public void clickButton(By locator) {
        new Scroll(driver).scroll(locator);
        new Sleep(200).sleep();
        new OnCanClick(driver).onCanClick(locator);
        driver.findElement(locator).click();
    }
}
