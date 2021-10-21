package ivi.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Метод осуществляет нажатие на кнопку, клик на поле input
 * Производит скролл до элемента(задержка 200 мс)
 * Если элемент доступен для клика, инициируется клик
 */
public class ClickButton {

    private final ChromeDriver driver;
    private final By locator;

    public ClickButton(ChromeDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void clickButton() {
        new Scroll(driver, locator).scroll();
        new Sleep(200).sleep();
        new OnCanClick(driver, locator).onCanClick();
        driver.findElement(locator).click();
    }
}
