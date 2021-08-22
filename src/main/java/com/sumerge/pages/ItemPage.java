package com.sumerge.pages;

import com.sumerge.utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "Submit")
    WebElement addToCartButton;
    @FindBy(linkText = "Proceed to checkout")
    WebElement proceedToCheckoutButton;

    public void clickAddToCart() {
        Wait.waitFor("name", "Submit", driver, 10);
        addToCartButton.click();
    }

    public CartPage clickProceedToCheckOut() {
        Wait.waitFor("linkText", "Proceed to checkout", driver, 10);
        proceedToCheckoutButton.click();
        return new CartPage(driver);
    }

}
