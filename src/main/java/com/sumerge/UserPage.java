package com.sumerge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends PageBase{

    public UserPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (className = "sf-with-ul")
    WebElement womenSectionButton;

    public void clickWomenSectionBtn(){
        womenSectionButton.click();
    }
}
