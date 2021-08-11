package com.sumerge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TopsPage extends PageBase{
    public TopsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (className = "product-name")
    List<WebElement> itemsList;
    public void selectItem(String itemName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-name")));
        for (int i=0; i<itemsList.size();i++){
            if (itemName.equals(itemsList.get(i).getText())){
                itemsList.get(i).click();
                break;
            }
        }

    }

}
