package com.sumerge.tests;

import com.sumerge.pages.HomePage;
import com.sumerge.utilities.DriverHandler;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {
    HomePage homePageObject;
    private SoftAssert softly = new SoftAssert();

    @Test
    public void homePageTest() {
        homePageObject = new HomePage(DriverHandler.getDriver());
        checkPage("My Store");
    }
}
