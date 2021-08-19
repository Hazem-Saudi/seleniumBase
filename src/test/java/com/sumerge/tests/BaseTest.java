package com.sumerge.tests;

import com.sumerge.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.APPLICATION_HOST);
    }

    @AfterMethod
    public void stopDriver() {
        driver.quit();
    }


}
