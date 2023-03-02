package ivi.actions.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Метод производит проверку что переданный элемент кликабелен, возвращает WebElement
 */
public class OnCanClick {

    private final ChromeDriver driver;

    public OnCanClick(ChromeDriver driver) {
        this.driver = driver;
    }

    protected WebElement onCanClick(By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }
}
