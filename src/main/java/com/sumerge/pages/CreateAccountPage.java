package com.sumerge.pages;

import com.sumerge.utilities.DriverHandler;
import com.sumerge.utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h3[@class='page-subheading']")
    WebElement registrationFormHeading;

    public String getRegFormTitle() {
        Wait.waitFor("xpath","//div[@class='account_creation']" +
                "//h3[@class='page-subheading']",driver,10);
        return (registrationFormHeading.getText());
    }

    @FindBy(name = "id_gender1")
    WebElement mrButton;
    @FindBy(name = "id_gender2")
    WebElement mrsButton;

    public void selectGender(String gender) {
        if (gender == "male") {
            mrButton.click();
        }
        if (gender == "female") {
            mrsButton.click();
        }
    }

    @FindBy(id = "customer_firstname")
    WebElement personalFirstNameTxtBox;
    @FindBy(id = "customer_lastname")
    WebElement personalLastNameTxtBox;
    @FindBy(id = "passwd")
    WebElement passwordTxtBox;
    @FindBy(id = "days")
    WebElement days;

    public void selectDay(String day) {
        Select daysList = new Select(days);
        daysList.selectByValue(day);
    }

    @FindBy(id = "months")
    WebElement months;

    public void selectMonth(String month) {
        Select monthsList = new Select(months);
        monthsList.selectByValue(month);
    }

    @FindBy(id = "years")
    WebElement years;

    public void selectYear(String year) {
        Select yearsList = new Select(years);
        yearsList.selectByValue(year);
    }

    @FindBy(id = "newsletter")
    WebElement newsletterCheckBox;
    @FindBy(id = "optin")
    WebElement receiveCheckBox;
    @FindBy(id = "firstname")
    WebElement addressFirstNameTxtBox;
    @FindBy(id = "lastname")
    WebElement addressLastNameTxtBox;
    @FindBy(id = "company")
    WebElement companyTxtBox;
    @FindBy(id = "address1")
    WebElement address1TxtBox;
    @FindBy(id = "address2")
    WebElement address2TxtBox;
    @FindBy(id = "city")
    WebElement cityTxtBox;
    @FindBy(id = "postcode")
    WebElement postcodeTxtBox;
    @FindBy(id = "other")
    WebElement addInfoTxtBox;
    @FindBy(id = "phone")
    WebElement homePhoneTxtBox;
    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneTxtBox;
    @FindBy(id = "alias")
    WebElement aliasTxtBox;
    @FindBy(id = "id_country")
    WebElement countryElement;

    public void selectCountry(int country) {
        Select countriesList = new Select(countryElement);
        countriesList.selectByIndex(1);
    }

    @FindBy(id = "id_state")
    WebElement stateElement;

    public void selectState(int state) {
        Select statesList = new Select(stateElement);
        statesList.selectByIndex(1);
    }

    @FindBy(className = "info-account")
    WebElement title;
    @FindBy(id = "submitAccount")
    WebElement submitButton;

    public String getTitle() {
        return (title.getText());
    }

    public void setObligatoryFields(String password, String firstName, String lastName,
                                    String address1, String city, String alias,
                                    String postcode, String state, String mobile) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitAccount")));
        personalFirstNameTxtBox.sendKeys(firstName);
        personalLastNameTxtBox.sendKeys(lastName);
        passwordTxtBox.sendKeys(password);
        address1TxtBox.sendKeys(address1);
        cityTxtBox.sendKeys(city);
        selectCountry(1);
        aliasTxtBox.clear();
        aliasTxtBox.sendKeys(alias);
        postcodeTxtBox.sendKeys(postcode);
        selectState(Integer.parseInt(state));
        mobilePhoneTxtBox.sendKeys(mobile);
        submitButton.click();
    }

}
