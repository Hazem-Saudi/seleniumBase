package com.sumerge.pages;

import com.sumerge.utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Sign in")
    WebElement signInButton;

    public void clickSignIn() {
        Wait.waitFor("linkText","Sign in",driver,10);
        signInButton.click();
    }
}
