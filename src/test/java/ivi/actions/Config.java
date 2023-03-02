package ivi.actions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.util.Objects.requireNonNull;

/**
 * Класс для получения значений параметров из переменных
 */
public class Config {

    public String getLogin() {
        return requireNonNull(System.getProperty("USER_NAME"),
                "Необходимо указать параметр -DUSER_NAME");
    }
    public String getPassword() {
        return requireNonNull(System.getProperty("PASSWORD_NAME"),
                "Необходимо указать параметр -DPASSWORD_NAME");
    }
    public String getClientId() {
        return requireNonNull(System.getProperty("CLIENT_ID"),
                "Необходимо указать параметр -DCLIENT_ID");
    }
    public String getClientSecret() {
        return requireNonNull(System.getProperty("CLIENT_SECRET"),
                "Необходимо указать параметр -DCLIENT_SECRET");
    }
    public String getAddressAPI() {
        return requireNonNull(System.getProperty("ADDRESS_API"),
                "Необходимо указать параметр -DADDRESS_API");
    }
    public String getDealerApi() {
        return requireNonNull(System.getProperty("DEALER_API"),
                "Необходимо указать параметр -DDEALER_API");
    }
    public String getDealerAddressApi() {
        return requireNonNull(System.getProperty("DEALER_ADDRESS_API"),
                "Необходимо указать параметр -DDEALER_ADDRESS_API");
    }
    public String getCreditorExternalId() {
        return requireNonNull(System.getProperty("CREDITOR_EXTERNAL_ID"),
                "Необходимо указать параметр -DCREDITOR_EXTERNAL_ID");
    }
    public String getImei() {
        return requireNonNull(System.getProperty("IMEI"),
                "Необходимо указать параметр -DIMEI");
    }
    public ChromeDriver createChromeDriver(){
        String os = System.getProperty("os.name");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("user-agent={{mdm-system=NullMdmSystem}}");

//        if(os.contains("Linux")) {
        options.addArguments("--headless");
        options.addArguments("window-size=2100,3800");
//        }


        ChromeDriver driver = new ChromeDriver(options);

        return driver;
    }
    /**
     * Класс настраивает путь к Driver в зависмости от используемой ОС
     */
    public void initDriver() {
        String os = System.getProperty("os.name");
        String username = System.getProperty("user.name");

        if (os.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/mac/chromedriver");
        } else {
            if (os.contains("Linux")) {
                System.setProperty("webdriver.chrome.driver", "./drivers/linux/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "./drivers/win/chromedriver.exe");//добавить путь
            }
        }
    }
}
