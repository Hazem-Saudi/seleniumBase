package com.sumerge.pages;

import com.sumerge.utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-name")
    List<WebElement> productNameClass;

    public String getProductName() {
        Wait.waitClass(10,"product-name",driver);
        return (productNameClass.get(productNameClass.size() - 1).getText());
    }
}
