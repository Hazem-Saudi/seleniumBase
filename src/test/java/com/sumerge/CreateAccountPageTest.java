package com.sumerge;

import Utilities.ReadFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;


public class CreateAccountPageTest extends TestBase{

    private SoftAssert softly = new SoftAssert();
    CreateAccountPage createAccountObject;
    HomePage homePageObject;
    SignInPage signInObject;

    @DataProvider(name = "excelData")
    public Object[][] testData() throws IOException {
        ReadFromExcel excelObject =new ReadFromExcel();
        return (excelObject.getCertainData(0,2,0,10));
        //eturn (excelObject.getExcelData());
    }

    @Test(dataProvider = "excelData")
    public void createAccountTest(String email,String password,String firstName,
                                  String lastName, String address1, String city,
                                  String alias, String postcode, String state,
                                  String mobile) throws InterruptedException {
        homePageObject=new HomePage(driver);
        homePageObject.clickSignIn();
        signInObject = new SignInPage(driver);
        createAccountObject = new CreateAccountPage(driver);
        signInObject.signUp(email);
        createAccountObject.setObligatoryFields(password,firstName,lastName,
                address1,city,alias,postcode,state,mobile);
        softly.assertTrue(createAccountObject.title.getText().contains("Welcome"));
        softly.assertAll();

    }
}
