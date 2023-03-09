package ivi.actions.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Метод ожидает появления переданного элемента в структуре страницы в течение указанного количества сек
 */
public class OnSuccess {

    private final ChromeDriver driver;
    private final int sec;

    public OnSuccess(ChromeDriver driver, int sec) {
        this.driver = driver;
        this.sec = sec;
    }
    public OnSuccess(ChromeDriver driver) {
        this.driver = driver;
        this.sec = 10;
    }

    public WebElement onSuccess(By locator) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return driver.findElement(locator);
        } catch(Throwable e) {
            throw new RuntimeException("Не дождались появления элемента " + locator);
        }
    }
}
