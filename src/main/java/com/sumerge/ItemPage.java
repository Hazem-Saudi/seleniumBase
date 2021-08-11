package com.sumerge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends PageBase{
    public ItemPage(WebDriver driver) { super(driver); }
    @FindBy (name = "Submit")
    WebElement addToCartButton;
    @FindBy (linkText = "Proceed to checkout")
    WebElement proceedToCheckoutButton;
    public void clickAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
        addToCartButton.click();
    }
    public void clickProceedToCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Proceed to checkout")));
        proceedToCheckoutButton.click();
    }

}
