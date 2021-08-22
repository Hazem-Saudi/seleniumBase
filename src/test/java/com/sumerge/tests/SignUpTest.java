package com.sumerge.tests;


import com.sumerge.pages.CreateAccountPage;
import com.sumerge.pages.HomePage;
import com.sumerge.pages.SignInPage;
import com.sumerge.utilities.CustomDataProvider;
import com.sumerge.utilities.DriverHandler;
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


    @Test(dataProvider = "Signup Data",dataProviderClass = CustomDataProvider.class)
    public void signInPageTest(String email) {
        homePageObject = new HomePage(DriverHandler.getDriver());
        checkPage("My Store");
        signInObject = homePageObject.clickSignIn();
        checkPage("Login - My Store");
        createAccountObject = signInObject.signUp(email);
        checkPage("Login - My Store");
        System.out.println(createAccountObject.getRegFormTitle());
        softly.assertTrue(createAccountObject.getRegFormTitle().contains("YOUR PERSONAL INFORMATION"));
        softly.assertAll();
    }

}
