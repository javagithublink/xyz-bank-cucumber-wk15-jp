package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends Utility {

    private static final Logger log = LogManager.getLogger(CustomersPage.class.getName());


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
        PageFactory.initElements(driver, this);
    }

    public void verifyLogOutButtonDisplayed() {

        pmWaitUntilVisibilityOfElementLocated(By.xpath("//button[normalize-space()='Logout']"), 20);
        boolean actual = logOutButton.isDisplayed();
        Assert.assertTrue(actual);
       log.info("Verifying logout button displayed : "+logOutButton.toString());

    }

    public void verifyYourNameTextDisplayed(String fName, String lName) {
        String actual = pmGetTextFromElement(nameText);
        Assert.assertEquals("wrong name displayed", fName.trim() + " " + lName.trim(), actual);
        log.info("Verifying user can logout successfully"+ nameText.getText());
    }

    public void clickOnLogOutButton() {

        pmClickOnElement(logOutButton);
    }

    public void verifySuccessfulLogout() {
        String expected = "Your Name";
        String actual = pmGetTextFromElement(yourNameText);
        //Assert.assertEquals("user has not logged out successfully",expected,actual.contains("Your Name"));
        Assert.assertTrue(actual.contains("Your Name"));


    }

}
