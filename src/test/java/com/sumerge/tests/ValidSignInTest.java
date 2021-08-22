package com.sumerge.tests;

import com.sumerge.pages.HomePage;
import com.sumerge.pages.SignInPage;
import com.sumerge.utilities.CustomDataProvider;
import com.sumerge.utilities.DriverHandler;
import com.sumerge.utilities.ReadFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ValidSignInTest extends BaseTest {
    SignInPage signInObject;
    HomePage homePageObject;
    private SoftAssert softly = new SoftAssert();

    @Test(dataProvider = "Valid Data",dataProviderClass = CustomDataProvider.class)
    public void signInTest(String email, String password) {
        homePageObject = new HomePage(DriverHandler.getDriver());
        checkPage("My Store");
        signInObject = homePageObject.clickSignIn();
        checkPage("Login - My Store");
        signInObject.singIn(email, password);
        checkPage("My account - My Store");
        softly.assertTrue(signInObject.getTitle().contains("Welcome"));
        softly.assertAll();
    }
}
