package com.bank.pages;

import com.bank.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends Utility {



    //By logOutButton = By.xpath("//button[normalize-space()='Logout']");
    //By nameText = By.xpath("//strong//span[@class='fontBig ng-binding']");
    //By depositTab = By.xpath("//button[normalize-space()='Deposit']");
    //By amountField = By.xpath("//input[@placeholder='amount']");
    //By depositButton = By.xpath("//button[@type='submit']");
    //By depositMessage = By.xpath("//span[contains(normalize-space(),'Deposit Successful')]");
    //By withdrawlTab = By.xpath("//button[normalize-space()='Withdrawl']");
    //By withdrawlAmountField = By.xpath("//input[@placeholder='amount']");
    //By withdrawlButton = By.xpath("//button[normalize-space()='Withdraw']");
    //By withdrawlMessage = By.xpath("//span[contains(normalize-space(),'Transaction successful')]");

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logOutButton;


    @CacheLookup
    @FindBy(xpath = "//strong//span[@class='fontBig ng-binding']")
    WebElement nameText;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Your Name :']")
    WebElement yourNameText;



    public CustomersPage() {
        PageFactory.initElements(driver,this)   ;
    }

    public void verifyLogOutButtonDisplayed(){

        pmWaitUntilVisibilityOfElementLocated(By.xpath("//button[normalize-space()='Logout']"),20);
        boolean actual = logOutButton.isDisplayed();
       Assert.assertTrue(actual);


    }

    public void verifyYourNameTextDisplayed(String fName, String lName){
        String actual = pmGetTextFromElement(nameText);
        Assert.assertEquals("wrong name displayed",fName.trim()+" "+lName.trim(),actual);
    }

    public void clickOnLogOutButton(){

        pmClickOnElement(logOutButton);
    }

    public void verifySuccessfulLogout(){
        String expected = "Your Name";
        String actual = pmGetTextFromElement(yourNameText);
        //Assert.assertEquals("user has not logged out successfully",expected,actual.contains("Your Name"));
        Assert.assertTrue(actual.contains("Your Name"));


    }

}
