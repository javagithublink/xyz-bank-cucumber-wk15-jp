package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(OpenAccountPage.class.getName());

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchText;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyText;

    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement processButton;

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    AddCustomerPage addCustomerPage = new AddCustomerPage();


    public void searchCustomer(String fName, String lName) {

        pmSelectByVisibleTextFromDropDown(searchText, fName.trim() + " " + lName.trim());
        log.info("Search customer name to open account : " + searchText.toString());
    }

    public void selectCurrency(String currency) {
        pmwaitWithThreadSleep(10);
        pmSelectByVisibleTextFromDropDown(currencyText, currency);
        log.info("Select currency : " + currencyText.toString());
    }

    public void clickOnProcessButton() {
        pmwaitWithThreadSleep(10);
        pmClickOnElement(processButton);
        //log.info("Clicking on process button : " + processButton.toString());
    }

    public void verifyAccountCreatedSuccessfullyText() {

        pmwaitWithThreadSleep(10);
        String expected = "Account created successfully with account Number :1016";
        String actual = pmGetTextFromAlert();
        Assert.assertTrue(actual.contains(expected));
        log.info("Verifying new account created message : "+actual.toString());
    }

    public void clickOnOkButtonPopUp() {
        pmAcceptAlert();
        log.info("Accepting new account created successfully alert");
    }
}
