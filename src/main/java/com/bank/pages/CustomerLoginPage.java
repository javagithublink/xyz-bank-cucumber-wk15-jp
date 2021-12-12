package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends Utility {

    //By searchCustomerText = By.xpath("//select[@id='userSelect']");
    //By logInButton = By.xpath("//button[normalize-space()='Login']");

    @FindBy (xpath = "//select[@id='userSelect']")
    WebElement searchCustomerText;

    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement logInButton;

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void searchCustomer(String fName, String lName){

        pmSelectByVisibleTextFromDropDown(searchCustomerText,fName.trim()+" "+lName.trim());
    }

    public void clickOnLoginButton(){

        pmClickOnElement(logInButton);
    }


}
