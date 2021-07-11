package com.sumerge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase
{
    public static WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver=driver;
       PageFactory.initElements(driver,this);
   }
   public void setTxtBox(WebElement element,String value ){
        element.sendKeys(value);
   }
   public void clickButton(WebElement button){
        button.click();
   }
}
