package com.sumerge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenSectionPage extends PageBase{

    public WomenSectionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Tops")
    WebElement topsButton;

    public void clickTopsBtn(){
        topsButton.click();
    }
}
