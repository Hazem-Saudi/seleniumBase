package com.sumerge;


import Utilities.ReadFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SignUpTest extends TestBase{
    SignInPage signInObject;
    CreateAccountPage createAccountObject;
    HomePage homePageObject;
    private SoftAssert softly = new SoftAssert();

    @DataProvider(name = "emails")
    public Object[][] testData() throws IOException {
        ReadFromExcel excelObject =new ReadFromExcel();
        return (excelObject.getCertainData(0,2,0,1));
    }

    @Test(dataProvider = "emails")
    public void signInPageTest(String email)  {
        homePageObject=new HomePage(driver);
        homePageObject.clickSignIn();
        signInObject=new SignInPage(driver);
        signInObject.signUp(email);
        createAccountObject=new CreateAccountPage(driver);
        softly.assertTrue(createAccountObject.getRegFormTitle().contains("YOUR PERSONAL INFORMATION"));
        softly.assertAll();
    }

}
