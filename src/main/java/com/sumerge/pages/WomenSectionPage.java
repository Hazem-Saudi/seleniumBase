package com.sumerge.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenSectionPage extends BasePage {

    public WomenSectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Tops")
    WebElement topsButton;

    public TopsPage clickTopsBtn() {
        topsButton.click();
        return new TopsPage(driver);
    }
}
