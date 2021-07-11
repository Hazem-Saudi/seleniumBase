package com.sumerge;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class InvalidSignInTest extends TestBase{
    SignInPage signInObject;
    HomePage homePageObject;
    private SoftAssert softly = new SoftAssert();

    @DataProvider(name = "Invalid Data")
    public Object[][] testData() throws IOException {
        return (getTestData(2,4,0,2));
    }

    @Test(dataProvider = "Invalid Data")
    public void signInTest(String email, String password){
        homePageObject =new HomePage(driver);
        homePageObject.clickSignIn();
        signInObject=new SignInPage(driver);
        signInObject.singIn(email,password);
        softly.assertTrue(signInObject.getErrorMsg().contains("Authentication failed"));
        softly.assertAll();
    }
}