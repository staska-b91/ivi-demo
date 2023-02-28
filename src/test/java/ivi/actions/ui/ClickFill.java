package ivi.actions.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.Objects.requireNonNull;

/**
 * Метод реализует нажатие на выбранный элемент, очистку значения(ожидание 200 мс) и ввод переданного значения
 */
public class ClickFill {
    private final ChromeDriver driver;
    private final By locator;
    private final String text;

    public ClickFill(ChromeDriver driver, By locator, String text) {
        this.driver = driver;
        this.locator = locator;
        this.text = requireNonNull(text, "text не должно быть пустым");
    }

    public void clickFill() {
        new ClickButton(driver, locator).clickButton();
        new OnSuccess(driver, locator, 2).onSuccess().clear();
        new Sleep(200).sleep();
        new ClickButton(driver, locator).clickButton();
        new FillText(driver, locator).fillText(text);
    }
}
