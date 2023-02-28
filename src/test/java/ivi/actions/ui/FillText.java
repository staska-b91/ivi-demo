package ivi.actions.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Метод реализует поиск элемента и заполнение указанного элемента переданным текстом
 */
public class FillText {

    private final ChromeDriver driver;
    private final By locator;

    public FillText(ChromeDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void fillText(String text) {
        WebElement  element = new OnSuccess(driver, locator,10).onSuccess();
        element.sendKeys(text);
    }
}
