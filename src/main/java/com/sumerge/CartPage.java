package com.sumerge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver) { super(driver); }
    @FindBy (className = "product-name")
    List<WebElement> productNameClass;
    public String getProductName(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-name")));
        return (productNameClass.get(productNameClass.size()-1).getText());
    }
}
