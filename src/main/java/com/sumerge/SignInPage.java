package com.sumerge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SignInPage extends PageBase {

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "email_create")
    WebElement signUpEmailBox;
    @FindBy(id = "SubmitCreate")
    WebElement signUpSubmitBox;
    public void signUp(String email){
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
    @FindBy(xpath="//*[@id=\"center_column\"]/div[1]/ol/li")
    WebElement errorMsg;
    public void singIn(String email, String password){
        signInEmailBox.sendKeys(email);
        signInPasswordBox.sendKeys(password);
        signInButton.click();
    }
    public String getErrorMsg(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")));
        return (errorMsg.getText());
    }
}
