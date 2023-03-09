package ivi.actions.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetText {
    private final ChromeDriver driver;

    public GetText(ChromeDriver driver) {
        this.driver = driver;
    }

    public String getText(By locator) {
        WebElement elem = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);
        WebElement element = new OnSuccess(driver).onSuccess(locator);
        String attributeValue = element.getText();
        return attributeValue;
    }
}
