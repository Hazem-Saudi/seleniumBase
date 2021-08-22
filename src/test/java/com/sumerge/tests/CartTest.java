package com.sumerge.tests;

import com.sumerge.pages.*;
import com.sumerge.utilities.Constants;
import com.sumerge.utilities.CustomDataProvider;
import com.sumerge.utilities.DriverHandler;
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

    @Test(dataProvider = "Cart Test Data",dataProviderClass = CustomDataProvider.class)
    public void cartTest(String email, String password) {
        homePageObject = new HomePage(DriverHandler.getDriver());
        checkPage("My Store");
        signInObject = homePageObject.clickSignIn();
        checkPage("Login - My Store");
        userPageObject = signInObject.singIn(email, password);
        checkPage("My account - My Store");
        womenPageObject = userPageObject.clickWomenSectionBtn();
        checkPage("Women - My Store");
        topsPageObject = womenPageObject.clickTopsBtn();
        checkPage("Tops - My Store");
        itemPageObject = topsPageObject.selectItem(Constants.itemNames[1]);
        itemPageObject.clickAddToCart();
        cartPageObject = itemPageObject.clickProceedToCheckOut();
        checkPage("Order - My Store");
        softly.assertTrue(cartPageObject.getProductName().equals(Constants.itemNames[1]));
        softly.assertAll();

    }
}
