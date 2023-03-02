package ivi.actions.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * метод реализует ожидание появления элемента(элемент становится видимым) в течение определенного времени
 * Передается период в сек, в течение которого ожидается появление и общий период ожидания
 */

public class WaitForVisible {

    private final ChromeDriver driver;
    private final int sec;
    private final int max;
    private final By locator;

    public WaitForVisible(ChromeDriver driver, int sec, int max, By locator) {
        this.driver = driver;
        this.sec = sec;
        this.max = max;
        this.locator = locator;
    }

    public boolean waitForVisible() {
        int i=0;
        int s = sec;
        while (i<max) {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(s));
            try {
                WebElement element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
                boolean elementVisible = element.isDisplayed();
                if(elementVisible){
                    return elementVisible;
                }
            } catch(TimeoutException e) {
                continue; // идем на следующий шаг цикла
            }
            finally {
                i+=s;
            }
        }
        return false;
    }
}
