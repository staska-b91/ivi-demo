package ivi.method;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected ChromeDriver driver;

    @Step("Start the application")
    @Before
    public void setUp(){
        System.out.println("start");
    }
    @Step("Stop the application")
    @After
    public void close(){
        System.out.println("end");
    }
}