package com.sumerge.tests;

import com.sumerge.pages.HomePage;
import com.sumerge.pages.SignInPage;
import com.sumerge.utilities.ReadFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ValidSignInTest extends BaseTest {
    SignInPage signInObject;
    HomePage homePageObject;
    private SoftAssert softly = new SoftAssert();

    @DataProvider(name = "Valid Data")
    public Object[][] testData() throws IOException {
        return (ReadFromExcel.getCertainData(0, 2, 0, 2));
    }

    @Test(dataProvider = "Valid Data")
    public void signInTest(String email, String password) {
        homePageObject = new HomePage(driver);
        homePageObject.clickSignIn();
        signInObject = new SignInPage(driver);
        signInObject.singIn(email, password);
        softly.assertTrue(signInObject.getTitle().contains("Welcome"));
        softly.assertAll();
    }
}
