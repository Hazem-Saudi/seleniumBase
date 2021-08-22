package com.sumerge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "sf-with-ul")
    WebElement womenSectionButton;

    public WomenSectionPage clickWomenSectionBtn() {
        womenSectionButton.click();
        return new WomenSectionPage(driver);
    }
}
