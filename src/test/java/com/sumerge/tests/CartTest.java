package com.sumerge.tests;

import com.sumerge.pages.*;
import com.sumerge.utilities.Constants;
import com.sumerge.utilities.ReadFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CartTest extends BaseTest {
    HomePage homePageObject;
    SignInPage signInObject;
    UserPage userPageObject;
    WomenSectionPage womenPageObject;
    TopsPage topsPageObject;
    ItemPage itemPageObject;
    CartPage cartPageObject;
    private SoftAssert softly = new SoftAssert();

    @DataProvider(name = "Cart Test Data")
    public Object[][] testData() throws IOException {
        return (ReadFromExcel.getCertainData(0, 2, 0, 2));

    }

    @Test(dataProvider ="Cart Test Data")
    public void cartTest(String email, String password) {
        homePageObject = new HomePage(driver);
        signInObject = new SignInPage(driver);
        userPageObject = new UserPage(driver);
        womenPageObject = new WomenSectionPage(driver);
        topsPageObject = new TopsPage(driver);
        itemPageObject = new ItemPage(driver);
        cartPageObject = new CartPage(driver);

        homePageObject.clickSignIn();
        signInObject.singIn(email, password);
        userPageObject.clickWomenSectionBtn();
        womenPageObject.clickTopsBtn();
        topsPageObject.selectItem(Constants.itemNames[1]);
        itemPageObject.clickAddToCart();
        itemPageObject.clickProceedToCheckOut();
        softly.assertTrue(cartPageObject.getProductName().equals(Constants.itemNames[1]));
        softly.assertAll();

    }
}
