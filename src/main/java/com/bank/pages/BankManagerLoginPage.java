package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerLoginPage extends Utility {

    //By addCustomerTab = By.xpath("//button[normalize-space()='Add Customer']");
    //By openAccountTab = By.xpath("//button[normalize-space()='Open Account']");
    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomerTab;

    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccountTab;

    public BankManagerLoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void clickOnAddCustomerTab(){

        pmClickOnElement(addCustomerTab);
    }

    public void clickOnOpenAccountTab(){

        pmClickOnElement(openAccountTab);
    }
}
