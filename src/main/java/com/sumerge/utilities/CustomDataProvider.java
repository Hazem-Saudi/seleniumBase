package com.sumerge.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class CustomDataProvider {
    @DataProvider(name = "Invalid Data")
    public Object[][] getInvalidData() throws IOException {
        return (ReadFromExcel.getCols("InvalidSignInTestData", 0, 2));
    }
    @DataProvider(name = "Valid Data")
    public Object[][] getValidData() throws IOException {
        return (ReadFromExcel.getCols("CreateAccountTestData",0, 2));
    }
    @DataProvider(name = "Cart Test Data")
    public Object[][] getCartTestData() throws IOException {
        return (ReadFromExcel.getCols("CartTestData",0, 2));
    }
    @DataProvider(name = "Creation Data")
    public Object[][] getCreationData() throws IOException {
        return (ReadFromExcel.getCols("CreateAccountTestData", 0, 10));

    }
    @DataProvider(name = "Signup Data")
    public Object[][] getSignupData() throws IOException {
        return (ReadFromExcel.getCols("SignUpTestData", 0, 1));
    }
}
