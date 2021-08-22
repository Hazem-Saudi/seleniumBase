package com.sumerge.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHandler {
    public static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    public static void initiateDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    public static void quitDriver(){
        driver.quit();
    }
}
