package com.sumerge.tests;


import com.sumerge.pages.CreateAccountPage;
import com.sumerge.pages.HomePage;
import com.sumerge.pages.SignInPage;
import com.sumerge.utilities.ReadFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class SignUpTest extends BaseTest {
    SignInPage signInObject;
    CreateAccountPage createAccountObject;
    HomePage homePageObject;
    private SoftAssert softly = new SoftAssert();

    @DataProvider(name = "Signup Data")
    public Object[][] testData() throws IOException {
        return (ReadFromExcel.getCertainData(4, 6, 0, 1));
    }

    @Test(dataProvider = "Signup Data")
    public void signInPageTest(String email) {
        homePageObject = new HomePage(driver);
        homePageObject.clickSignIn();
        signInObject = new SignInPage(driver);
        signInObject.signUp(email);
        createAccountObject = new CreateAccountPage(driver);
        softly.assertTrue(createAccountObject.getRegFormTitle().contains("YOUR PERSONAL INFORMATION"));
        softly.assertAll();
    }

}
