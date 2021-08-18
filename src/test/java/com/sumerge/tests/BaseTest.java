package com.sumerge.tests;

import com.sumerge.utilities.Constants;
import com.sumerge.utilities.ReadFromExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;


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
