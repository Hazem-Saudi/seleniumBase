package com.sumerge;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends TestBase{
    HomePage homePageObject;
    private SoftAssert softly = new SoftAssert();
    @Test
    public void homePageTest(){
        homePageObject = new HomePage(driver);
        homePageObject.clickSignIn();
        String pageTitle = driver.getTitle();
        softly.assertTrue(pageTitle.contains("Login"));
    }
}
