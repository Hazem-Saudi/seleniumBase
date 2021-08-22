package com.sumerge.pages;

import com.sumerge.utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopsPage extends BasePage {
    public TopsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-name")
    List<WebElement> itemsList;

    public ItemPage selectItem(String itemName) {
        Wait.waitFor("class", "product-name", driver, 10);
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemName.equals(itemsList.get(i).getText())) {
                itemsList.get(i).click();
                break;
            }
        }
        return new ItemPage(driver);
    }

}
