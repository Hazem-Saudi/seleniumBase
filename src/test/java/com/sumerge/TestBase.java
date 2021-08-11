package com.sumerge;
import Utilities.Constants;
import Utilities.ReadFromExcel;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

import java.io.IOException;

public class TestBase
{
    public static WebDriver driver;

    public Object[][] getTestData(int startRow,int endRow, int startCol,int endCol) throws IOException {
        ReadFromExcel excelObject =new ReadFromExcel();
        return (excelObject.getCertainData(startRow,endRow,startCol,endCol));
    }
    @BeforeMethod
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.APPLICATION_HOST);
    }
    /*@AfterMethod
    public void stopDriver(){
        driver.quit();
    }*/


}
