package com.sumerge.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public static void waitFor(String type, String typeName, WebDriver driver, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        switch (type) {
            case "class":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className(typeName)));
                break;
            case "cssSelector":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(typeName)));
                break;
            case "name":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.name(typeName)));
                break;
            case "linkText":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(typeName)));
                break;
            case "xpath":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(typeName)));
                break;
        }

    }
}
