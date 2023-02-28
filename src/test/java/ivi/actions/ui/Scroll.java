package ivi.actions.ui;

import ivi.actions.ui.OnSuccess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Метод реализует поиск переданного элемента и инициирует скролл до момента появления
 */
public class Scroll {

    private final ChromeDriver driver;
    private final By locator;

    public Scroll(ChromeDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void scroll() {
        WebElement element = new OnSuccess(driver, locator, 10).onSuccess();
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
