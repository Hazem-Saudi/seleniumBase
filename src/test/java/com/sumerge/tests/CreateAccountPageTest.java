package com.sumerge.tests;

import com.sumerge.pages.CreateAccountPage;
import com.sumerge.pages.HomePage;
import com.sumerge.pages.SignInPage;
import com.sumerge.utilities.ReadFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class CreateAccountPageTest extends BaseTest {

    private SoftAssert softly = new SoftAssert();
    CreateAccountPage createAccountObject;
    HomePage homePageObject;
    SignInPage signInObject;

    @DataProvider(name = "Creation Data")
    public Object[][] testData() throws IOException {
        return (ReadFromExcel.getCertainData(0, 2, 0, 10));

    }

    @Test(dataProvider = "Creation Data")
    public void createAccountTest(String email, String password, String firstName,
                                  String lastName, String address1, String city,
                                  String alias, String postcode, String state,
                                  String mobile) throws InterruptedException {
        homePageObject = new HomePage(driver);
        homePageObject.clickSignIn();
        signInObject = new SignInPage(driver);
        createAccountObject = new CreateAccountPage(driver);
        signInObject.signUp(email);
        createAccountObject.setObligatoryFields(password, firstName, lastName,
                address1, city, alias, postcode, state, mobile);
        softly.assertTrue(createAccountObject.getTitle().contains("Welcome"));
        softly.assertAll();

    }
}
