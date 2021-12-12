package com.bank.pages;

import com.bank.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends Utility {
    //By firstName = By.xpath("//input[@placeholder='First Name']");
//    By lastName = By.xpath("//input[@placeholder='Last Name']");
//    By postCode = By.xpath("//input[@placeholder='Post Code']");
//    By buttonAddCustomer = By.xpath("//button[@type='submit']");
    @CacheLookup
    @FindBy (xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @CacheLookup
    @FindBy (xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @CacheLookup
    @FindBy (xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @CacheLookup
    @FindBy (xpath = "//button[@type='submit']")
    WebElement buttonAddCustomer;

    public AddCustomerPage() {

        PageFactory.initElements(driver, this);
    }

    public void addCustomerFirstName(String fName){

        pmSendTextToElement(firstName,fName);

    }


    public void addCustomerLastName(String lName){


        pmSendTextToElement(lastName,lName);

    }


    public void addCustomerPostCode(String pCode){


        pmSendTextToElement(postCode,pCode);
    }


    public void clickOnAddCustomerButton() {

        pmClickOnElement(buttonAddCustomer);
    }

    public void verifyPopUpMessage(){

        String actual = pmGetTextFromAlert();
        String expected = "Customer added successfully with customer id :6";
        Assert.assertEquals("wrong popup message",expected.substring(0,20),actual.substring(0,20));


    }

    public void clickOnOkButtonOnPopUp(){

        pmAcceptAlert();
    }


}
