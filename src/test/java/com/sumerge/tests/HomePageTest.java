package com.sumerge.tests;

import com.sumerge.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {
    HomePage homePageObject;
    private SoftAssert softly = new SoftAssert();

    @Test
    public void homePageTest() {
        homePageObject = new HomePage(driver);
        homePageObject.clickSignIn();
        String pageTitle = driver.getTitle();
        softly.assertTrue(pageTitle.contains("Login"));
    }
}
