package com.sumerge.tests;

import com.sumerge.utilities.Constants;
import com.sumerge.utilities.DriverHandler;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    private SoftAssert softly = new SoftAssert();

    public void checkPage(String pageTitle){
        softly.assertTrue(DriverHandler.getDriver().getTitle().equals(pageTitle));
        softly.assertAll();
    }

    @BeforeMethod
    public void startDriver() {
        DriverHandler.initiateDriver();
        DriverHandler.getDriver().get(Constants.APPLICATION_HOST);
    }

    @AfterMethod
    public void stopDriver() {
        DriverHandler.quitDriver();
    }


}
