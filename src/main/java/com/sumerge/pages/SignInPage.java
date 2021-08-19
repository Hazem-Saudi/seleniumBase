package com.sumerge.pages;

import com.sumerge.utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement signUpEmailBox;
    @FindBy(id = "SubmitCreate")
    WebElement signUpSubmitBox;

    public void signUp(String email) {
        signUpEmailBox.sendKeys(email);
        signUpSubmitBox.click();
    }

    @FindBy(id = "email")
    WebElement signInEmailBox;
    @FindBy(id = "passwd")
    WebElement signInPasswordBox;
    @FindBy(id = "SubmitLogin")
    WebElement signInButton;
    @FindBy(className = "info-account")
    WebElement title;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    WebElement errorMsg;

    public void singIn(String email, String password) {
        signInEmailBox.sendKeys(email);
        signInPasswordBox.sendKeys(password);
        signInButton.click();
    }

    public String getErrorMsg() {
        Wait.waitFor("xpath", "//*[@id=\"center_column\"]/div[1]/ol/li", driver, 10);
        return (errorMsg.getText());
    }

    public String getTitle() {
        return (title.getText());
    }

}
