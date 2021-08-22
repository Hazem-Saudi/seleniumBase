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


public class CreateAccountPageTest extends BaseTest {

    private SoftAssert softly = new SoftAssert();
    CreateAccountPage createAccountObject;
    HomePage homePageObject;
    SignInPage signInObject;



    @Test(dataProvider = "Creation Data",dataProviderClass = CustomDataProvider.class)
    public void createAccountTest(String email, String password, String firstName,
                                  String lastName, String address1, String city,
                                  String alias, String postcode, String state,
                                  String mobile) throws InterruptedException {
        homePageObject = new HomePage(DriverHandler.getDriver());
        checkPage("My Store");
        signInObject = homePageObject.clickSignIn();
        checkPage("Login - My Store");
        createAccountObject = signInObject.signUp(email);
        checkPage("Login - My Store");
        createAccountObject.setObligatoryFields(password, firstName, lastName,
                address1, city, alias, postcode, state, mobile);
        checkPage("My account - My Store");
        softly.assertTrue(createAccountObject.getTitle().contains("Welcome"));
        softly.assertAll();

    }
}
