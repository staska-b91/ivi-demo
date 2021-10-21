package ivi.actions;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Класс настраивает путь к Driver в зависмости от используемой ОС
 */
public class InitDriver {

    public InitDriver(){
        String os = System.getProperty("os.name");
        String username = System.getProperty("user.name");
        if (os.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/" + username + "/Documents/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "C:/Users/" + username + "/Documents/chromedriver.exe");//добавить путь
        }
    }

    public ChromeDriver createChromeDriver(){
        return new ChromeDriver();
    }
}
