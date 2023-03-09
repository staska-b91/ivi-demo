package ivi.actions.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Метод реализует поиск переданного элемента и инициирует скролл до момента появления
 */
public class Scroll {

    private final ChromeDriver driver;
    public Scroll(ChromeDriver driver) {
        this.driver = driver;
    }

    public void scroll(By locator) {
        WebElement element = new OnSuccess(driver).onSuccess(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
