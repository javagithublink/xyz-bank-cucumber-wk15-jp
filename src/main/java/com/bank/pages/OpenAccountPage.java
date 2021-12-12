package com.bank.pages;

import com.bank.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage extends Utility {

//    By searchText = By.xpath("//select[@id='userSelect']");
//    By currencyText = By.xpath("//select[@id='currency']");
//    By processButton = By.xpath("//button[normalize-space()='Process']");

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



    public void searchCustomer(String fName, String lName){

        pmSelectByVisibleTextFromDropDown(searchText,fName.trim()+" "+lName.trim());
    }

    public void selectCurrency(String currency){

        pmSelectByVisibleTextFromDropDown(currencyText,currency);
    }

    public void clickOnProcessButton(){

        pmClickOnElement(processButton);
    }

    public void verifyAccountCreatedSuccessfullyText(){


        String expected = "Account created successfully with account Number :1016";
        String actual = pmGetTextFromAlert();
        Assert.assertEquals("wrong message",expected.substring(0,20),actual.substring(0,20));
    }

    public void clickOnOkButtonPopUp(){
        pmAcceptAlert();
    }
}
