package com.sumerge;

import Utilities.Constants;
import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends TestBase{
    HomePage homePageObject;
    SignInPage signInObject;
    UserPage userPageObject;
    WomenSectionPage womenPageObject;
    TopsPage topsPageObject;
    ItemPage itemPageObject;
    CartPage cartPageObject;
    private SoftAssert softly = new SoftAssert();

    @Test
    public void cartTest(){
        homePageObject=new HomePage(driver);
        signInObject = new SignInPage(driver);
        userPageObject =new UserPage(driver);
        womenPageObject = new WomenSectionPage(driver);
        topsPageObject =new TopsPage(driver);
        itemPageObject =new ItemPage(driver);
        cartPageObject = new CartPage(driver);

        homePageObject.clickSignIn();
        signInObject.singIn("valid122@gmail.com","test123456");
        userPageObject.clickWomenSectionBtn();
        womenPageObject.clickTopsBtn();
        topsPageObject.selectItem(Constants.itemNames[1]);
        itemPageObject.clickAddToCart();
        itemPageObject.clickProceedToCheckOut();
        softly.assertTrue(cartPageObject.getProductName().equals(Constants.itemNames[1]));
        softly.assertAll();

    }
}
